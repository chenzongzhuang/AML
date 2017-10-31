package com.aml.sys.web;


import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.sys.entity.Dept;
import com.aml.sys.entity.Dict;
import com.aml.sys.entity.Relation;
import com.aml.sys.entity.Role;
import com.aml.sys.service.IDictService;
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
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/sys/dict")
public class DictController extends BaseController {
	
	private final static String PRE_FIX = "sys/dict/";

    private static Logger LOGGER = Logger.getLogger(DictController.class);

    
    @Autowired
    private IDictService dictService;

	@RequestMapping("/dict")
    public String toUser() {
        return PRE_FIX + "dict";
    }

	/**
	 * 新增字典
	 */
	@ResponseBody
	@RequestMapping("/addDict")
	@BussinessLog(value = "新增字典", key = "DM_NM")
	public AjaxResult addDict() {
		String dmTp = request.getParameter("DM_TP");
		String dmCd = request.getParameter("DM_CD");
		String dmNm = request.getParameter("DM_NM");
		String dmSp = request.getParameter("DM_SP");
		String dmDs = request.getParameter("dm_ds");
		Dict dict = new Dict();

		dict.setDmTp(dmTp);
		dict.setDmSp(dmSp);
		dict.setDmNm(dmNm);
		dict.setDmCd(dmCd);
		dict.setDmDs(dmDs);

		dictService.insert(dict);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}
	/*
	 * 修改字典
	 */
	@ResponseBody
	@RequestMapping("/editDict")
	@BussinessLog(value = "修改机构", key = "dictname")
	public AjaxResult editDict() {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String dmTp = request.getParameter("DM_TP");
		String dmCd = request.getParameter("DM_CD");
		String dmNm = request.getParameter("DM_NM");
		String dmSp = request.getParameter("DM_SP");
		String dmDs = request.getParameter("dm_ds");
		Dict dict = new Dict();
		dict.setId(id);
		dict.setDmTp(dmTp);
		dict.setDmSp(dmSp);
		dict.setDmNm(dmNm);
		dict.setDmCd(dmCd);
		dict.setDmDs(dmDs);
		boolean ss = dictService.updateById(dict);
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("arg", "suc");
		return json(resObj);
	}
	@ResponseBody
	@RequestMapping("/showDict")
	@BussinessLog(value = "查询部门", key = "DM_NM")
	public AjaxResult showDict(@PathParam("id") int id) {
		Dict getDict = dictService.getDictById(id);
		request.setAttribute("dict", getDict);
		return json(getDict);
	}

	/**
	 * 删除字典
	 * 
	 * @return delDept
	 */
	@ResponseBody
	@RequestMapping("/delDict")
	@BussinessLog(value = "删除字典", key = "dictname")
	public AjaxResult delDict(@PathParam("id") int id) {
		
		Dict sessionDict = (Dict) request.getSession().getAttribute("dict");
		Map<String, Object> resObj = new HashMap<String, Object>();		
		boolean flag = dictService.deleteById(id);
		if (flag) {
			resObj.put("arg", "success");
			return json(resObj);
		} else {
			resObj.put("arg", "error");
			return json(resObj);
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/getDictList")
    public AjaxResult getDictList() {
		Page<Dict> page = getPage();
		page.setRecords(dictService.getDictByNameOrId(page,request.getParameter("dmTp"), request.getParameter("dmCd"),request.getParameter("dmNm")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
    }
}
