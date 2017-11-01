package com.aml.task.jobs.dayEnd;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.aml.task.entity.BaseJobRunner;
@Service("archiveRunner")
public class ArchiveRunner implements BaseJobRunner {
	
	
	private static final Logger LOGGER = Logger.getLogger(ArchiveRunner.class);
	@Override
	public void execute() throws JobExecutionException {
		// TODO Auto-generated method stub
		LOGGER.error("ArchiveRunner执行时间: " + new Date());
	}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}

}
