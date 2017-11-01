package com.aml.cRat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 客户评级表
 * </p>
 *
 */
public class CRat extends Model<CRat> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，序号
     */
	@TableId(value="ID", type= IdType.AUTO)
	private Integer id ;//PK,ID
	private String cstId ;//客户ID
	private String ctKd ;//客户类别
	private String rkTp ;//评级类型：1:新用户评级。2: 存量用户初评 3:重新评定，4：定期复核，5：评级变动 6：人工评级
	private BigDecimal assNo ;//评级次数
	private Timestamp fstAutTime ;//初次评级时间
	private String fstAutRank ;//初次系统评级等级
	private String fstManRank ;//初次人工确认等级
	private Timestamp preAutTime ;//上次系统评级时间
	private String preAutRank ;//上次自动评级等级
	private String preManFank ;//上次人工评级等级
	private BigDecimal assc ;//综合评分
	private String autRank ;//系统评级
	private Timestamp autTime ;//评级时间
	private String trgDs ;//触发评级原因
	private String rnkDs ;//评级概要-定级原因、事由
	private String cfmRank ;//确认评级
	private String cfmResKnd ;//初评事由类别
	private String cfmResDtl ;//初评事由明细
	private String cfmer ;//初评人员
	private Timestamp cfmTime ;//初评时间
	private String easResKnd ;//终评事由类别
	private String easResDtl ;//终评事由明细
	private String easer ;//终评人员
	private Timestamp easTime ;//终评时间
	private String adjResKnd ;//调整事由类别
	private String adjResDtl ;//调整事由明细
	private String adjer ;//调整人员
	private Timestamp adjTime ;//调整时间
	private BigDecimal status ;//状态|0:待确认,1.待审核2.待审批,3.审批通过评级生效,4.审批不通过
	private String rmdl ;//评级模型
	private BigDecimal version ;//版本号
	private String manc ;//评级机构
	private String adjRank ;//调整评级
	private Timestamp nextDate ;//下次评级日期
	private String merUnit ;//分支机构
	private String clientTp ;//
	private String runDt ;//
	private String rankJson ;//
	
	private String ctNm ;//客户名称
	private String title ;//导出Excel 标题
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	@Override
	public String toString() {
		return "CRat{" +
			"id=" + id +
			", cstId=" + cstId +
			", ctKd=" + ctKd +
			", rkTp=" + rkTp +
			", assNo=" + assNo +
			", fstAutTime=" + fstAutTime +
			", fstAutRank=" + fstAutRank +
			", fstManRank=" + fstManRank +
			", preAutTime=" + preAutTime +
			", preAutRank=" + preAutRank +
			", preManFank=" + preManFank +
			", assc=" + assc +
			", autRank=" + autRank +
			", autTime=" + autTime +
			", trgDs=" + trgDs +
			", rnkDs=" + rnkDs +
			", cfmRank=" + cfmRank +
			", cfmResKnd=" + cfmResKnd +
			", cfmResDtl=" + cfmResDtl +
			", cfmer=" + cfmer +
			", cfmTime=" + cfmTime +
			", easResKnd=" + easResKnd +
			", easResDtl=" + easResDtl +
			", easer=" + easer +
			", easTime=" + easTime +
			", adjResKnd=" + adjResKnd +
			", adjResDtl=" + adjResDtl +
			", adjer=" + adjer +
			", adjTime=" + adjTime +
			", status=" + status +
			", rmdl=" + rmdl +
			", version=" + version +
			", manc=" + manc +
			", adjRank=" + adjRank +
			", nextDate=" + nextDate +
			", merUnit=" + merUnit +
			", clientTp=" + clientTp +
			", runDt=" + runDt +
			", rankJson=" + rankJson +
			", ctNm=" + ctNm +
			", title=" + title +
			"}";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCstId() {
		return cstId;
	}
	public void setCstId(String cstId) {
		this.cstId = cstId;
	}
	public String getCtKd() {
		return ctKd;
	}
	public void setCtKd(String ctKd) {
		this.ctKd = ctKd;
	}
	public String getRkTp() {
		return rkTp;
	}
	public void setRkTp(String rkTp) {
		this.rkTp = rkTp;
	}
	public BigDecimal getAssNo() {
		return assNo;
	}
	public void setAssNo(BigDecimal assNo) {
		this.assNo = assNo;
	}
	public Timestamp getFstAutTime() {
		return fstAutTime;
	}
	public void setFstAutTime(Timestamp fstAutTime) {
		this.fstAutTime = fstAutTime;
	}
	public String getFstAutRank() {
		return fstAutRank;
	}
	public void setFstAutRank(String fstAutRank) {
		this.fstAutRank = fstAutRank;
	}
	public String getFstManRank() {
		return fstManRank;
	}
	public void setFstManRank(String fstManRank) {
		this.fstManRank = fstManRank;
	}
	public Timestamp getPreAutTime() {
		return preAutTime;
	}
	public void setPreAutTime(Timestamp preAutTime) {
		this.preAutTime = preAutTime;
	}
	public String getPreAutRank() {
		return preAutRank;
	}
	public void setPreAutRank(String preAutRank) {
		this.preAutRank = preAutRank;
	}
	public String getPreManFank() {
		return preManFank;
	}
	public void setPreManFank(String preManFank) {
		this.preManFank = preManFank;
	}
	public BigDecimal getAssc() {
		return assc;
	}
	public void setAssc(BigDecimal assc) {
		this.assc = assc;
	}
	public String getAutRank() {
		return autRank;
	}
	public void setAutRank(String autRank) {
		this.autRank = autRank;
	}
	public Timestamp getAutTime() {
		return autTime;
	}
	public void setAutTime(Timestamp autTime) {
		this.autTime = autTime;
	}
	public String getTrgDs() {
		return trgDs;
	}
	public void setTrgDs(String trgDs) {
		this.trgDs = trgDs;
	}
	public String getRnkDs() {
		return rnkDs;
	}
	public void setRnkDs(String rnkDs) {
		this.rnkDs = rnkDs;
	}
	public String getCfmRank() {
		return cfmRank;
	}
	public void setCfmRank(String cfmRank) {
		this.cfmRank = cfmRank;
	}
	public String getCfmResKnd() {
		return cfmResKnd;
	}
	public void setCfmResKnd(String cfmResKnd) {
		this.cfmResKnd = cfmResKnd;
	}
	public String getCfmResDtl() {
		return cfmResDtl;
	}
	public void setCfmResDtl(String cfmResDtl) {
		this.cfmResDtl = cfmResDtl;
	}
	public String getCfmer() {
		return cfmer;
	}
	public void setCfmer(String cfmer) {
		this.cfmer = cfmer;
	}
	public Timestamp getCfmTime() {
		return cfmTime;
	}
	public void setCfmTime(Timestamp cfmTime) {
		this.cfmTime = cfmTime;
	}
	public String getEasResKnd() {
		return easResKnd;
	}
	public void setEasResKnd(String easResKnd) {
		this.easResKnd = easResKnd;
	}
	public String getEasResDtl() {
		return easResDtl;
	}
	public void setEasResDtl(String easResDtl) {
		this.easResDtl = easResDtl;
	}
	public String getEaser() {
		return easer;
	}
	public void setEaser(String easer) {
		this.easer = easer;
	}
	public Timestamp getEasTime() {
		return easTime;
	}
	public void setEasTime(Timestamp easTime) {
		this.easTime = easTime;
	}
	public String getAdjResKnd() {
		return adjResKnd;
	}
	public void setAdjResKnd(String adjResKnd) {
		this.adjResKnd = adjResKnd;
	}
	public String getAdjResDtl() {
		return adjResDtl;
	}
	public void setAdjResDtl(String adjResDtl) {
		this.adjResDtl = adjResDtl;
	}
	public String getAdjer() {
		return adjer;
	}
	public void setAdjer(String adjer) {
		this.adjer = adjer;
	}
	public Timestamp getAdjTime() {
		return adjTime;
	}
	public void setAdjTime(Timestamp adjTime) {
		this.adjTime = adjTime;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
	}
	public String getRmdl() {
		return rmdl;
	}
	public void setRmdl(String rmdl) {
		this.rmdl = rmdl;
	}
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	public String getManc() {
		return manc;
	}
	public void setManc(String manc) {
		this.manc = manc;
	}
	public String getAdjRank() {
		return adjRank;
	}
	public void setAdjRank(String adjRank) {
		this.adjRank = adjRank;
	}
	public Timestamp getNextDate() {
		return nextDate;
	}
	public void setNextDate(Timestamp nextDate) {
		this.nextDate = nextDate;
	}
	public String getMerUnit() {
		return merUnit;
	}
	public void setMerUnit(String merUnit) {
		this.merUnit = merUnit;
	}
	public String getClientTp() {
		return clientTp;
	}
	public void setClientTp(String clientTp) {
		this.clientTp = clientTp;
	}
	public String getRunDt() {
		return runDt;
	}
	public void setRunDt(String runDt) {
		this.runDt = runDt;
	}
	public String getRankJson() {
		return rankJson;
	}
	public void setRankJson(String rankJson) {
		this.rankJson = rankJson;
	}
	public String getCtNm() {
		return ctNm;
	}
	public void setCtNm(String ctNm) {
		this.ctNm = ctNm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
