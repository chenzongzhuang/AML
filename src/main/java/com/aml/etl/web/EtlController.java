package com.aml.etl.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.annotion.BussinessLog;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.DateTime;
import com.aml.core.util.DateTimeKit;
import com.aml.core.util.ShiroUtil;
import com.aml.etl.entity.EtlBaseset;
import com.aml.etl.entity.EtlBatch;
import com.aml.etl.entity.EtlLogMain;
import com.aml.etl.entity.EtlMain;
import com.aml.etl.service.IEtlBasesetService;
import com.aml.etl.service.IEtlBatchService;
import com.aml.etl.service.IEtlLogMainService;
import com.baomidou.mybatisplus.plugins.Page;

@Controller
@RequestMapping("/etl")
public class EtlController extends BaseController{
	
	private final static String PRE_FIX = "etl/";
	private static Logger LOGGER = Logger.getLogger(EtlController.class);
	
	@Autowired
	private IEtlLogMainService etlLogMainService;
	@Autowired
	private IEtlBasesetService baseService;
	
	@Autowired
	private IEtlBatchService batchService;
	@RequestMapping("/etlLogMain")
	public String toEtlLogMain() {
		return PRE_FIX + "etlLogMain";
	}
	
	@RequestMapping("/etlBaseSet")
	public String toEtlBaseSet() {
		EtlBaseset set =  baseService.selectOne(null);
		System.out.println(set);
		request.setAttribute("etlBaseset", set);
		return PRE_FIX + "etlBaseSet";
	}
	
	/*
	 * 修改Etl基础信息
	 */
	@ResponseBody
	@RequestMapping("/editEtlBaseSet")
	@BussinessLog(value = "修改Etl基础信息", key = "username")
	public AjaxResult editEtlBaseSet() {
		EtlBaseset set = new EtlBaseset();
		set.setId(Integer.valueOf(request.getParameter("id")));
		set.setCode(request.getParameter("code"));
		set.setDataBackPath(request.getParameter("dataBackPath"));
		set.setDataPath(request.getParameter("dataPath"));
		set.setDataUnzipPath(request.getParameter("dataUnzipPath"));
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		boolean ss = baseService.updateById(set);
		if(ss){
			resObj.put("arg", "success");
		}else{
			resObj.put("arg", "error");
			System.out.println("传参失败");
		}
		return json(resObj);
	}
	
	
	/**
	 * 进入重跑页面
	 * @return
	 */
	@RequestMapping("/flowManage")
	public String toFlowManage() {
		return PRE_FIX + "etlBatch";
	}
	@ResponseBody
	@RequestMapping("/addBatch")
	@BussinessLog(value = "设置重跑任务", key = "")
	public AjaxResult addFlowManage() {
		//跑批大任务数据
		EtlBatch batch = new EtlBatch();
		batch.setTaskTp("0");
		batch.setRunTp("0");
		batch.setBatchDate(DateTimeKit.today());
		//Etl数据加载
		EtlMain main = new EtlMain();
		main.setName(request.getParameter("name"));
		main.setColDt(request.getParameter("colDt"));
		main.setCreateTime(new Timestamp(new Date().getTime()));
		main.setStepid("step1_target_load");
		main.setDiffDay(request.getParameter("diffDay"));
		main.setTaskTp("0");
		main.setRunTp("0");
		main.setColNum("1");
		main.setRemark(request.getParameter("remark"));
		main.setCreator(ShiroUtil.getUser().getAccount());
		//获取跑批的日期
		DateTime time = DateTimeKit.offsiteDay((DateTimeKit.parse(main.getColDt(),"yyyy-MM-dd")),Integer.valueOf("-"+main.getDiffDay()));
		String btDate = DateTimeKit.formatDate(time);
		System.out.println(btDate);
		batch.setDataDate(btDate);
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		boolean ss = batchService.addTaskBatch(main, batch);
		if(ss){
			resObj.put("arg", "success");
		}else{
			resObj.put("arg", "error");
			System.out.println("传参失败");
		}
		return json(resObj);
	}
	@ResponseBody
	@RequestMapping("/getEtlLogList")
	public AjaxResult getEtlLogList() {
		
		LOGGER.info("获取etl日志");
		Page<EtlLogMain> page = getPage();
		page.setRecords(etlLogMainService.getEtlLogByColDtOrResult(page, request.getParameter("colDt"), request.getParameter("result")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
}
