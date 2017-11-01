package com.aml.task;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.aml.core.util.SpringContextHolder;
import com.aml.task.entity.BaseJobRunner;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {
	public void getTaskBatch(){  
		//获取需要执行的批量任务
		
		//根据任务的处理类进入不同的类处理数据
		BaseJobRunner runner = SpringContextHolder.getBean("etlRunner");
		try {
			runner.execute();
		} catch (JobExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Hello world, i'm the king of the world!!!");
    } 
    
}
