package com.aml.sys.web;

import com.alibaba.fastjson.JSONObject;
import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.core.util.ShiroUtil;
import com.aml.sys.common.EasyuiTreeNode;
import com.aml.sys.common.MenuNode;
import com.aml.sys.entity.Relation;
import com.aml.sys.entity.Role;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.entity.User;
import com.aml.sys.service.IMenuService;
import com.aml.sys.service.IRelationService;
import com.aml.sys.service.IRoleService;
import com.baomidou.mybatisplus.plugins.Page;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

/**
 * Created by hb on 2017/10/5.
 */
@Controller
@RequestMapping(value = "/sys/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IRelationService relationService;
	
	@Autowired
	private IMenuService menuService;

	private static final String PREFIX = "/sys/role/";
	private static Logger LOGGER = Logger.getLogger(RoleController.class);

	@RequestMapping(value = "role")
	public String roleView() {
		return PREFIX + "role";
	}

	/**
	 * 新增角色
	 */
	@ResponseBody
	@RequestMapping("/addRole")
	@BussinessLog(value = "新增角色", key = "name")
	public AjaxResult addRole() {
		Role role = new Role();
		role.setName(super.getPara("name"));
		role.setTips(super.getPara("tips"));
		String version = super.getPara("version");
		role.setVersion(Integer.parseInt(version));
		boolean ss = roleService.insert(role);
		if(ss){
			String menuListValue = super.getPara("menuListValue");
			System.out.println(menuListValue);
			String[] relationStr = menuListValue.split(",");
			List<Relation> relations = new ArrayList<Relation>();
			Relation relation = new Relation();
			for (int i = 0; i < relationStr.length; i++) {
				relation = new Relation();
				relation.setMenuid(Integer.valueOf(relationStr[i]));
				relation.setRoleid(role.getId());
				relations.add(relation);
			}
			//保存
			boolean bb = relationService.insertBatch(relations);
			System.out.println(bb);
		}
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}

	/*
	 * 修改角色
	 */
	@ResponseBody
	@RequestMapping("/editRole")
	@BussinessLog(value = "修改角色", key = "name")
	public AjaxResult editRole() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String roleName = request.getParameter("name");
		String tips = request.getParameter("tips");
		String version = request.getParameter("version");
		Role r = new Role();
		r.setId(id);
		r.setName(String.valueOf(roleName));
		r.setVersion(Integer.parseInt(version));
		r.setTips(String.valueOf(tips));
		boolean ss = roleService.updateById(r);
		if(ss){
			String menuListupdateValue = super.getPara("menuListupdateValue");
			
			String[] relationStr = menuListupdateValue.split(",");
			List<Relation> relations = new ArrayList<Relation>();
			Relation relation = new Relation();
			for (int i = 0; i < relationStr.length; i++) {
				relation = new Relation();
				relation.setMenuid(Integer.valueOf(relationStr[i]));
				relation.setRoleid(r.getId());
				relations.add(relation);
			}
			//保存
			boolean bb = relationService.updateBatchById(relations);
			System.out.println(bb);
		}
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}

	@ResponseBody
	@RequestMapping("/showRole")
	@BussinessLog(value = "查询角色", key = "name")
	public AjaxResult showRole(@PathParam("id") int id) {
		Role getRole=roleService.getRoleById(id);
		
	    request.setAttribute("role", getRole);

		return json(getRole);
	}
	/**
	 * 删除角色
	 * 
	 * @return delRole
	 */
	@ResponseBody
	@RequestMapping("/delRole")
	@BussinessLog(value = "删除用户", key = "name")
	public AjaxResult delRole(@PathParam("id") int id) {
		// String id= request.getParameter("id");
		Role sessionRole =  (Role) request.getSession().getAttribute("role");
		Role getRole = roleService.getRoleById(id);
		Map<String, Object> resObj = new HashMap<String, Object>();
		boolean flag = roleService.deleteById(id);
		if (flag) {
			resObj.put("arg", "success");
			return json(resObj);
		} else {
			resObj.put("arg", "error");
			return json(resObj);
		}
	}
	
	@RequestMapping(value = "getRoleList")
	@ResponseBody
	public AjaxResult roleList() {
		Page<Role> page = getPage();
		page.setRecords(roleService.selectAllRole(page));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());

		resObj.put("rows", page.getRecords());
		return json(resObj);
	}

	@RequestMapping(value = "getMenuTree")
	@ResponseBody
	public Object getMenuTree() {
		Map<Integer, List<MenuNode>> menuTreeNodeList = (Map<Integer, List<MenuNode>>) request.getSession().getAttribute("menuNodeList");
		List<MenuNode> menuNodes = new ArrayList<MenuNode>();
		for (Integer key : menuTreeNodeList.keySet()) {
			List<MenuNode> s = menuTreeNodeList.get(key);
			menuNodes.add(s.get(0));
		}
		return JSONObject.toJSON(menuNodes);
	}
	
	@RequestMapping(value = "/getMenuTreeOfEdit")
	@ResponseBody
	public Object getMenuTreeOfEdit(@PathParam("id") int id) {
	
		//if(roleid==null||"".equals(roleid)) roleid="35";
		List<EasyuiTreeNode>  nodes = menuService.menuTreeListByMenuIds(ShiroUtil.getUser().getRoleList(),String.valueOf(id));
		List<EasyuiTreeNode>  menuTreeNodeList = EasyuiTreeNode.buildTitle(nodes);
		return JSONObject.toJSON(menuTreeNodeList);
	}
}
