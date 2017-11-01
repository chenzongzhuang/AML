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
public class RatRankRule extends Model<RatRankRule> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，规则代码
     */
	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
    /**
     * 规则ID
     */
	private String rId;
    /**
     * 规则模型
     */
	private String  modle;
    /**
     * 规则因子
     */
	private String  modleInd;
    /**
     * 因子公式
     */
	private String indMatch;
    /**
     * 备注
     */
	private String  remark;
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
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	@Override
	public String toString() {
		return "RatMSet{" +
			"id=" + id +
			", rId=" + rId +
			", modle=" + modle +
			", modleInd=" + modleInd +
			", indMatch=" + indMatch +
			", remark=" + remark +
			", createTime=" + createTime +
			", creator=" + creator +
			", updateTime=" + updateTime +
			", updator=" + updator +
			"}";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getModle() {
		return modle;
	}
	public void setModle(String modle) {
		this.modle = modle;
	}
	public String getModleInd() {
		return modleInd;
	}
	public void setModleInd(String modleInd) {
		this.modleInd = modleInd;
	}
	public String getIndMatch() {
		return indMatch;
	}
	public void setIndMatch(String indMatch) {
		this.indMatch = indMatch;
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
}
