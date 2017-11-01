package com.aml.sys.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.sys.entity.LoginLog;
import com.aml.sys.entity.TaskLog;
import com.aml.sys.service.ILogService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 日志管理类
 * @author ShockBlast
 *
 */

@Controller
@RequestMapping("/sys/log")
public class AllLogController extends BaseController{

	private final static String PRE_FIX = "sys/log/";

	private static Logger LOGGER = Logger.getLogger(AllLogController.class);
	
	@Autowired
	private ILogService opService;
	/**
	 * 操作日志
	 * @return
	 */
	@RequestMapping("/opLog")
	public String toOpLog() {
		return PRE_FIX + "opLog";
	}
	
	/**
	 * 运行日志
	 * @return
	 */
	@RequestMapping("/runLog")
	public String toRunLog() {
		return PRE_FIX + "runLog";
	}
	
	/**
	 * 运行日志
	 * @return
	 */
	@RequestMapping("/taskMonitor")
	public String toTaskMonitor() {
		return PRE_FIX + "taskMonitor";
	}
	
	@ResponseBody
	@RequestMapping("/getRunLogList")
	public AjaxResult getRunLogList() {
		Page<TaskLog> page = getPage();
		page.setRecords(opService.findRunLog(page, request.getParameter("taskType"), request.getParameter("taskState"), request.getParameter("startDate"), request.getParameter("endDate")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	@ResponseBody
	@RequestMapping("/getTaskMonitorList")
	public AjaxResult getTaskMonitorList() {
		Page<TaskLog> page = getPage();
		page.setRecords(opService.findTaskMonitorLog(page,request.getParameter("taskType"), request.getParameter("taskState")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	@ResponseBody
	@RequestMapping("/getOpLogList")
	public AjaxResult getOpLogList() {
		Page<LoginLog> page = getPage();
		page.setRecords(opService.findOpLog(page, request.getParameter("userid"), request.getParameter("ip"), request.getParameter("startDate"), request.getParameter("endDate")));
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
}
