package com.aml.etl.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_etl_main")
public class EtlMain extends Model<EtlMain>{

	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private String colDt;
	private String taskTp;
	private String runTp;
	private String stepid;
	private String diffDay;
	private String colNum;
	private String remark;
	private Timestamp createTime;
	private String creator;
	
	
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDiffDay() {
		return diffDay;
	}

	public void setDiffDay(String diffDay) {
		this.diffDay = diffDay;
	}

	public String getColNum() {
		return colNum;
	}

	public void setColNum(String colNum) {
		this.colNum = colNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

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

	public String getColDt() {
		return colDt;
	}

	public void setColDt(String colDt) {
		this.colDt = colDt;
	}

	public String getTaskTp() {
		return taskTp;
	}

	public void setTaskTp(String taskTp) {
		this.taskTp = taskTp;
	}

	public String getRunTp() {
		return runTp;
	}

	public void setRunTp(String runTp) {
		this.runTp = runTp;
	}

	public String getStepid() {
		return stepid;
	}

	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}
