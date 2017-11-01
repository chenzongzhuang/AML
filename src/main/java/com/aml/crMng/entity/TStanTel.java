package com.aml.crMng.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 联系信息
 * @author ASUS
 *
 */
public class TStanTel extends Model<TStanTel> {
	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	private String id;//主键
	private String ctifId;//客户号
	private String telTp;//电话类型
	private String tel;//联系电话
	private String isRp;//是否报送电话(1:是0:否)
	private String remark1;//预留字段
	private String remark2;//预留字段
	private String createTime;//创建时间
	private String updateTime;//
	private String runDt;//
	private String hashcode;//
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCtifId() {
		return ctifId;
	}


	public void setCtifId(String ctifId) {
		this.ctifId = ctifId;
	}


	public String getTelTp() {
		return telTp;
	}


	public void setTelTp(String telTp) {
		this.telTp = telTp;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(String updateTime) {
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
	protected Serializable pkVal() {
		return this.id;
	}


	@Override
	public String toString() {
		return "TStanTel {id=" + id + ", ctifId=" + ctifId + ", telTp=" + telTp + ", tel=" + tel + ", isRp=" + isRp
				+ ", remark1=" + remark1 + ", remark2=" + remark2 + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", runDt=" + runDt + ", hashcode=" + hashcode + "}";
	}
	
	
	

}
