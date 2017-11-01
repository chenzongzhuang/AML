package com.aml.sys.web;


import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.sys.entity.Dict;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.entity.SysVariable;
import com.aml.sys.entity.User;
import com.aml.sys.service.IDictService;
import com.aml.sys.service.ISysVariableService;
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
 * 字典表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/sys/sysVariable")
public class SysVariableController extends BaseController {
	
	private final static String PRE_FIX = "sys/sysVariable/";

    private static Logger LOGGER = Logger.getLogger(SysVariableController.class);
    
    @Autowired
    private ISysVariableService sysVariableService;

	@RequestMapping("/sysVariable")
    public String toUser() {
        return PRE_FIX + "sysVariable";
    }
	
	@RequestMapping("/showSysVariable")
	@BussinessLog(value = "查询系统变量信息", key = "id")
	public String showSysVariable(@PathParam("id") String id) {
		System.out.println("变量ID："+id);
		SysVariable getSysVariable = sysVariableService.selectById(id);
		request.setAttribute("sysVariable", getSysVariable);
		return PRE_FIX+"sysVariable_edit";
	}
	
	@ResponseBody
	@RequestMapping("/editSysVariable")
	@BussinessLog(value = "修改系统变量", key = "id")
	// TODO 修改系统变量
	public AjaxResult editSysVariable() {
		SysVariable entity = new SysVariable();
		entity.setId(request.getParameter("id"));
		entity.setTypCode(request.getParameter("typCode"));
		entity.setTypKind(request.getParameter("typKind"));
		entity.setTypDesc(request.getParameter("typDesc"));
		entity.setTypName(request.getParameter("typName"));
		boolean ss = sysVariableService.updateById(entity);
		System.out.println(ss);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "success");
		return json(resObj);
	}
	
	@ResponseBody
	@RequestMapping("/getSysVariableList")
    public AjaxResult getSysVariableList() {
		Page<SysVariable> page = getPage();
		page.setRecords(sysVariableService.getSysVariableByNameOrDes(page,"Property", request.getParameter("searchCode"),request.getParameter("searchName")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
    }
}
