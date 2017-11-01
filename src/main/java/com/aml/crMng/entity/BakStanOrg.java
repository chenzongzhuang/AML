package com.aml.crMng.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BakStanOrg extends Model<BakStanOrg> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private String id; // 主键
	private String clientTp; // 客户类别(1代表客户,2代表商户)
	private String accountTp; // 账户分类
	private String busiType; // 业务类型
	private String busiRegNo; // 客户号
	private String ctnm; // 主体名称
	private String smid; // 主体特约商户编号

	private String linkman;// 联系人姓名
	private String linktel;// 联系人手机号
	private String linkjob;// 联系人职务
	private String linkmail;// 联系人邮箱
	private String linkphone;// 联系人固定电话

	private String ceml; // 电子邮件
	private String ctvc; // 主体的行业类别

	private String crnm;// 主体的法定代表人姓名
	private String crit;// 主体的法定代表人身份证件类型
	private String critNt;// 法人证件类型说明
	private String crid;// 主体的法定代表人身份证件号码
	private String cridEdt;// 法人证件有效期

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rgdt; // 开户日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clsDt; // 销户日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date redt; // 落地时间

	private String scale;// 企业规模
	private String country;// 注册国家

	private String endtime; // 有效期限

	private String crpType;// 机构类别
	private String fudDate;// 成立日期
	private String regCptl;// 注册资本
	private String remarkCtvc;// 经营范围

	private String agencyCtnm; // 代办理人姓名
	private String agencyCitp; // 代办理人证件类型
	private String agencyCtid; // 代办理人证件号码
	private String agencyCdt; // 代办理人证件有效期限
	private String remark; // 备注
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tsdt1; // 再前交易日期
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tsdt2; // 最近交易日期
	private String extend1; // 扩展1
	private String extend2; // 扩展2
	private String extend3; // 扩展3
	private String extend4; // 扩展4
	private String extend5; // 扩展5

	private Double curInNum; // 当日交易笔数(收)
	private Double curInAmt; // 当日交易金额(收)
	private Double curOutNum; // 当日交易笔数(支)
	private Double curOutAmt; // 当日交易金额(支)
	private Double accInNum; // 累计交易笔数(收)
	private Double accInAmt; // 累计交易金额(收)
	private Double accOutNum; // 累计交易笔数(支)
	private Double accOutAmt; // 累计交易金额(支)
	private String riskLevel; // 风险等级
	private Double compScore; // 综合评分
	private Double succNum; // 筛出次数
	private Double reptNum; // 报送次数
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date stdt; // 统计日期
	private String induCode; // 行业代码
	private String statFlag; // i-待激活 n-正常c-关闭
	private String merProv; // 地区省
	private String merArea; // 地区县
	private String merUnit; // 分支机构
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nextDate; // 下次评级日期
	private String isLine; // 是否线上
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime; // 创建时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime; // 修改时间
	private String runDt; //
	private String hashcode; //

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

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinktel() {
		return linktel;
	}

	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}

	public String getLinkjob() {
		return linkjob;
	}

	public void setLinkjob(String linkjob) {
		this.linkjob = linkjob;
	}

	public String getLinkmail() {
		return linkmail;
	}

	public void setLinkmail(String linkmail) {
		this.linkmail = linkmail;
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
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

	public String getCrnm() {
		return crnm;
	}

	public void setCrnm(String crnm) {
		this.crnm = crnm;
	}

	public String getCrit() {
		return crit;
	}

	public void setCrit(String crit) {
		this.crit = crit;
	}

	public String getCritNt() {
		return critNt;
	}

	public void setCritNt(String critNt) {
		this.critNt = critNt;
	}

	public String getCrid() {
		return crid;
	}

	public void setCrid(String crid) {
		this.crid = crid;
	}

	public String getCridEdt() {
		return cridEdt;
	}

	public void setCridEdt(String cridEdt) {
		this.cridEdt = cridEdt;
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

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCrpType() {
		return crpType;
	}

	public void setCrpType(String crpType) {
		this.crpType = crpType;
	}

	public String getFudDate() {
		return fudDate;
	}

	public void setFudDate(String fudDate) {
		this.fudDate = fudDate;
	}

	public String getRegCptl() {
		return regCptl;
	}

	public void setRegCptl(String regCptl) {
		this.regCptl = regCptl;
	}

	public String getRemarkCtvc() {
		return remarkCtvc;
	}

	public void setRemarkCtvc(String remarkCtvc) {
		this.remarkCtvc = remarkCtvc;
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
	public String toString() {
		return "BakStanOrg {id=" + id + ", clientTp=" + clientTp + ", accountTp=" + accountTp + ", busiType=" + busiType
				+ ", busiRegNo=" + busiRegNo + ", ctnm=" + ctnm + ", smid=" + smid + ", linkman=" + linkman
				+ ", linktel=" + linktel + ", linkjob=" + linkjob + ", linkmail=" + linkmail + ", linkphone="
				+ linkphone + ", ceml=" + ceml + ", ctvc=" + ctvc + ", crnm=" + crnm + ", crit=" + crit + ", critNt="
				+ critNt + ", crid=" + crid + ", cridEdt=" + cridEdt + ", rgdt=" + rgdt + ", clsDt=" + clsDt + ", redt="
				+ redt + ", scale=" + scale + ", country=" + country + ", endtime=" + endtime + ", crpType=" + crpType
				+ ", fudDate=" + fudDate + ", regCptl=" + regCptl + ", remarkCtvc=" + remarkCtvc + ", agencyCtnm="
				+ agencyCtnm + ", agencyCitp=" + agencyCitp + ", agencyCtid=" + agencyCtid + ", agencyCdt=" + agencyCdt
				+ ", remark=" + remark + ", tsdt1=" + tsdt1 + ", tsdt2=" + tsdt2 + ", extend1=" + extend1 + ", extend2="
				+ extend2 + ", extend3=" + extend3 + ", extend4=" + extend4 + ", extend5=" + extend5 + ", curInNum="
				+ curInNum + ", curInAmt=" + curInAmt + ", curOutNum=" + curOutNum + ", curOutAmt=" + curOutAmt
				+ ", accInNum=" + accInNum + ", accInAmt=" + accInAmt + ", accOutNum=" + accOutNum + ", accOutAmt="
				+ accOutAmt + ", riskLevel=" + riskLevel + ", compScore=" + compScore + ", succNum=" + succNum
				+ ", reptNum=" + reptNum + ", stdt=" + stdt + ", induCode=" + induCode + ", statFlag=" + statFlag
				+ ", merProv=" + merProv + ", merArea=" + merArea + ", merUnit=" + merUnit + ", nextDate=" + nextDate
				+ ", isLine=" + isLine + ", createTime=" + createTime + ", updateTime=" + updateTime + ", runDt="
				+ runDt + ", hashcode=" + hashcode + "}";
	}

}
