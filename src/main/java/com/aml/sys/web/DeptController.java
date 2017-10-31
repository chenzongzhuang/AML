package com.aml.sys.web;

import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.core.util.ShiroUtil;
import com.aml.sys.entity.Dept;
import com.aml.sys.entity.Role;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.entity.User;
import com.aml.sys.service.IDeptService;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/sys/dept")
public class DeptController extends BaseController {

	private final static String PRE_FIX = "sys/dept/";

	private static Logger LOGGER = Logger.getLogger(DeptController.class);

	@Autowired
	private IDeptService deptService;

	@RequestMapping("/dept")
	public String toUser() {
		return PRE_FIX + "dept";
	}

	/**
	 * 新增机构
	 */
	@ResponseBody
	@RequestMapping("/addDept")
	@BussinessLog(value = "新增机构", key = "deptId")
	public AjaxResult addDept() {
		Dept dept = new Dept();
		String pid = super.getPara("pid");
		String code = super.getPara("code");
		String simplename = super.getPara("simplename");
		String fullname = super.getPara("fullname");
		
		dept.setPid(Integer.parseInt(pid));		
		dept.setSimplename(simplename);
		dept.setFullname(fullname);
		dept.setCode(Integer.parseInt(code));
	    deptService.insert(dept);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}

	/*
	 * 修改机构
	 */
	@ResponseBody
	@RequestMapping("/editDept")
	@BussinessLog(value = "修改机构", key = "deptname")
	public AjaxResult editDept() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String pid = request.getParameter("pid");
		String code = request.getParameter("code");
		
		String fullname = request.getParameter("fullname");
		Dept dept = new Dept();
		dept.setId(id);
		dept.setPid(Integer.parseInt(pid));		
		dept.setFullname(fullname);
		dept.setCode(Integer.parseInt(code));
		boolean ss = deptService.updateById(dept);
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}
	@ResponseBody
	@RequestMapping("/showDept")
	@BussinessLog(value = "查询部门", key = "fullname")
	public AjaxResult showDept(@PathParam("id") int id) {
		Dept getDept = deptService.getDeptListById(id);
		request.setAttribute("dept", getDept);
		return json(getDept);
	}

	/**
	 * 删除部门
	 * 
	 * @return delDept
	 */
	@ResponseBody
	@RequestMapping("/delDept")
	@BussinessLog(value = "删除部门", key = "deptname")
	public AjaxResult delDept(@PathParam("id") int id) {
		
		Dept sessionUser = (Dept) request.getSession().getAttribute("dept");
		
		Map<String, Object> resObj = new HashMap<String, Object>();		
		boolean flag = deptService.deleteById(id);
		if (flag) {
			resObj.put("arg", "success");
			return json(resObj);
		} else {
			resObj.put("arg", "error");
			return json(resObj);
		}
	}
	@ResponseBody
	@RequestMapping("/getDeptList")
	public AjaxResult getDeptList() {
		Page<Dept> page = getPage();
		page.setRecords(deptService.getDeptByNameOrId(page, request.getParameter("Name"), request.getParameter("code")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
}
