package com.aml.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.Dept;
import com.aml.sys.entity.LoginLog;
import com.aml.sys.entity.TaskLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 日志记录 Mapper 接口
 * </p>
 *
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {
	
	List<LoginLog> findOpLog(Page page,@Param("userid") String userid,@Param("ip") String ip,@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	List<TaskLog> findRunLog(Page page,@Param("taskType") String taskType,@Param("taskState") String taskState,@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	List<TaskLog> findTaskMonitorLog(Page page,@Param("taskType") String taskType,@Param("taskState") String taskState);
	
	
	List<TaskLog> findTaskMonitorLogByBatchDateAndTaskGroup(@Param("batchDate") String batchDate,@Param("taskGroup") String taskGroup);

}