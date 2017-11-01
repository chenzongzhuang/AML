package com.aml.crMng.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.crMng.entity.Cust;
import com.aml.crMng.service.ICustService;
import com.aml.sys.entity.User;
import com.aml.sys.service.IUserService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 客户表前端控制器
 * @author ASUS
 *
 */

public class CustController extends BaseController{
	private final static String PRE_FIX = "crMng/perCustomer/";
	@Autowired
	private ICustService custService;
	
	@Autowired
	private IUserService userService;
	
	/*
	 * 个人客户
	 */
//	@RequestMapping(value="/custAction")
//	public ModelAndView custAction(Model model){
//		int id = (int) session.getAttribute("avtiveId");
//		@SuppressWarnings("unchecked")
//		Map<Integer,List<MenuNode>> menuNodeList = (Map<Integer, List<MenuNode>>) session.getAttribute("menuNodeList");
//		Map<String,Object> map = new HashMap<>();
//		@SuppressWarnings("unchecked")
//		List<Cust> listCust = custService.getCustInfo(map);
//		//model.addAttribute("url", "/crMng/perCustomer/perCustomer.html");
//		//model.addAttribute("listCust",listCust);
//		//model.addAttribute("titles",menuNodeList.get(id));
//		return  new ModelAndView("index").addObject("url","/crMng/perCustomer/perCustomer.html").addObject("listCust",listCust).addObject("titles",menuNodeList.get(id));
//	}
	
	@ResponseBody
	@RequestMapping("/toPerCustomer")
	public AjaxResult toPerCustomer (){
		Page<Cust> page = getPage();
		String custNo= request.getParameter("custNo");
		String custName= request.getParameter("custName");
		String custType= request.getParameter("custType");
		String certNo= request.getParameter("certNo");
		//String custType= request.getParameter("custType");
		String level= request.getParameter("level");
		String jigou= request.getParameter("jigou");
		//String custNo= request.getParameter("custNo");
		//String custNo= request.getParameter("custNo");
		Map<String, Object> resObj = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<>();
		List<Cust> listCust = custService.getCustInfo(page,map);
		
		//List<User> listCust = userService.findAllUser(page, null	, null);
		page.setRecords(listCust);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
 }
	
	@RequestMapping(value = "/{param}", method = RequestMethod.GET)
    public String toCust(@PathVariable String param) {
		System.out.println(param);
        return PRE_FIX + param;
        
    }
	
}
