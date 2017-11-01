package com.aml.cRat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class IQulSet extends Model<IQulSet> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，规则代码
     */
	@TableId(value="RLCD", type= IdType.AUTO)
	private BigDecimal rlCd;
    /**
     * 规则类型
     */
	private String rlTp;
    /**
     * 规则名称
     */
	private String  rlNm;
    /**
     * 规则表达式
     */
	private String  rlEp;
    /**
     * 公式说明
     */
	private String remark;
    /**
     * 需要调整的等级
     */
	private String  adjRank;
    /**
     * 目标等级
     */
	private String tgtRank;
	 /**
     * 适用范围
     */
	private String rlSc;
	 /**
     *优先级，从1开始，级别越高越早运算
     */
	private BigDecimal priority;
	/**
     *状态|0:停用,1:启用
     */
	private String status;
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
		return this.rlCd;
	}
	@Override
	public String toString() {
		return "RatMSet{" +
			"id=" + id +
			", rlCd=" + rlCd +
			", rlTp=" + rlTp +
			", rlNm=" + rlNm +
			", rlEp=" + rlEp +
			", remark=" + remark +
			", adjRank=" + adjRank +
			", tgtRank=" + tgtRank +
			", rlSc=" + rlSc +
			", priority=" + priority +
			", status=" + status +
			", createTime=" + createTime +
			", creator=" + creator +
			", updateTime=" + updateTime +
			", updator=" + updator +
			"}";
	}
	public BigDecimal getRlCd() {
		return rlCd;
	}
	public void setRlCd(BigDecimal rlCd) {
		this.rlCd = rlCd;
	}
	public String getRlTp() {
		return rlTp;
	}
	public void setRlTp(String rlTp) {
		this.rlTp = rlTp;
	}
	public String getRlNm() {
		return rlNm;
	}
	public void setRlNm(String rlNm) {
		this.rlNm = rlNm;
	}
	public String getRlEp() {
		return rlEp;
	}
	public void setRlEp(String rlEp) {
		this.rlEp = rlEp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAdjRank() {
		return adjRank;
	}
	public void setAdjRank(String adjRank) {
		this.adjRank = adjRank;
	}
	public String getTgtRank() {
		return tgtRank;
	}
	public void setTgtRank(String tgtRank) {
		this.tgtRank = tgtRank;
	}
	public String getRlSc() {
		return rlSc;
	}
	public void setRlSc(String rlSc) {
		this.rlSc = rlSc;
	}
	public BigDecimal getPriority() {
		return priority;
	}
	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
