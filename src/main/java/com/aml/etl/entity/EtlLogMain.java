package com.aml.etl.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_etl_log_main")
public class EtlLogMain extends Model<EtlLogMain> {
	
	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private String id;
	private String colDt;
	private String result;
	private Date startTime;
	private String runTime;
	private Date endTime;
	private String errReason;
	private String remark;
	private String batchno;
	
	
	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getColDt() {
		return colDt;
	}






	public void setColDt(String colDt) {
		this.colDt = colDt;
	}






	public String getResult() {
		return result;
	}






	public void setResult(String result) {
		this.result = result;
	}






	public Date getStartTime() {
		return startTime;
	}






	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}






	public String getRunTime() {
		return runTime;
	}






	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}






	public Date getEndTime() {
		return endTime;
	}






	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}






	public String getErrReason() {
		return errReason;
	}






	public void setErrReason(String errReason) {
		this.errReason = errReason;
	}






	public String getRemark() {
		return remark;
	}






	public void setRemark(String remark) {
		this.remark = remark;
	}






	public String getBatchno() {
		return batchno;
	}






	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}






	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
}
