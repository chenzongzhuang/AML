package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 个人支付账户表
 * @author ASUS
 *
 */
public class TStanPact extends Model<TStanPact>{
	private static final long serialVersionUID = 1L;

	
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id ;//主键
	private String ctifId ;//客户号
	private String actCd ;//账户号
	private String actTp ;//账户类型1:个人2:机构
	private String actTyp ;//账号类别
	private double remark1 ;//预留字段
	private String remark2 ;//预留字段
	private Timestamp createTime ;//创建时间
	private Timestamp update_time ;//修改时间
	private String runDt ;//
	private String hashcode ;//
	
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCtifId() {
		return ctifId;
	}


	public void setCtifId(String ctifId) {
		this.ctifId = ctifId;
	}


	public String getActCd() {
		return actCd;
	}


	public void setActCd(String actCd) {
		this.actCd = actCd;
	}


	public String getActTp() {
		return actTp;
	}


	public void setActTp(String actTp) {
		this.actTp = actTp;
	}


	public String getActTyp() {
		return actTyp;
	}


	public void setActTyp(String actTyp) {
		this.actTyp = actTyp;
	}


	public double getRemark1() {
		return remark1;
	}


	public void setRemark1(double remark1) {
		this.remark1 = remark1;
	}


	public String getRemark2() {
		return remark2;
	}


	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public Timestamp getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}


	public String getRunDt() {
		return runDt;
	}


	public void setRunDt(String runDt) {
		this.runDt = runDt;
	}


	public String getHashcode() {
		return hashcode;
	}


	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}


	@Override
	public String toString() {
		return "TStanPact {id=" + id + ", ctifId=" + ctifId + ", actCd=" + actCd + ", actTp=" + actTp + ", actTyp="
				+ actTyp + ", remark1=" + remark1 + ", remark2=" + remark2 + ", createTime=" + createTime
				+ ", update_time=" + update_time + ", runDt=" + runDt + ", hashcode=" + hashcode + "}";
	}
	
	
	
}
