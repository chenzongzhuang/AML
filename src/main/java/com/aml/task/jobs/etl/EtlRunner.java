package com.aml.task.jobs.etl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.aml.task.entity.BaseJobRunner;

@Service("etlRunner")
public class EtlRunner implements BaseJobRunner{
	
	private static final Logger LOGGER = Logger.getLogger(EtlRunner.class);
	@Override
	public void execute() throws JobExecutionException {
		// TODO Auto-generated method stub
		LOGGER.error("EtlRunner执行时间: " + new Date());  
	}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	
}
