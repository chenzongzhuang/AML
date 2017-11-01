package com.aml.task.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_task_batch")
public class TaskBatch extends Model<TaskBatch>{
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String batchDate;
	private String dataDate;
	private String taskTp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public String getTaskTp() {
		return taskTp;
	}
	public void setTaskTp(String taskTp) {
		this.taskTp = taskTp;
	}
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
