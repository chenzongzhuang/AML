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
public class TCraMdlRank extends Model<TCraMdlRank> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，等级代码
     */
	@TableId(value="RKCD", type= IdType.AUTO)
	private String rkCd;
    /**
     * 等级名称
     */
	private String rkNm;
    /**
     * 下限分值
     */
	private BigDecimal  minVal;
    /**
     * 上限分值
     */
	private BigDecimal  maxVal;
    /**
     * 描述
     */
	private String rkds;
    /**
     * 评定周期
     */
	private BigDecimal  ascc;
    /**
     * 控制措施
     */
	private String ctms;
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
		return this.rkCd;
	}
	@Override
	public String toString() {
		return "RGMat{" +
			"id=" + id +
			", rkCd=" + rkCd +
			", rkNm=" + rkNm +
			", minVal=" + minVal +
			", maxVal=" + maxVal +
			", rkds=" + rkds +
			", ascc=" + ascc +
			", ctms=" + ctms +
			", createTime=" + createTime +
			", creator=" + creator +
			", updateTime=" + updateTime +
			", updator=" + updator +
			"}";
	}
	public String getRkCd() {
		return rkCd;
	}
	public void setRkCd(String rkCd) {
		this.rkCd = rkCd;
	}
	public String getRkNm() {
		return rkNm;
	}
	public void setRkNm(String rkNm) {
		this.rkNm = rkNm;
	}
	public BigDecimal getMinVal() {
		return minVal;
	}
	public void setMinVal(BigDecimal minVal) {
		this.minVal = minVal;
	}
	public BigDecimal getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(BigDecimal maxVal) {
		this.maxVal = maxVal;
	}
	public String getRkds() {
		return rkds;
	}
	public void setRkds(String rkds) {
		this.rkds = rkds;
	}
	public BigDecimal getAscc() {
		return ascc;
	}
	public void setAscc(BigDecimal ascc) {
		this.ascc = ascc;
	}
	public String getCtms() {
		return ctms;
	}
	public void setCtms(String ctms) {
		this.ctms = ctms;
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
