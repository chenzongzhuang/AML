
package com.aml.sys.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.core.util.ShiroUtil;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.entity.User;
import com.aml.sys.service.IRoleService;
import com.aml.sys.service.IUserService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {

	private final static String PRE_FIX = "sys/user/";

	private static Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	public String index() {
		return "user";
	}

	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/toList")
	public String toList() {
		return PRE_FIX + "userList";
	}

	@RequestMapping("/user")
	public String toUser() {

		return PRE_FIX + "user";
	}

	/**
	 * 新增用户
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	@BussinessLog(value = "新增用户", key = "username")
	public AjaxResult addUser(User user) {
		String[] checkbox = request.getParameterValues("roleList"); // 根据名字获得checkbox的值，注意是getParameters，后面要加上s，因为是一个数组
		String roleList = "";// 定义一个数组接收checkbox
		for (int i = 0; i < checkbox.length; i++) { // 对checkbox进行遍历
			if (i == checkbox.length - 1) {
				roleList += checkbox[i];
			} else {
				roleList += checkbox[i] + ",";
			}
		}
		User theUser = userService.getByAccount(user.getAccount());
		if (theUser != null) {
			// throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
			// TODO 需要进行重写
			return null;
		}
		String deptId = super.getPara("deptId");
		user.setDeptid(Integer.parseInt(deptId));
		user.setSalt(ShiroUtil.getRandomSalt(5));
		user.setRoleid(roleList);
		user.setPassword(ShiroUtil.md5(user.getPassword(), user.getSalt()));
		boolean ss = userService.insert(user);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}
	/*
	 * 修改用户
	 */
	@ResponseBody
	@RequestMapping("/editUser")
	@BussinessLog(value = "修改用户", key = "username")
	public AjaxResult editUser() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("name");
		String em = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deptId = super.getPara("deptId");
	    Integer sex = Integer.parseInt(request.getParameter("sex"));
		String roleid = request.getParameter("roleid");
		
		User u = new User();
		u.setId(id);
		u.setName(String.valueOf(userName));
		u.setDeptid(Integer.parseInt(deptId));
		u.setEmail(em);
		u.setPhone(phone);
		u.setSex(sex);
		u.setRoleid(roleid);
		boolean ss = userService.updateById(u);
		
		System.out.println(ss);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}

	@RequestMapping("/showUser")
	@BussinessLog(value = "查询用户", key = "username")
	public String showUser(@PathParam("id") int id) {
		User getUser = userService.getUserListById(id);
		// 查询该用户具有的角色
		List<RoleNode> roles = roleService.roleTreeListByRoleId(Convert.toStrArray(",", getUser.getRoleid()));
		request.setAttribute("user", getUser);
		request.setAttribute("roles", roles);
		return "sys/user//user_edit";
	}

	/**
	 * 删除用户
	 * 
	 * @return editUser
	 */
	@ResponseBody
	@RequestMapping("/delUser")
	@BussinessLog(value = "删除用户", key = "username")
	public AjaxResult delUser(@PathParam("id") int id) {
		// String id= request.getParameter("id");
		User sessionUser = (User) request.getSession().getAttribute("user");
		User getUser = userService.getUserListById(id);
		Map<String, Object> resObj = new HashMap<String, Object>();
		if (getUser != null && getUser.getAccount().equals(sessionUser.getAccount())) {
			LOGGER.info("用户的编号为：" + id + " 删除错误，该用户不能对自己进行删除！");
			resObj.put("arg", "error");
			return json(resObj, "该用户不能删除！", BaseController.ERRORCODE);
		}
		boolean flag = userService.deleteById(id);
		if (flag) {
			resObj.put("arg", "success");
			return json(resObj);
		} else {
			resObj.put("arg", "error");
			return json(resObj);
		}
	}

	@ResponseBody
	@RequestMapping("/getUserList")
	public AjaxResult getUserList() {

		Page<User> page = getPage();
		page.setRecords(userService.findAllUser(page, request.getParameter("Name"), request.getParameter("Tel")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());

		return json(resObj);
	}

}

