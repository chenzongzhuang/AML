package com.aml.sys.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.LoginLog;
import com.aml.sys.entity.TaskLog;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 日志 服务类
 * </p>
 *
 */
public interface ILogService {
	public int insertOpLog(LoginLog loginLog);
	List<LoginLog> findOpLog(Page page, String userid, String ip, String startDate,String endDate);
	
	
	List<TaskLog> findRunLog(Page page, String taskType, String taskState, String startDate,String endDate);
	
	List<TaskLog> findTaskMonitorLog(Page<TaskLog> page,String taskType, String taskState);
	
	List<TaskLog> findTaskMonitorLogByBatchDateAndTaskGroup(String batchDate,@Param("taskGroup") String taskGroup);
	
}
