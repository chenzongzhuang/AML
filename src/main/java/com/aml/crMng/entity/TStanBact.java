package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 银行账户表
 * 
 * @author ASUS
 *
 */
public class TStanBact extends Model<TStanBact> {

	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;// 主键
	private String ctifId;// 客户号
	private String actCd;// 账户号
	private String actTp;// 账户类型
	private String cabm;// 开户行
	private String payId;// 关联支付账户
	private double remark1;//
	private String remark2;//
	private Timestamp createTime;//
	private Timestamp updateTime;// 修改时间
	private String run_dt;//
	private String hashcode;//

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

	public String getCabm() {
		return cabm;
	}

	public void setCabm(String cabm) {
		this.cabm = cabm;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
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

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getRun_dt() {
		return run_dt;
	}

	public void setRun_dt(String run_dt) {
		this.run_dt = run_dt;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	@Override
	public String toString() {
		return "TStanBact {id=" + id + ", ctifId=" + ctifId + ", actCd=" + actCd + ", actTp=" + actTp + ", cabm=" + cabm
				+ ", payId=" + payId + ", remark1=" + remark1 + ", remark2=" + remark2 + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", run_dt=" + run_dt + ", hashcode=" + hashcode + "}";
	}
	
	
	
}
