package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 尽职调查
 * @author ASUS
 *
 */
public class TSanDiligence extends Model<TSanDiligence> {

	
	private static final long serialVersionUID = 1L;

	
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id ;//PK
	private String ctifId ;//客户号
	private String content ;//调查内容
	private String attachPath ;//附件路径
	private String attachName ;//附件名称
	private String type ;//尽职调查类型1:普通2:增强
	private String create_user ;//调查人
	private double remark1 ;//预留字段1
	private String remark2 ;//预留字段2
	private Timestamp createTime ;//创建时间
	private Timestamp updateTime ;//修改时间
	
	
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAttachPath() {
		return attachPath;
	}


	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}


	public String getAttachName() {
		return attachName;
	}


	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCreate_user() {
		return create_user;
	}


	public void setCreate_user(String create_user) {
		this.create_user = create_user;
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


	@Override
	public String toString() {
		return "TSanDiligence {id=" + id + ", ctifId=" + ctifId + ", content=" + content + ", attachPath=" + attachPath
				+ ", attachName=" + attachName + ", type=" + type + ", create_user=" + create_user + ", remark1="
				+ remark1 + ", remark2=" + remark2 + ", createTime=" + createTime + ", updateTime=" + updateTime + "}";
	}
	
	
	

}
