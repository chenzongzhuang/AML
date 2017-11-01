package com.aml.cRat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * <p>
 * 客户评级表
 * </p>
 *
 */
public class DataDctnry extends Model<DataDctnry> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，元素组号
     */
	@TableId(value="GRP_CD")
	private String grpCd;
    /**
     * 元素值
     */
	private String mtdtVal;
    /**
     * 元素国际化语言
     */
	private String mtdtLan;
    /**
     * 元素名称
     */
	private String mtdtNm;
    /**
     * 元素描述
     */
	private String mtdtDesc;
	/**
     * 创建用户id
     */
	private String crtUsrId;
	/**
     * 创建时间
     */
	private Date crtTm;
	/**
     * 更新用户id
     */
	private String updUsrId;
	/**
     * 更新时间
     */
	private Date updTm;
	
	@Override
	protected Serializable pkVal() {
		return this.grpCd;
	}
	@Override
	public String toString() {
		return "DataDctnry{" +
			"grpCd" + grpCd +
			", mtdtVal=" + mtdtVal +
			", mtdtLan=" + mtdtLan +
			", mtdtNm=" + mtdtNm +
			", mtdtDesc=" + mtdtDesc +
			", crtUsrId=" + crtUsrId +
			", crtTm=" + crtTm +
			", updUsrId=" + updUsrId +
			", updTm=" + updTm +
			"}";
	}
	public String getGrpCd() {
		return grpCd;
	}
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	public String getMtdtVal() {
		return mtdtVal;
	}
	public void setMtdtVal(String mtdtVal) {
		this.mtdtVal = mtdtVal;
	}
	public String getMtdtLan() {
		return mtdtLan;
	}
	public void setMtdtLan(String mtdtLan) {
		this.mtdtLan = mtdtLan;
	}
	public String getMtdtNm() {
		return mtdtNm;
	}
	public void setMtdtNm(String mtdtNm) {
		this.mtdtNm = mtdtNm;
	}
	public String getMtdtDesc() {
		return mtdtDesc;
	}
	public void setMtdtDesc(String mtdtDesc) {
		this.mtdtDesc = mtdtDesc;
	}
	public String getCrtUsrId() {
		return crtUsrId;
	}
	public void setCrtUsrId(String crtUsrId) {
		this.crtUsrId = crtUsrId;
	}
	public Date getCrtTm() {
		return crtTm;
	}
	public void setCrtTm(Date crtTm) {
		this.crtTm = crtTm;
	}
	public String getUpdUsrId() {
		return updUsrId;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	public Date getUpdTm() {
		return updTm;
	}
	public void setUpdTm(Date updTm) {
		this.updTm = updTm;
	}

}
