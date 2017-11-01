package com.aml.ShadinessSu.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.ShadinessSu.service.ShadinessSubService;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.shadinessSub.entity.ShadinessSub;

@Controller
public class ShadinessSubController extends BaseController{

@Autowired
ShadinessSubService shadinessSubService;

	@RequestMapping("/shadinessSub/shadiness.html")//待确认可疑
	public String shadiness() {
		return "/shadinessSub/shadiness";
	}
	
	@RequestMapping("/shadinessSub/shadinessSub.html")//待审核可疑
	public String shadinessSub() {
		return "/shadinessSub/shadinessSub";
	}
	
	@RequestMapping("/shadinessSub/shadinessSu.html")//已确认可疑
	public String shadinessSu() {
		return "/shadinessSub/shadinessSu";
	}
	
	@RequestMapping("/shadinessSub/shadinessDebar.html")//已排除可疑
	public String shadinessDebar() {
		return "/shadinessSub/shadinessDebar";
	}
	@RequestMapping("/shadinessSub/shadinessMts.html")//历史主体及交易
	public String shadinessMts() {
		return "/shadinessSub/shadinessMts";
	}
	
	@RequestMapping("/shadinessSub/suspiciousReport.html")//可疑报告审核
	public String suspiciousReport() {
		return "/shadinessSub/suspiciousReport";
	}
	
	@RequestMapping("/shadinessSub/autoTask.html")//生成报文及数据包
	public String autoTask() {
		return "/shadinessSub/autoTask";
	}
	
	
	@RequestMapping("/shadinessSub/SuppNtiMan.html")//补充通知
	public String SuppNtiMan() {
		return "/shadinessSub/SuppNtiMan";
	} 
	
	@RequestMapping("/shadinessSub/general Man.html")//补充报告管理 	普通管理
	public String generalMan() {
		return "/shadinessSub/general Man";
	} 
	
	@RequestMapping("/shadinessSub/errorCorrection .html")//补充报告管理 	纠错报告
	public String errorCorrection() {
		return "/shadinessSub/errorCorrection";
	} 
	/*****************************************待确认可疑**************************************************/
	//主体
	@RequestMapping("/shadinessSub/ruler/FindShadinessSub")
	@ResponseBody
	public AjaxResult FindArea(HttpServletRequest request,ShadinessSub shadinessSub) throws Exception{
		
		shadinessSub.setCurrentPage();
		shadinessSub.setCurrentReslut();
		
		List<ShadinessSub> target=  shadinessSubService.find(shadinessSub);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", shadinessSub.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(shadinessSub.getRows()))+1+"");
		resObj.put("records", shadinessSubService.qyeryCount(shadinessSub).size()+"");
		resObj.put("rows", target);
		 return  json(resObj);
	}
	//交易
	@RequestMapping("/shadinessSub/ruler/FindShadinessSubTrd")
	@ResponseBody
	public AjaxResult Findtrd(HttpServletRequest request,ShadinessSub shadinessSub) throws Exception{
		
		shadinessSub.setCurrentPage();
		shadinessSub.setCurrentReslut();
		
		List<ShadinessSub> target=  shadinessSubService.findTrd(shadinessSub);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", shadinessSub.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(shadinessSub.getRows()))+1+"");
		resObj.put("records", shadinessSubService.qyeryCountTrd(shadinessSub).size()+"");
		resObj.put("rows", target);
		 return  json(resObj);
	}
	
	//主体
	@RequestMapping("/shadinessSub/ruler/updateById")
	@ResponseBody
	public void updateById(HttpServletRequest request,ShadinessSub shadinessSub) throws Exception{
		shadinessSubService.updateById(shadinessSub);
	}
	
	@RequestMapping("/shadinessSub/ruler/updateTrdById")
	@ResponseBody
	public void shadinessSubTrd(HttpServletRequest request,ShadinessSub shadinessSub) throws Exception{
		shadinessSubService.updateTrdById(shadinessSub);
	}
	
	/*****************************************待确认可疑**************************************************/
	
	
	

}
