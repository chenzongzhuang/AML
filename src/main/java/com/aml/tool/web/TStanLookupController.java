package com.aml.tool.web;

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
import com.aml.earlyWarning.entity.RollIdDelete;
import com.aml.earlyWarning.entity.TStanAreaRollType;
import com.aml.tool.entity.TStanLookup;
import com.aml.tool.service.TStanLookupService;
import com.baomidou.mybatisplus.plugins.Page;

@Controller
public class TStanLookupController extends BaseController{

	@Autowired
	TStanLookupService tStanLookupService;
	
	@RequestMapping("/tool/ruler/TStanLookup.html")
	public String target(){
		return "/tool/ruler/TStanLookup";
	}
	
	@RequestMapping("/tool/ruler/QueryTStanLookup")
	@ResponseBody
	public Map<String, Object> AuqryTarget(TStanLookup tStanLookup) throws Exception{
		
		Page<TStanLookup> page = getPage();
		page.setSize(Integer.valueOf(tStanLookup.getRows())); 
		page.setCurrent(Integer.valueOf(tStanLookup.getPage()));
		page = tStanLookupService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent()+"");
		resObj.put("total", page.getPages()+"");
		resObj.put("records",  page.getRecords().size()+"");
		resObj.put("rows", page.getRecords());
		return resObj;
	}
	
	@RequestMapping("/tool/ruler/FindTStanLookup")
	@ResponseBody
	public AjaxResult QuaryNaOrEare(HttpServletRequest request,TStanLookup tStanLookup) throws Exception{
		
		tStanLookup.setCurrentPage();
		tStanLookup.setCurrentReslut();
		
		List<TStanLookup> target=  tStanLookupService.find(tStanLookup);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", tStanLookup.getPage()+"");
		resObj.put("total",  target.size()/(Integer.valueOf(tStanLookup.getRows()))+1+"");
		resObj.put("records", tStanLookupService.qyeryCount(tStanLookup).size()+"");
		resObj.put("rows", target);
		
		 return  json(resObj);
	}
	
	
	@RequestMapping("/tool/ruler/AddTStanLookup")
	@ResponseBody
	public void AddTStanAreaRollType(TStanLookup tStanLookup) throws Exception{
		
			tStanLookup.setLookupId(UUID.randomUUID().toString().replace("-", ""));
		   tStanLookupService.add(tStanLookup);
		 
	}
	//findByType
	@RequestMapping("/tool/ruler/UpdateTStanLookup")
	@ResponseBody
	public void updateTStanAreaRollType(TStanLookup tStanLookup) throws Exception{
			tStanLookupService.updateByrollId(tStanLookup);;
	}
	
	@RequestMapping("/tool/ruler/findByType")
	@ResponseBody
	public AjaxResult findByType(TStanLookup tStanLookup) throws Exception{
		return json(tStanLookupService.findByType(tStanLookup));
	}
	
	@RequestMapping("/tool/ruler/DeleteTStanLookup")
	@ResponseBody
	public void deleteTStanAreaRollType(RollIdDelete rollIdDelete) throws Exception{
			tStanLookupService.deleteByrollId(rollIdDelete.getRollIdDelete());
	}
	
}
