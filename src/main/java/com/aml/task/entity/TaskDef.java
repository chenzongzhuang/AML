package com.aml.task.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_task_def")
public class TaskDef extends Model<TaskDef>{
		
	private static final long serialVersionUID = 1L;
	
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private String preId;
	private String groupName;
	private String exeRunner;
	private Boolean state;
	private String errStop;
	private String description;
	private Integer seqNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreId() {
		return preId;
	}
	public void setPreId(String preId) {
		this.preId = preId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getExeRunner() {
		return exeRunner;
	}
	public void setExeRunner(String exeRunner) {
		this.exeRunner = exeRunner;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getErrStop() {
		return errStop;
	}
	public void setErrStop(String errStop) {
		this.errStop = errStop;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
}
