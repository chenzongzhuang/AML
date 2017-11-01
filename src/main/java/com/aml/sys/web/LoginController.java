
package com.aml.sys.web;

import com.aml.annotion.BussinessLog;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.core.util.ShiroUtil;
import com.aml.propaganda.entity.CmsNewsEntity;
import com.aml.propaganda.service.CmsNewsService;
import com.aml.sys.common.MenuNode;
import com.aml.sys.entity.*;
import com.aml.sys.service.*;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 */
@Controller
public class LoginController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IDeptService deptService;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IDictService dictService;
	
	@Autowired
	private CmsNewsService cmsNewsService;


	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(){
		//获取菜单列表
		List<Integer> shiroRoleList = ShiroUtil.getUser().getRoleList();
		if (shiroRoleList == null || shiroRoleList.size() == 0) {
			ShiroUtil.getSubject().logout();
			request.setAttribute("tips", "该用户没有角色，无法登陆");
			return "/login";
		}
		String account = ShiroUtil.getUser().getAccount();
		User user = userService.getByAccount(account);
		Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
		List<Integer> roleList = new ArrayList<>();
		for (int roleId : roleArray) {
			roleList.add(roleId);
		}
		//保存用户信息
		session.setAttribute("user", user);
		//获取用户拥有的菜单权限
		List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
		if(menus.size() <= 0){
			LOGGER.info("该用户"+user.getAccount()+"没有对应的菜单，请检查该用户是否配置了菜单权限！");
			return "/login";
		}
		List<MenuNode> titleList = MenuNode.buildTitle(menus);
		Map<Integer,List<MenuNode>> menuNodeList = new HashMap<>();
		List<MenuNode> list = new ArrayList<MenuNode>();
		for (MenuNode menuNode : titleList) {
			list = new ArrayList<MenuNode>();
			list.add(menuNode);
			menuNodeList.put(menuNode.getId(),list);
		}
		//获取所有部门
		List<Dept> deptList = deptService.getListById(null);
		//获取用户拥有的角色
		List<Role> rolesList = roleService.getRoleListByUserRid(user.getRoleid());
		
		//查询宣传培训下面所有的栏目
		List<Dict> dict = dictService.findDictByDmTp("cms_type");
		
		List<CmsNewsEntity> cmsNews = cmsNewsService.findAllCmsNews();
		session.setAttribute("rolesList", rolesList);
		session.setAttribute("deptList", deptList);
		session.setAttribute("menuNodeList", menuNodeList);
		session.setAttribute("menuList",titleList);
		session.setAttribute("cmsNews", cmsNews);
		
		session.setAttribute("dict", dict);
		//默认首页 
		request.setAttribute("url", "main.html");
		return "index";
	}

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login() {
		if (ShiroUtil.isAuthenticated() || ShiroUtil.getUser() != null) {
			return REDIRECT + "/";
		} else {
			return "/login";
		}
	}

	/**
	 * 点击登录按钮进行登录操作
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	@BussinessLog(value = "用户登录", key = "username")
	public String loginVali() {
		Subject currentUser = ShiroUtil.getSubject();
		String userName = super.getPara("username").trim();
		String userPassword = super.getPara("password").trim();
		LOGGER.info("开始对账户为"+userName+" 进行登录操作！");
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(userName,userPassword.toCharArray());
			currentUser.login(token);
		} catch (AuthenticationException e) {
			LOGGER.error("账户为："+userName+" 的用户登录失败，请检验密码或者账号是否正确！");
			return "/login";
		}
		ShiroUser shiroUser = ShiroUtil.getUser();
		ShiroUtil.getSession().setAttribute("sessionFlag", true);
		request.getSession().setAttribute("shiroUser", shiroUser);
		request.getSession().setAttribute("username", shiroUser.getAccount());
		return REDIRECT+"/";
	}
	
	@RequestMapping(value = "/indexHtml")
	public String getIndex() {
		// 判断用户是否存在
		int id = Integer.valueOf(super.getPara("id"));
		//获取该菜单的页面信息
		Menu menu = menuService.selectById(id);
		Map<Integer,List<MenuNode>> menuNodeList = (Map<Integer, List<MenuNode>>) session.getAttribute("menuNodeList");
		request.setAttribute("titles",menuNodeList.get(id));
		System.out.println(menuNodeList.get(id));
		request.setAttribute("url",menu.getUrl());
		request.setAttribute("avtiveId", id);
		session.setAttribute("avtiveId", id);
		return "index";
	}

}

