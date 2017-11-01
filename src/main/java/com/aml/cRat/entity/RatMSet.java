package com.aml.cRat.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 风险等级维护
 * </p>
 *
 */
public class RatMSet extends Model<RatMSet> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，模型代码
     */
	@TableId(value="MDL_CD", type= IdType.AUTO)
	private String mdlCd;
    /**
     * 模型名称
     */
	private String mdlNm;
    /**
     * 模型版本
     */
	private String  mdlVr;
    /**
     * 适用范围
     */
	private String  mdlSc;
    /**
     * 状态:0:停用,1:启用
     */
	private String status;
    /**
     * 说明
     */
	private String  remark;
    /**
     * 规则文件
     */
	private String mdlDir;
	/**
     * 创建时间
     */
	private Timestamp createTime;
	/**
     * 创建
     */
	private String creator;
	/**
     * 更新时间
     */
	private Timestamp updateTime;
	/**
     * 更新用户id
     */
	private String updator;
	private String id;
	
	@Override
	protected Serializable pkVal() {
		return this.mdlCd;
	}
	@Override
	public String toString() {
		return "RatMSet{" +
			"id=" + id +
			", mdlCd=" + mdlCd +
			", mdlNm=" + mdlNm +
			", mdlVr=" + mdlVr +
			", mdlSc=" + mdlSc +
			", status=" + status +
			", remark=" + remark +
			", mdlDir=" + mdlDir +
			", createTime=" + createTime +
			", creator=" + creator +
			", updateTime=" + updateTime +
			", updator=" + updator +
			"}";
	}
	public String getMdlCd() {
		return mdlCd;
	}
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}
	public String getMdlNm() {
		return mdlNm;
	}
	public void setMdlNm(String mdlNm) {
		this.mdlNm = mdlNm;
	}
	public String getMdlVr() {
		return mdlVr;
	}
	public void setMdlVr(String mdlVr) {
		this.mdlVr = mdlVr;
	}
	public String getMdlSc() {
		return mdlSc;
	}
	public void setMdlSc(String mdlSc) {
		this.mdlSc = mdlSc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMdlDir() {
		return mdlDir;
	}
	public void setMdlDir(String mdlDir) {
		this.mdlDir = mdlDir;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
