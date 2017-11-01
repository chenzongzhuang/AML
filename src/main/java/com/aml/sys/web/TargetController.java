package com.aml.sys.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.sys.entity.TStanMaiin;
import com.aml.sys.entity.TStanTargetCom;
import com.aml.sys.entity.TStanTargetDetail;
import com.aml.sys.entity.TStanTargetRule;
import com.aml.sys.entity.TargetEntity;
import com.aml.sys.entity.TargetRuleDetail;
import com.aml.sys.entity.TradingStandard;
import com.aml.sys.service.TStanMaiinService;
import com.aml.sys.service.TStanTargetDetailService;
import com.aml.sys.service.TargetComService;
import com.aml.sys.service.TargetRuleDetailService;
import com.aml.sys.service.TargetRuleService;
import com.aml.sys.service.TargetService;
import com.aml.sys.service.TradingStandaraMapperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 监测模型
 * </p>
 *
 */

@Controller
public class TargetController extends BaseController{

	@Autowired
	 TargetService targetService; //监测指标
	
	@Autowired
	TStanTargetDetailService tStanTargetDetailService;//监测指标明细
	
	@Autowired
	TargetComService targetComService;//复合指标
	
	@Autowired
	TargetRuleService targetRuleService; //监测规则
	
	@Autowired
	TargetRuleDetailService targetRuleDetailService ;//监测规则明细
	
	@Autowired
	TradingStandaraMapperService tradingStandaraMapperService;
	
	@Autowired
	TStanMaiinService tStanMaiinService;
	
	//监测指标
	@RequestMapping("/target/traget.html")
	public String target(){
		return "/sys/target/traget";
	}
	
	
	@RequestMapping("/target/coin.html")
	public String NaOrArea(TargetRuleDetail targetRuleDetail){
		return "/sys/naOrArea/coin";
	}
	
	@RequestMapping("/target/tStanMaiin.html")
	public String tStanMaiin(TargetRuleDetail targetRuleDetail){
		return "/sys/naOrArea/tStanMaiin";
	}
	
	//监测指标明细
	@RequestMapping("/target/tragetDetail.html")
	public String targetDetail(HttpServletRequest request,TStanTargetDetail tStanTargetDetail){
		request.setAttribute("targetId", tStanTargetDetail.getTargetId());
		return "/sys/target/tragetDetail";
	}
	
	//监测规则
	@RequestMapping("/target/targetRule.html")
	public String targetRule(HttpServletRequest request,TStanTargetDetail tStanTargetDetail){
		return "/sys/target/targetRule";
	}
	
	@RequestMapping("/target/targetRuleDetail.html")
	public String targetRuleDetail(HttpServletRequest request,TargetRuleDetail targetRuleDetail){
		request.setAttribute("targetRuleId", targetRuleDetail.getTargetRuleId());
		return "/sys/target/tragetRuleDetail";
	}
	
	
	@RequestMapping("/target/detail.html")
	public String Detail(HttpServletRequest request,TargetRuleDetail targetRuleDetail){
		return "/sys/targetMeg/TradingStandard";
	}
	
	@RequestMapping("/target/naOrArea.html")
	public String NaOrArea(HttpServletRequest request,TargetRuleDetail targetRuleDetail){
		return "/sys/naOrArea/naOrArea";
	}
	
	
	
	@RequestMapping("/target/AddTarget")
	@ResponseBody
	public void AddTarget(TargetEntity targetEntity) throws Exception{
		
		if(targetEntity.getType().equals("add")){
			 targetEntity.setTargetId(UUID.randomUUID().toString().replace("-", ""));
			 targetService.AddTarget(targetEntity);
		 }
		
		if(targetEntity.getType().equals("delete")){
			 targetService.deleteTargetByTargetId(targetEntity);
		}
		
		if(targetEntity.getType().equals("modify")){
			 targetService.updateTargetByTargetId(targetEntity);
		}
		 
	}
	
	@RequestMapping("/target/AddTargetDetail")
	@ResponseBody
	public void AddTargetDetail(TStanTargetDetail tStanTargetDetail) throws Exception{
		
		if(tStanTargetDetail.getType().equals("add")){
			tStanTargetDetail.setTargetDetailId(UUID.randomUUID().toString().replace("-", ""));
			tStanTargetDetailService.addTarget(tStanTargetDetail);;
		 }
			
		if(tStanTargetDetail.getType().equals("delete")){
			tStanTargetDetailService.deleteTargetByTargetId(tStanTargetDetail);
		}
		
		if(tStanTargetDetail.getType().equals("modify")){
			tStanTargetDetailService.updateTargetByTargetId(tStanTargetDetail);
		}
		 
	}
	
	
	@RequestMapping("/target/QuaryTargetDetail")
	@ResponseBody
	public Map<String, Object> AuqryTargetDetail(TStanTargetDetail tStanTargetDetail) throws Exception{
		
		Page<TStanTargetDetail> page = getPage();
		page.setSize(Integer.valueOf(tStanTargetDetail.getRows())); 
		page.setCurrent(Integer.valueOf(tStanTargetDetail.getPage()));
		page = tStanTargetDetailService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	@RequestMapping("/target/QuaryTarget")
	@ResponseBody
	public Map<String, Object> AuqryTarget(TargetEntity targetEntity) throws Exception{
		
		Page<TargetEntity> page = getPage();
		page.setSize(Integer.valueOf(targetEntity.getRows())); 
		page.setCurrent(Integer.valueOf(targetEntity.getPage()));
		page = targetService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	
	
	@RequestMapping("/target/QuaryTargetByNoOrName")
	@ResponseBody
	public Map<String, Object> QuaryTargetByNoOrName(TargetEntity targetEntity) throws Exception{
		
		targetEntity.setCurrentPage();
		targetEntity.setCurrentReslut();
		List<TargetEntity> target=  targetService.findTarget(targetEntity);
		Map<String, Object> resObj = new HashMap<String, Object>();
		targetEntity.setCurrentPage();targetEntity.setCurrentReslut();
		resObj.put("page", targetEntity.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(targetEntity.getRows()))+1+"");
		resObj.put("records", target.size()+"");
		resObj.put("rows", target);
		return resObj;
	}
	
	
	@RequestMapping("/target/AddTargetDetailCom")
	@ResponseBody
	public void AddTargetDetailCom(TStanTargetCom tStanTargetCom) throws Exception{
		
		if(tStanTargetCom.getType().equals("add")){
			tStanTargetCom.setTargetId(UUID.randomUUID().toString().replace("-", ""));
			targetComService.addTargetCom(tStanTargetCom);;
		 }
			
		if(tStanTargetCom.getType().equals("delete")){
			targetComService.deleteTargetComByTargetId(tStanTargetCom);
		}
		
		if(tStanTargetCom.getType().equals("modify")){
			targetComService.updateTargeComtByTargetId(tStanTargetCom);
		}
		 
	}
	
	@RequestMapping("/target/DeleteTargetComByTargetId")
	@ResponseBody
	public void deleteTargetCom(TStanTargetCom tStanTargetCom) throws Exception{
		targetComService.deleteTargetComByTargetId(tStanTargetCom);
	}
	
	
	@RequestMapping("/target/QuaryTargetCom")
	@ResponseBody
	public Map<String, Object> AuqryTargetCom(TStanTargetCom tStanTargetCom) throws Exception{
		
		Page<TStanTargetCom> page = getPage();
		page.setSize(Integer.valueOf(tStanTargetCom.getRows())); 
		page.setCurrent(Integer.valueOf(tStanTargetCom.getPage()));
		page = targetComService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	
	
	@RequestMapping("/target/QuaryTargetComByNoOrName")
	@ResponseBody
	public Map<String, Object> QuaryTargetComByNoOrName(TStanTargetCom tStanTargetCom) throws Exception{
		
		tStanTargetCom.setCurrentPage();
		tStanTargetCom.setCurrentReslut();
		
		List<TStanTargetCom> target=  targetComService.findTargetCom(tStanTargetCom);
		Map<String, Object> resObj = new HashMap<String, Object>();
		tStanTargetCom.setCurrentPage();
		tStanTargetCom.setCurrentReslut();
		resObj.put("page", tStanTargetCom.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(tStanTargetCom.getRows()))+1+"");
		resObj.put("records", target.size()+"");
		resObj.put("rows", target);
		return resObj;
	}
	
	
	
	@RequestMapping("/target/AddTargetDetailRule")
	@ResponseBody
	public void AddTargetRule(TStanTargetRule tStanTargetRule) throws Exception{
		
		if(tStanTargetRule.getType().equals("add")){
			tStanTargetRule.setRuleId(UUID.randomUUID().toString().replace("-", ""));
			targetRuleService.addTarget(tStanTargetRule);;
		 }
			
		if(tStanTargetRule.getType().equals("delete")){
			targetRuleService.deleteTargetByTargetId(tStanTargetRule);;
		}
		
		if(tStanTargetRule.getType().equals("modify")){
			targetRuleService.updateTargetByTargetId(tStanTargetRule);;
		}
		 
	}
	
	@RequestMapping("/target/DeleteTargetRuleByTargetId")
	@ResponseBody
	public void deleteTargetRule(TStanTargetRule tStanTargetRule) throws Exception{
		targetRuleService.deleteTargetByTargetId(tStanTargetRule);;
	}
	
	
	@RequestMapping("/target/QuaryTargetRule")
	@ResponseBody
	public Map<String, Object> AuqryTargetRule(TStanTargetRule tStanTargetRule) throws Exception{
		
		Page<TStanTargetRule> page = getPage();
		page.setSize(Integer.valueOf(tStanTargetRule.getRows())); 
		page.setCurrent(Integer.valueOf(tStanTargetRule.getPage()));
		page = targetRuleService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	
	
	@RequestMapping("/target/QuaryTargetRuleByNoOrName")
	@ResponseBody
	public Map<String, Object> QuaryTargetRuleByNoOrName(TStanTargetRule tStanTargetRule) throws Exception{
		
		tStanTargetRule.setCurrentPage();
		tStanTargetRule.setCurrentReslut();
		
		List<TStanTargetRule> target=  targetRuleService.findTarget(tStanTargetRule);
		Map<String, Object> resObj = new HashMap<String, Object>();
		tStanTargetRule.setCurrentPage();
		tStanTargetRule.setCurrentReslut();
		resObj.put("page", tStanTargetRule.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(tStanTargetRule.getRows()))+1+"");
		resObj.put("records", target.size()+"");
		resObj.put("rows", target);
		return resObj;
	}
	
	
	

	@RequestMapping("/target/AddTargetRuleDetail")
	@ResponseBody
	public void AddTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception{
		
		if(targetRuleDetail.getType().equals("add")){
			targetRuleDetail.setRuleId(UUID.randomUUID().toString().replace("-", ""));
			targetRuleDetailService.addTargetRuleDetail(targetRuleDetail);
		 }
			
		if(targetRuleDetail.getType().equals("delete")){
			targetRuleDetailService.deleteTargetByTargetId(targetRuleDetail);;
		}
		
		if(targetRuleDetail.getType().equals("modify")){
			targetRuleDetailService.updateTargetByTargetId(targetRuleDetail);;
		}
		 
	}
	
	@RequestMapping("/target/DeleteTargetRuleDetailByTargetId")
	@ResponseBody
	public void deleteTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception{
		targetRuleDetailService.deleteTargetByTargetId(targetRuleDetail);;
	}
	
	
	@RequestMapping("/target/QuaryTargetRuleDetail")
	@ResponseBody
	public Map<String, Object> AuqryTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception{
		
		Page<TargetRuleDetail> page = getPage();
		page.setSize(Integer.valueOf(targetRuleDetail.getRows())); 
		page.setCurrent(Integer.valueOf(targetRuleDetail.getPage()));
		page = targetRuleDetailService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	
	
	@RequestMapping("/target/QuaryTargetRuleDetailByNoOrName")
	@ResponseBody
	public Map<String, Object> QuaryTargetRuleDetailByNoOrName(TargetRuleDetail targetRuleDetail) throws Exception{
		
		targetRuleDetail.setCurrentPage();
		targetRuleDetail.setCurrentReslut();
		
		List<TargetRuleDetail> target=  targetRuleDetailService.findTargetRuleDetail(targetRuleDetail);
		Map<String, Object> resObj = new HashMap<String, Object>();
		targetRuleDetail.setCurrentPage();
		targetRuleDetail.setCurrentReslut();
		resObj.put("page", targetRuleDetail.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(targetRuleDetail.getRows()))+1+"");
		resObj.put("records", target.size()+"");
		resObj.put("rows", target);
		return resObj;
	}
	
	
	
	@RequestMapping("/target/AddTarget/AddTarget")
	@ResponseBody
	public void AddTarget(TradingStandard  tradingStandard) throws Exception{
		
		if(tradingStandard.getType().equals("add")){
		   tradingStandard.setRuleId(UUID.randomUUID().toString().replace("-", ""));
			tradingStandaraMapperService.addTarget(tradingStandard);
		 }
			
		if(tradingStandard.getType().equals("delete")){
			tradingStandaraMapperService.deleteTargetByTargetId(tradingStandard);;
		}
		
		if(tradingStandard.getType().equals("modify")){
			tradingStandaraMapperService.updateTargetByTargetId(tradingStandard);;
		}
		 
	}
	
	@RequestMapping("/target/DeleteTarget")
	@ResponseBody
	public void deleteTargetl(TradingStandard tradingStandard) throws Exception{
		tradingStandaraMapperService.deleteTargetByTargetId(tradingStandard);;
	}
	
	
	@RequestMapping("/target/QuaryTarget/Detail")
	@ResponseBody
	public Map<String, Object> AuqryTarget(TradingStandard tradingStandard) throws Exception{
		
		Page<TradingStandard> page = getPage();
		page.setSize(Integer.valueOf(tradingStandard.getRows())); 
		page.setCurrent(Integer.valueOf(tradingStandard.getPage()));
		page = tradingStandaraMapperService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	
	
	@RequestMapping("/target/QuaryTarget/find")
	@ResponseBody
	public Map<String, Object> QuaryTarget(TradingStandard tradingStandard) throws Exception{
		
		tradingStandard.setCurrentPage();
		tradingStandard.setCurrentReslut();
		
		List<TradingStandard> target=  tradingStandaraMapperService.findTarget(tradingStandard);
		Map<String, Object> resObj = new HashMap<String, Object>();
		tradingStandard.setCurrentPage();
		tradingStandard.setCurrentReslut();
		resObj.put("page", tradingStandard.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(tradingStandard.getRows()))+1+"");
		resObj.put("records", target.size()+"");
		resObj.put("rows", target);
		return resObj;
	}
	
	@RequestMapping("/target/QuaryTarget/findNaOrEare")
	@ResponseBody
	public AjaxResult QuaryNaOrEare(HttpServletRequest request,TStanMaiin tStanMaiin) throws Exception{
		
		tStanMaiin.setCurrentPage();
		tStanMaiin.setCurrentReslut();
		
		List<TStanMaiin> target=  tStanMaiinService.findTarget(tStanMaiin);
		Map<String, Object> resObj = new HashMap<String, Object>();
		tStanMaiin.setCurrentPage();
		tStanMaiin.setCurrentReslut();
		resObj.put("page", tStanMaiin.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(tStanMaiin.getRows()))+1+"");
		resObj.put("records", tStanMaiinService.qyeryUserTarget(tStanMaiin).size()+"");
		resObj.put("rows", target);
		
		 return  json(resObj);
	}
	
	
	@RequestMapping("/target/DeleteTargetByTargetId")
	@ResponseBody
	public void deleteTarget(TargetEntity targetEntity) throws Exception{
		targetService.deleteTargetByTargetId(targetEntity);
	}
	
	
	
	
	
}
