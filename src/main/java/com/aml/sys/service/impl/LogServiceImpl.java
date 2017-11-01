package com.aml.sys.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.LoginLog;
import com.aml.sys.entity.TaskLog;
import com.aml.sys.mapper.LoginLogMapper;
import com.aml.sys.service.ILogService;
import com.baomidou.mybatisplus.plugins.Page;

@Service
public class LogServiceImpl  implements ILogService {
	@Autowired
	LoginLogMapper loginLogMapper;

	@Override
	public int insertOpLog(LoginLog loginLog) {
		// TODO Auto-generated method stub
		return loginLogMapper.insert(loginLog);
	}

	@Override
	public List<LoginLog> findOpLog(Page page, String userid, String ip,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		return loginLogMapper.findOpLog(page, userid, ip, startDate, endDate);
	}

	@Override
	public List<TaskLog> findRunLog(Page page, String taskType,
			String taskState, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return loginLogMapper.findRunLog(page, taskType, taskState, startDate, endDate);
	}

	@Override
	public List<TaskLog> findTaskMonitorLog(Page<TaskLog> page,
			String taskType, String taskState) {
		// TODO Auto-generated method stub
		return loginLogMapper.findTaskMonitorLog(page, taskType, taskState);
	}

	@Override
	public List<TaskLog> findTaskMonitorLogByBatchDateAndTaskGroup(
			String batchDate, String taskGroup) {
		// TODO Auto-generated method stub
		return loginLogMapper.findTaskMonitorLogByBatchDateAndTaskGroup(batchDate, taskGroup);
	}
	
	
}
