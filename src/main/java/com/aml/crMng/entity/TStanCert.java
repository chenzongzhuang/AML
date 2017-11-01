package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 证件信息表
 * @author ASUS
 *
 */
public class TStanCert extends Model<TStanCert> {
	
	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;             // 
	private String ctifId;        // 客户号
	private String ctifTp;        // 
	private String citp;           // 证件类型
	private String ctid;           // 证件号码
	private String citpNt;        // 证件类型说明
	private String issUnt;        // 证件签发机关
	private String address;        // 
	private String ctidEdt;       // 主体证件有效期
	private String isRp;          // 是否报送证件(1:是0:否)
	private String remark1;        // 预留字段
	private String remark2;        // 预留字段
	private Timestamp createTime;    // 创建时间
	private Timestamp updateTime;    // 修改时间
	private String runDt;         //
	private String hashcode;       //
	
	
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


	public String getCtifTp() {
		return ctifTp;
	}


	public void setCtifTp(String ctifTp) {
		this.ctifTp = ctifTp;
	}


	public String getCitp() {
		return citp;
	}


	public void setCitp(String citp) {
		this.citp = citp;
	}


	public String getCtid() {
		return ctid;
	}


	public void setCtid(String ctid) {
		this.ctid = ctid;
	}


	public String getCitpNt() {
		return citpNt;
	}


	public void setCitpNt(String citpNt) {
		this.citpNt = citpNt;
	}


	public String getIssUnt() {
		return issUnt;
	}


	public void setIssUnt(String issUnt) {
		this.issUnt = issUnt;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCtidEdt() {
		return ctidEdt;
	}


	public void setCtidEdt(String ctidEdt) {
		this.ctidEdt = ctidEdt;
	}


	public String getIsRp() {
		return isRp;
	}


	public void setIsRp(String isRp) {
		this.isRp = isRp;
	}


	public String getRemark1() {
		return remark1;
	}


	public void setRemark1(String remark1) {
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
		return "TStanCert {id=" + id + ", ctifId=" + ctifId + ", ctifTp=" + ctifTp + ", citp=" + citp + ", ctid=" + ctid
				+ ", citpNt=" + citpNt + ", issUnt=" + issUnt + ", address=" + address + ", ctidEdt=" + ctidEdt
				+ ", isRp=" + isRp + ", remark1=" + remark1 + ", remark2=" + remark2 + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", runDt=" + runDt + ", hashcode=" + hashcode + "}";
	}

	
	
	
}
