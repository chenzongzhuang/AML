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
public class RatMFct extends Model<RatMFct> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，模型代码
     */
	@TableId(value="ID", type= IdType.AUTO)
	private BigDecimal id;
	 /**
     * 模型代码
     */
	private String mdlCd;
    /**
     * 模型版本
     */
	private String  mdlVer;
    /**
     * 级别层数
     */
	private BigDecimal  lvlNo;
    /**
     * 级别编号
     */
	private String fctLvl;
    /**
     *因子代码
     */
	private String  fctCd;
    /**
     * 因子名称
     */
	private String fctNm;
    /**
     * 因子类型|1:复合因子,2:初级因子
     */
	private String  fctTp;
    /**
     * 因子值类型|1:枚举,2:区间,3:公式
     */
	private String fctKd;
    /**
     *父级别编号
     */
	private String  supLvl;
    /**
     * 计算公式
     */
	private String config;
    /**
     * 状态|1:启用,0:停用
     */
	private String status;
    /**
     *权重
     */
	private BigDecimal  weightVal;
    /**
     * 预警值--因子超过该值时，颜色发生变化预警
     */
	private BigDecimal warnVal;
	/**
     * 缺省值
     */
	private BigDecimal dftVal;
	 /**
     * 备注
     */
	private String remark;
    /**
     *关联一级指标
     */
	private String  indKind;
    /**
     * 关联二级指标
     */
	private String indItem;
	  /**
     * 单多|0单值1多值
     */
	private String mutFlag;
	 /**
     * 多值函数
     */
	private String mutFunc;
    /**
     *数据字典值
     */
	private String  dictKey;
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
			", mdlCd=" + mdlCd +
			", mdlVer=" + mdlVer +
			", lvlNo=" + lvlNo +
			", fctLvl=" + fctLvl +
			", fctCd=" + fctCd +
			", fctNm=" + fctNm +
			", fctTp=" + fctTp +
			", fctKd=" + fctKd +
			", supLvl=" + supLvl +
			", config=" + config +
			", status=" + status +
			", weightVal=" + weightVal +
			", warnVal=" + warnVal +
			", dftVal=" + dftVal +
			", remark=" + remark +
			", indKind=" + indKind +
			", indItem=" + indItem +
			", mutFlag=" + mutFlag +
			", mutFunc=" + mutFunc +
			", dictKey=" + dictKey +
			", createTime=" + createTime +
			", creator=" + creator +
			", updateTime=" + updateTime +
			", updator=" + updator +
			"}";
	}
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getMdlCd() {
		return mdlCd;
	}
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}
	public String getMdlVer() {
		return mdlVer;
	}
	public void setMdlVer(String mdlVer) {
		this.mdlVer = mdlVer;
	}
	public BigDecimal getLvlNo() {
		return lvlNo;
	}
	public void setLvlNo(BigDecimal lvlNo) {
		this.lvlNo = lvlNo;
	}
	public String getFctLvl() {
		return fctLvl;
	}
	public void setFctLvl(String fctLvl) {
		this.fctLvl = fctLvl;
	}
	public String getFctCd() {
		return fctCd;
	}
	public void setFctCd(String fctCd) {
		this.fctCd = fctCd;
	}
	public String getFctNm() {
		return fctNm;
	}
	public void setFctNm(String fctNm) {
		this.fctNm = fctNm;
	}
	public String getFctTp() {
		return fctTp;
	}
	public void setFctTp(String fctTp) {
		this.fctTp = fctTp;
	}
	public String getFctKd() {
		return fctKd;
	}
	public void setFctKd(String fctKd) {
		this.fctKd = fctKd;
	}
	public String getSupLvl() {
		return supLvl;
	}
	public void setSupLvl(String supLvl) {
		this.supLvl = supLvl;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getWeightVal() {
		return weightVal;
	}
	public void setWeightVal(BigDecimal weightVal) {
		this.weightVal = weightVal;
	}
	public BigDecimal getWarnVal() {
		return warnVal;
	}
	public void setWarnVal(BigDecimal warnVal) {
		this.warnVal = warnVal;
	}
	public BigDecimal getDftVal() {
		return dftVal;
	}
	public void setDftVal(BigDecimal dftVal) {
		this.dftVal = dftVal;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIndKind() {
		return indKind;
	}
	public void setIndKind(String indKind) {
		this.indKind = indKind;
	}
	public String getIndItem() {
		return indItem;
	}
	public void setIndItem(String indItem) {
		this.indItem = indItem;
	}
	public String getMutFlag() {
		return mutFlag;
	}
	public void setMutFlag(String mutFlag) {
		this.mutFlag = mutFlag;
	}
	public String getMutFunc() {
		return mutFunc;
	}
	public void setMutFunc(String mutFunc) {
		this.mutFunc = mutFunc;
	}
	public String getDictKey() {
		return dictKey;
	}
	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
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
