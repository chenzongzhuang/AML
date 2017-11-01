package com.aml.crMng.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 可疑报告表
 * @author ASUS
 *
 */
public class TPstrRbif extends Model<TPstrRbif> {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private String id ;//id
	private String pkgId ;//数据包id
	private String repNm ;//报告名称
	private Integer seqNo ;//在批次中的序号
	private String rinm ;//报告机构名称
	private String firc ;//金融机构所在地区编码
	private String ficd ;//报告机构分支机构网点代码
	private String rfsg ;//报送次数标志
	private String orxn ;//初次报送的可疑交易报告名称
	private String sstm ;//可疑交易/行为处理情况
	private String stcr ;//可疑交易/行为特征
	private String ssds ;//可疑交易/行为描述
	private String udsi ;//机构自定可疑交易标准编号
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


	public String getRepNm() {
		return repNm;
	}


	public void setRepNm(String repNm) {
		this.repNm = repNm;
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


	public String getFicd() {
		return ficd;
	}


	public void setFicd(String ficd) {
		this.ficd = ficd;
	}


	public String getRfsg() {
		return rfsg;
	}


	public void setRfsg(String rfsg) {
		this.rfsg = rfsg;
	}


	public String getOrxn() {
		return orxn;
	}


	public void setOrxn(String orxn) {
		this.orxn = orxn;
	}


	public String getSstm() {
		return sstm;
	}


	public void setSstm(String sstm) {
		this.sstm = sstm;
	}


	public String getStcr() {
		return stcr;
	}


	public void setStcr(String stcr) {
		this.stcr = stcr;
	}


	public String getSsds() {
		return ssds;
	}


	public void setSsds(String ssds) {
		this.ssds = ssds;
	}


	public String getUdsi() {
		return udsi;
	}


	public void setUdsi(String udsi) {
		this.udsi = udsi;
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


	public Date getAppendDt() {
		return appendDt;
	}


	public void setAppendDt(Date appendDt) {
		this.appendDt = appendDt;
	}


	public String getAppendSt() {
		return appendSt;
	}


	public void setAppendSt(String appendSt) {
		this.appendSt = appendSt;
	}


	private Date appendDt ;//接续日期
	private String appendSt ;//接续状态
	
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	@Override
	public String toString() {
		return "TPstrRbif {id=" + id + ", pkgId=" + pkgId + ", repNm=" + repNm + ", seqNo=" + seqNo + ", rinm=" + rinm
				+ ", firc=" + firc + ", ficd=" + ficd + ", rfsg=" + rfsg + ", orxn=" + orxn + ", sstm=" + sstm
				+ ", stcr=" + stcr + ", ssds=" + ssds + ", udsi=" + udsi + ", sctn=" + sctn + ", ttnm=" + ttnm
				+ ", repTp=" + repTp + ", repSt=" + repSt + ", autSt=" + autSt + ", autNt=" + autNt + ", sndSt=" + sndSt
				+ ", bckSt=" + bckSt + ", redt=" + redt + ", rfnm=" + rfnm + ", fsize=" + fsize + ", rbchNo=" + rbchNo
				+ ", pageName=" + pageName + ", trdt=" + trdt + ", attName=" + attName + ", merUnit=" + merUnit
				+ ", appendDt=" + appendDt + ", appendSt=" + appendSt + "}";
	}
	
	

}
