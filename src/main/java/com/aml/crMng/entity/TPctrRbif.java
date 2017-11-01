package com.aml.crMng.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 补充报告表
 * @author ASUS
 *
 */
public class TPctrRbif extends Model<TPctrRbif> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private String id ;//id
	private String pkgId ;//数据包id
	private String repName ;//报告名称
	private Integer seqNo ;//在批次中的序号
	private String rinm ;//报告机构名称
	private String firc ;//金融机构所在地区编码
	private String cimc ;//补充通知编码
	private String sctn ;//补充主体数量
	private String ttnm ;//补充交易笔数
	private String repTp ;//报文类型
	private String repSt ;//报告状态(组包状态)
	private String autSt ;//审核状态
	private String autNt ;//审核意见
	private String sndSt ;//报送状态
	private String bckSt ;//回执状态
	private Date redt ;//生成时间
	private String rfnm ;//报文名称
	private String fsize ;//报文及附件大小
	private String rbchNo ;//批次号
	private String pageName ;//数据包名称
	private String trdt ;//报送日期
	private String attName ;//附件文件名称
	private String merUnit ;//分支机构
	
	
	
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



	public String getPkgId() {
		return pkgId;
	}



	public void setPkgId(String pkgId) {
		this.pkgId = pkgId;
	}



	public String getRepName() {
		return repName;
	}



	public void setRepName(String repName) {
		this.repName = repName;
	}



	public Integer getSeqNo() {
		return seqNo;
	}



	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}



	public String getRinm() {
		return rinm;
	}



	public void setRinm(String rinm) {
		this.rinm = rinm;
	}



	public String getFirc() {
		return firc;
	}



	public void setFirc(String firc) {
		this.firc = firc;
	}



	public String getCimc() {
		return cimc;
	}



	public void setCimc(String cimc) {
		this.cimc = cimc;
	}



	public String getSctn() {
		return sctn;
	}



	public void setSctn(String sctn) {
		this.sctn = sctn;
	}



	public String getTtnm() {
		return ttnm;
	}



	public void setTtnm(String ttnm) {
		this.ttnm = ttnm;
	}



	public String getRepTp() {
		return repTp;
	}



	public void setRepTp(String repTp) {
		this.repTp = repTp;
	}



	public String getRepSt() {
		return repSt;
	}



	public void setRepSt(String repSt) {
		this.repSt = repSt;
	}



	public String getAutSt() {
		return autSt;
	}



	public void setAutSt(String autSt) {
		this.autSt = autSt;
	}



	public String getAutNt() {
		return autNt;
	}



	public void setAutNt(String autNt) {
		this.autNt = autNt;
	}



	public String getSndSt() {
		return sndSt;
	}



	public void setSndSt(String sndSt) {
		this.sndSt = sndSt;
	}



	public String getBckSt() {
		return bckSt;
	}



	public void setBckSt(String bckSt) {
		this.bckSt = bckSt;
	}



	public Date getRedt() {
		return redt;
	}



	public void setRedt(Date redt) {
		this.redt = redt;
	}



	public String getRfnm() {
		return rfnm;
	}



	public void setRfnm(String rfnm) {
		this.rfnm = rfnm;
	}



	public String getFsize() {
		return fsize;
	}



	public void setFsize(String fsize) {
		this.fsize = fsize;
	}



	public String getRbchNo() {
		return rbchNo;
	}



	public void setRbchNo(String rbchNo) {
		this.rbchNo = rbchNo;
	}



	public String getPageName() {
		return pageName;
	}



	public void setPageName(String pageName) {
		this.pageName = pageName;
	}



	public String getTrdt() {
		return trdt;
	}



	public void setTrdt(String trdt) {
		this.trdt = trdt;
	}



	public String getAttName() {
		return attName;
	}



	public void setAttName(String attName) {
		this.attName = attName;
	}



	public String getMerUnit() {
		return merUnit;
	}



	public void setMerUnit(String merUnit) {
		this.merUnit = merUnit;
	}



	@Override
	public String toString() {
		return "TPctrRbif {id=" + id + ", pkgId=" + pkgId + ", repName=" + repName + ", seqNo=" + seqNo + ", rinm="
				+ rinm + ", firc=" + firc + ", cimc=" + cimc + ", sctn=" + sctn + ", ttnm=" + ttnm + ", repTp=" + repTp
				+ ", repSt=" + repSt + ", autSt=" + autSt + ", autNt=" + autNt + ", sndSt=" + sndSt + ", bckSt=" + bckSt
				+ ", redt=" + redt + ", rfnm=" + rfnm + ", fsize=" + fsize + ", rbchNo=" + rbchNo + ", pageName="
				+ pageName + ", trdt=" + trdt + ", attName=" + attName + ", merUnit=" + merUnit + "}";
	}
	
	
}
