package com.aml.task.entity;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface  BaseJobRunner extends  Job{
//	public void execute(JobExecutionContext context) throws JobExecutionException;
	public void execute() throws JobExecutionException;
}
