package com.aml.crMng.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BakStanPerson extends Model<BakStanPerson>{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键id
	 */
	@TableId(value="id",type=IdType.AUTO)
	
	private String id; //主键
	private String clientTp; //客户类别(1代表客户,2代表商户)
	private String accountTp; //账户分类
	private String busiType; //业务类型
	private String busiRegNo; //客户号
	private String ctnm; //主体名称
	private String smid; //主体特约商户编号
	private String education; //学历
	private String marriage; //婚姻状况
	private String ceml; //电子邮件
	private String ctvc; //主体的行业类别
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rgdt; //开户日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clsDt; //销户日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date redt; //落地时间
	private String country; //国籍
	private String nation; //民族
	private String sex; //性别
	private String birthday; //出生日期
	private String endtime; //有效期限
	private String agencyCtnm; //代办理人姓名
	private String agencyCitp; //代办理人证件类型
	private String agencyCtid; //代办理人证件号码
	private String agencyCdt; //代办理人证件有效期限
	private String remark; //备注
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tsdt1; //再前交易日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tsdt2; //最近交易日期
	private String extend1; //扩展1
	private String extend2; //扩展2
	private String extend3; //扩展3
	private String extend4; //扩展4
	private String extend5; //名单类别
	private Double curInNum; //
	private Double curInAmt; //
	private Double curOutNum; //
	private Double curOutAmt; //
	private Double accInNum; //
	private Double accInAmt; //
	private Double accOutNum; //
	private Double accOutAmt; //
	private String riskLevel; //风险等级
	private Double compScore; //综合评分
	private Double succNum; //筛出次数
	private Double reptNum; //报送次数
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date stdt; //统计日期
	private String induCode; //行业代码
	private String statFlag; //i-待激活 n-正常c-关闭
	private String merProv; //地区省
	private String merArea; //地区县
	private String merUnit; //分支机构
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nextDate; //下次评级日期
	private String isLine; //是否线上
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime; //创建时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime; //修改时间
	private String runDt; //
	private String hashcode; //
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientTp() {
		return clientTp;
	}
	public void setClientTp(String clientTp) {
		this.clientTp = clientTp;
	}
	public String getAccountTp() {
		return accountTp;
	}
	public void setAccountTp(String accountTp) {
		this.accountTp = accountTp;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	public String getBusiRegNo() {
		return busiRegNo;
	}
	public void setBusiRegNo(String busiRegNo) {
		this.busiRegNo = busiRegNo;
	}
	public String getCtnm() {
		return ctnm;
	}
	public void setCtnm(String ctnm) {
		this.ctnm = ctnm;
	}
	public String getSmid() {
		return smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getCeml() {
		return ceml;
	}
	public void setCeml(String ceml) {
		this.ceml = ceml;
	}
	public String getCtvc() {
		return ctvc;
	}
	public void setCtvc(String ctvc) {
		this.ctvc = ctvc;
	}
	public Date getRgdt() {
		return rgdt;
	}
	public void setRgdt(Date rgdt) {
		this.rgdt = rgdt;
	}
	public Date getClsDt() {
		return clsDt;
	}
	public void setClsDt(Date clsDt) {
		this.clsDt = clsDt;
	}
	public Date getRedt() {
		return redt;
	}
	public void setRedt(Date redt) {
		this.redt = redt;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getAgencyCtnm() {
		return agencyCtnm;
	}
	public void setAgencyCtnm(String agencyCtnm) {
		this.agencyCtnm = agencyCtnm;
	}
	public String getAgencyCitp() {
		return agencyCitp;
	}
	public void setAgencyCitp(String agencyCitp) {
		this.agencyCitp = agencyCitp;
	}
	public String getAgencyCtid() {
		return agencyCtid;
	}
	public void setAgencyCtid(String agencyCtid) {
		this.agencyCtid = agencyCtid;
	}
	public String getAgencyCdt() {
		return agencyCdt;
	}
	public void setAgencyCdt(String agencyCdt) {
		this.agencyCdt = agencyCdt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getTsdt1() {
		return tsdt1;
	}
	public void setTsdt1(Date tsdt1) {
		this.tsdt1 = tsdt1;
	}
	public Date getTsdt2() {
		return tsdt2;
	}
	public void setTsdt2(Date tsdt2) {
		this.tsdt2 = tsdt2;
	}
	public String getExtend1() {
		return extend1;
	}
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	public String getExtend2() {
		return extend2;
	}
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	public String getExtend3() {
		return extend3;
	}
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	public String getExtend4() {
		return extend4;
	}
	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	public String getExtend5() {
		return extend5;
	}
	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}
	public Double getCurInNum() {
		return curInNum;
	}
	public void setCurInNum(Double curInNum) {
		this.curInNum = curInNum;
	}
	public Double getCurInAmt() {
		return curInAmt;
	}
	public void setCurInAmt(Double curInAmt) {
		this.curInAmt = curInAmt;
	}
	public Double getCurOutNum() {
		return curOutNum;
	}
	public void setCurOutNum(Double curOutNum) {
		this.curOutNum = curOutNum;
	}
	public Double getCurOutAmt() {
		return curOutAmt;
	}
	public void setCurOutAmt(Double curOutAmt) {
		this.curOutAmt = curOutAmt;
	}
	public Double getAccInNum() {
		return accInNum;
	}
	public void setAccInNum(Double accInNum) {
		this.accInNum = accInNum;
	}
	public Double getAccInAmt() {
		return accInAmt;
	}
	public void setAccInAmt(Double accInAmt) {
		this.accInAmt = accInAmt;
	}
	public Double getAccOutNum() {
		return accOutNum;
	}
	public void setAccOutNum(Double accOutNum) {
		this.accOutNum = accOutNum;
	}
	public Double getAccOutAmt() {
		return accOutAmt;
	}
	public void setAccOutAmt(Double accOutAmt) {
		this.accOutAmt = accOutAmt;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public Double getCompScore() {
		return compScore;
	}
	public void setCompScore(Double compScore) {
		this.compScore = compScore;
	}
	public Double getSuccNum() {
		return succNum;
	}
	public void setSuccNum(Double succNum) {
		this.succNum = succNum;
	}
	public Double getReptNum() {
		return reptNum;
	}
	public void setReptNum(Double reptNum) {
		this.reptNum = reptNum;
	}
	public Date getStdt() {
		return stdt;
	}
	public void setStdt(Date stdt) {
		this.stdt = stdt;
	}
	public String getInduCode() {
		return induCode;
	}
	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}
	public String getStatFlag() {
		return statFlag;
	}
	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag;
	}
	public String getMerProv() {
		return merProv;
	}
	public void setMerProv(String merProv) {
		this.merProv = merProv;
	}
	public String getMerArea() {
		return merArea;
	}
	public void setMerArea(String merArea) {
		this.merArea = merArea;
	}
	public String getMerUnit() {
		return merUnit;
	}
	public void setMerUnit(String merUnit) {
		this.merUnit = merUnit;
	}
	public Date getNextDate() {
		return nextDate;
	}
	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}
	public String getIsLine() {
		return isLine;
	}
	public void setIsLine(String isLine) {
		this.isLine = isLine;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "BakStanPerson {id=" + id + ", clientTp=" + clientTp + ", accountTp=" + accountTp + ", busiType="
				+ busiType + ", busiRegNo=" + busiRegNo + ", ctnm=" + ctnm + ", smid=" + smid + ", education="
				+ education + ", marriage=" + marriage + ", ceml=" + ceml + ", ctvc=" + ctvc + ", rgdt=" + rgdt
				+ ", clsDt=" + clsDt + ", redt=" + redt + ", country=" + country + ", nation=" + nation + ", sex=" + sex
				+ ", birthday=" + birthday + ", endtime=" + endtime + ", agencyCtnm=" + agencyCtnm + ", agencyCitp="
				+ agencyCitp + ", agencyCtid=" + agencyCtid + ", agencyCdt=" + agencyCdt + ", remark=" + remark
				+ ", tsdt1=" + tsdt1 + ", tsdt2=" + tsdt2 + ", extend1=" + extend1 + ", extend2=" + extend2
				+ ", extend3=" + extend3 + ", extend4=" + extend4 + ", extend5=" + extend5 + ", curInNum=" + curInNum
				+ ", curInAmt=" + curInAmt + ", curOutNum=" + curOutNum + ", curOutAmt=" + curOutAmt + ", accInNum="
				+ accInNum + ", accInAmt=" + accInAmt + ", accOutNum=" + accOutNum + ", accOutAmt=" + accOutAmt
				+ ", riskLevel=" + riskLevel + ", compScore=" + compScore + ", succNum=" + succNum + ", reptNum="
				+ reptNum + ", stdt=" + stdt + ", induCode=" + induCode + ", statFlag=" + statFlag + ", merProv="
				+ merProv + ", merArea=" + merArea + ", merUnit=" + merUnit + ", nextDate=" + nextDate + ", isLine="
				+ isLine + ", createTime=" + createTime + ", updateTime=" + updateTime + ", runDt=" + runDt
				+ ", hashcode=" + hashcode + "}";
	}
	
	
	
	
}
