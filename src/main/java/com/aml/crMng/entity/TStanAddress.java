package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 地址信息
 * @author ASUS
 *
 */
public class TStanAddress extends Model<TStanAddress> {
	
	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id; //主键
	private String ctifId; //客户号
	private String addressTp; //地址类型
	private String address; //详细地址
	private String isRp; //是否报送地址(1:是0:否)
	private double remark1; //预留字段
	private String remark2; //预留字段
	private Timestamp createTime; //创建时间
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

	public String getAddressTp() {
		return addressTp;
	}

	public void setAddressTp(String addressTp) {
		this.addressTp = addressTp;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsRp() {
		return isRp;
	}

	public void setIsRp(String isRp) {
		this.isRp = isRp;
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

	private Timestamp updateTime; //修改时间
	private String runDt; //
	private String hashcode; //
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TStanAddress {id=" + id + ", ctifId=" + ctifId + ", addressTp=" + addressTp + ", address=" + address
				+ ", isRp=" + isRp + ", remark1=" + remark1 + ", remark2=" + remark2 + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", runDt=" + runDt + ", hashcode=" + hashcode + "}";
	}

	
	
	
	
	
}
