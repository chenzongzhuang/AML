package com.aml.crMng.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;



/**
 * 交易信息
 * @author ASUS
 *
 */
public class TStanStif extends Model<TStanStif>{

	private static final long serialVersionUID = 1L;

	
	@TableId(value = "id", type = IdType.AUTO)	
	private String id ;//
	private String ctifTp ;//主体类别1：个人2：机构
	private String clientTp ;//客户类别1：客户2：商户
	private String ctifId ;//客户号(主体ID）
	private String ctnm ;//主体名称
	private String smid ;//主体特约商户编码
	private String citp ;//主体身份证件/证明文件类型
	private String citpNt ;//主体身份证件/证明文件类型说明
	private String ctid ;//主体身份证件/证明文件号码
	private String cbat ;//交易主体的银行账号种类
	private String cbac ;//交易主体的银行账号
	private String cabm ;//交易主体银行账号的开户行名称
	private String ctat ;//主体的交易账号种类
	private String ctac ;//主体的交易账号
	private String cpin ;//主体所在支付机构的名称
	private String cpba ;//主体所在支付机构的银行账号
	private String cpbn ;//主体所在支付机构的银行账号的开户行名称
	private String ctip ;//主体的交易IP地址
	private Date tstm ;//交易时间
	private double crat ;//交易金额
	private String cttp ;//货币资金转移方式
	private String tsdr ;//资金收付标志
	private String crpp ;//资金用途
	private String crtp ;//交易币种
	private String tcifId ;//交易对手ID
	private String tcnm ;//交易对手姓名/名称
	private String tsmi ;//交易对手特约商户编码
	private String tcit ;//交易对手证件/证明文件类型
	private String tcitNt ;//交易对手证件/证明文件类型说明
	private String tcid ;//交易对手证件/证明文件号码
	private String tcat ;//交易对手的银行账号种类
	private String tcba ;//交易对手的银行账号
	private String tcbn ;//交易对手银行账号的开户行名称
	private String tctt ;//交易对手的交易账号种类
	private String tcta ;//交易对手的交易账号
	private String tcpn ;//交易对手所在支付机构的名称
	private String tcpa ;//交易对手所在支付机构的银行账号
	private String tpbn ;//交易对手所在支付机构银行账号的开户行名称
	private String tcip ;//交易对手的交易IP地址
	private String tmnm ;//交易商品名称
	private String bptc ;//银行与支付机构之间的业务交易编码
	private String pmtc ;//支付机构与商户之间的业务交易编码
	private String ticd ;//业务标识号
	private Date redt ;//落地时间
	private String busiType ;//业务类型
	private String isSucc ;//是否筛出
	private String isRept ;//是否报送
	private String extend1 ;//
	private String extend2 ;//
	private String extend3 ;//
	private String extend4 ;//
	private String extend5 ;//
	private String transType ;//交易类型(P 消费W预授权完成)
	private String posDevId ;//设备号
	private String transStat ;//交易状态(I初始 S成功 F失败)
	private String bankStat ;//银行处理状态(I初始 S成功 F失败 X冲正)
	private String gateId ;//网关ID
	private String merProv ;//客户省份
	private String merArea ;//客户地区
	private String posProv ;//交易省份
	private String posArea ;//交易地区
	private String acctDate ;//业务系统日期
	private String ordId ;//订单号
	private String qgjMerId ;//
	private String merUnit ;//所属分支机构
	private String runDt ;//
	private String chfg ;//
	private double cratC ;//
	private double cratU ;//
	private String hbExpt ;//
	private String iofg ;//
	private double rate_rmb ;//
	private double rate_usa ;//
	private String tcitEdt ;//
	private String tsTd ;//
	private String tsTm ;//
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCtifTp() {
		return ctifTp;
	}



	public void setCtifTp(String ctifTp) {
		this.ctifTp = ctifTp;
	}



	public String getClientTp() {
		return clientTp;
	}



	public void setClientTp(String clientTp) {
		this.clientTp = clientTp;
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



	public String getCitp() {
		return citp;
	}



	public void setCitp(String citp) {
		this.citp = citp;
	}



	



	public String getCtid() {
		return ctid;
	}



	public void setCtid(String ctid) {
		this.ctid = ctid;
	}



	public String getCbat() {
		return cbat;
	}



	public void setCbat(String cbat) {
		this.cbat = cbat;
	}



	public String getCbac() {
		return cbac;
	}



	public void setCbac(String cbac) {
		this.cbac = cbac;
	}



	public String getCabm() {
		return cabm;
	}



	public void setCabm(String cabm) {
		this.cabm = cabm;
	}



	public String getCtat() {
		return ctat;
	}



	public void setCtat(String ctat) {
		this.ctat = ctat;
	}



	public String getCtac() {
		return ctac;
	}



	public void setCtac(String ctac) {
		this.ctac = ctac;
	}



	public String getCpin() {
		return cpin;
	}



	public void setCpin(String cpin) {
		this.cpin = cpin;
	}



	public String getCpba() {
		return cpba;
	}



	public void setCpba(String cpba) {
		this.cpba = cpba;
	}



	public String getCpbn() {
		return cpbn;
	}



	public void setCpbn(String cpbn) {
		this.cpbn = cpbn;
	}



	public String getCtip() {
		return ctip;
	}



	public void setCtip(String ctip) {
		this.ctip = ctip;
	}



	public Date getTstm() {
		return tstm;
	}



	public void setTstm(Date tstm) {
		this.tstm = tstm;
	}



	public double getCrat() {
		return crat;
	}



	public void setCrat(double crat) {
		this.crat = crat;
	}



	public String getCttp() {
		return cttp;
	}



	public void setCttp(String cttp) {
		this.cttp = cttp;
	}



	public String getTsdr() {
		return tsdr;
	}



	public void setTsdr(String tsdr) {
		this.tsdr = tsdr;
	}



	public String getCrpp() {
		return crpp;
	}



	public void setCrpp(String crpp) {
		this.crpp = crpp;
	}



	public String getCrtp() {
		return crtp;
	}



	public void setCrtp(String crtp) {
		this.crtp = crtp;
	}



	



	public String getTcnm() {
		return tcnm;
	}



	public void setTcnm(String tcnm) {
		this.tcnm = tcnm;
	}



	public String getTsmi() {
		return tsmi;
	}



	public void setTsmi(String tsmi) {
		this.tsmi = tsmi;
	}



	public String getTcit() {
		return tcit;
	}



	public void setTcit(String tcit) {
		this.tcit = tcit;
	}



	



	public String getTcid() {
		return tcid;
	}



	public void setTcid(String tcid) {
		this.tcid = tcid;
	}



	public String getTcat() {
		return tcat;
	}



	public void setTcat(String tcat) {
		this.tcat = tcat;
	}



	public String getTcba() {
		return tcba;
	}



	public void setTcba(String tcba) {
		this.tcba = tcba;
	}



	public String getTcbn() {
		return tcbn;
	}



	public void setTcbn(String tcbn) {
		this.tcbn = tcbn;
	}



	public String getTctt() {
		return tctt;
	}



	public void setTctt(String tctt) {
		this.tctt = tctt;
	}



	public String getTcta() {
		return tcta;
	}



	public void setTcta(String tcta) {
		this.tcta = tcta;
	}



	public String getTcpn() {
		return tcpn;
	}



	public void setTcpn(String tcpn) {
		this.tcpn = tcpn;
	}



	public String getTcpa() {
		return tcpa;
	}



	public void setTcpa(String tcpa) {
		this.tcpa = tcpa;
	}



	public String getTpbn() {
		return tpbn;
	}



	public void setTpbn(String tpbn) {
		this.tpbn = tpbn;
	}



	public String getTcip() {
		return tcip;
	}



	public void setTcip(String tcip) {
		this.tcip = tcip;
	}



	public String getTmnm() {
		return tmnm;
	}



	public void setTmnm(String tmnm) {
		this.tmnm = tmnm;
	}



	public String getBptc() {
		return bptc;
	}



	public void setBptc(String bptc) {
		this.bptc = bptc;
	}



	public String getPmtc() {
		return pmtc;
	}



	public void setPmtc(String pmtc) {
		this.pmtc = pmtc;
	}



	public String getTicd() {
		return ticd;
	}



	public void setTicd(String ticd) {
		this.ticd = ticd;
	}



	public Date getRedt() {
		return redt;
	}



	public void setRedt(Date redt) {
		this.redt = redt;
	}



	public String getBusiType() {
		return busiType;
	}



	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}



	public String getIsSucc() {
		return isSucc;
	}



	public void setIsSucc(String isSucc) {
		this.isSucc = isSucc;
	}



	public String getIsRept() {
		return isRept;
	}



	public void setIsRept(String isRept) {
		this.isRept = isRept;
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



	public String getTransType() {
		return transType;
	}



	public void setTransType(String transType) {
		this.transType = transType;
	}



	


	public String getTransStat() {
		return transStat;
	}



	public void setTransStat(String transStat) {
		this.transStat = transStat;
	}



	



	public String getPosDevId() {
		return posDevId;
	}



	public void setPosDevId(String posDevId) {
		this.posDevId = posDevId;
	}



	public String getBankStat() {
		return bankStat;
	}



	public void setBankStat(String bankStat) {
		this.bankStat = bankStat;
	}



	public String getGateId() {
		return gateId;
	}



	public void setGateId(String gateId) {
		this.gateId = gateId;
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



	public String getPosProv() {
		return posProv;
	}



	public void setPosProv(String posProv) {
		this.posProv = posProv;
	}



	public String getPosArea() {
		return posArea;
	}



	public void setPosArea(String posArea) {
		this.posArea = posArea;
	}



	public String getAcctDate() {
		return acctDate;
	}



	public void setAcctDate(String acctDate) {
		this.acctDate = acctDate;
	}



	public String getOrdId() {
		return ordId;
	}



	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}



	public String getQgjMerId() {
		return qgjMerId;
	}



	public void setQgjMerId(String qgjMerId) {
		this.qgjMerId = qgjMerId;
	}



	public String getMerUnit() {
		return merUnit;
	}



	public void setMerUnit(String merUnit) {
		this.merUnit = merUnit;
	}



	public String getRunDt() {
		return runDt;
	}



	public void setRunDt(String runDt) {
		this.runDt = runDt;
	}



	public String getChfg() {
		return chfg;
	}



	public void setChfg(String chfg) {
		this.chfg = chfg;
	}



	public double getCratC() {
		return cratC;
	}



	public void setCratC(double cratC) {
		this.cratC = cratC;
	}



	public double getCratU() {
		return cratU;
	}



	public void setCratU(double cratU) {
		this.cratU = cratU;
	}



	public String getHbExpt() {
		return hbExpt;
	}



	public void setHbExpt(String hbExpt) {
		this.hbExpt = hbExpt;
	}



	public String getIofg() {
		return iofg;
	}



	public void setIofg(String iofg) {
		this.iofg = iofg;
	}



	public double getRate_rmb() {
		return rate_rmb;
	}



	public void setRate_rmb(double rate_rmb) {
		this.rate_rmb = rate_rmb;
	}



	public double getRate_usa() {
		return rate_usa;
	}



	public void setRate_usa(double rate_usa) {
		this.rate_usa = rate_usa;
	}



	public String getTcitEdt() {
		return tcitEdt;
	}



	public void setTcitEdt(String tcitEdt) {
		this.tcitEdt = tcitEdt;
	}



	public String getTsTd() {
		return tsTd;
	}



	public void setTsTd(String tsTd) {
		this.tsTd = tsTd;
	}



	public String getTsTm() {
		return tsTm;
	}



	public void setTsTm(String tsTm) {
		this.tsTm = tsTm;
	}



	@Override
	protected Serializable pkVal() {
		return this.id;
	}



	public String getCtifId() {
		return ctifId;
	}



	public void setCtifId(String ctifId) {
		this.ctifId = ctifId;
	}



	public String getCitpNt() {
		return citpNt;
	}



	public void setCitpNt(String citpNt) {
		this.citpNt = citpNt;
	}



	public String getTcifId() {
		return tcifId;
	}



	public void setTcifId(String tcifId) {
		this.tcifId = tcifId;
	}



	public String getTcitNt() {
		return tcitNt;
	}



	public void setTcitNt(String tcitNt) {
		this.tcitNt = tcitNt;
	}



	@Override
	public String toString() {
		return "TStanStif {id=" + id + ", ctifTp=" + ctifTp + ", clientTp=" + clientTp + ", ctifId=" + ctifId
				+ ", ctnm=" + ctnm + ", smid=" + smid + ", citp=" + citp + ", citpNt=" + citpNt + ", ctid=" + ctid
				+ ", cbat=" + cbat + ", cbac=" + cbac + ", cabm=" + cabm + ", ctat=" + ctat + ", ctac=" + ctac
				+ ", cpin=" + cpin + ", cpba=" + cpba + ", cpbn=" + cpbn + ", ctip=" + ctip + ", tstm=" + tstm
				+ ", crat=" + crat + ", cttp=" + cttp + ", tsdr=" + tsdr + ", crpp=" + crpp + ", crtp=" + crtp
				+ ", tcifId=" + tcifId + ", tcnm=" + tcnm + ", tsmi=" + tsmi + ", tcit=" + tcit + ", tcitNt=" + tcitNt
				+ ", tcid=" + tcid + ", tcat=" + tcat + ", tcba=" + tcba + ", tcbn=" + tcbn + ", tctt=" + tctt
				+ ", tcta=" + tcta + ", tcpn=" + tcpn + ", tcpa=" + tcpa + ", tpbn=" + tpbn + ", tcip=" + tcip
				+ ", tmnm=" + tmnm + ", bptc=" + bptc + ", pmtc=" + pmtc + ", ticd=" + ticd + ", redt=" + redt
				+ ", busiType=" + busiType + ", isSucc=" + isSucc + ", isRept=" + isRept + ", extend1=" + extend1
				+ ", extend2=" + extend2 + ", extend3=" + extend3 + ", extend4=" + extend4 + ", extend5=" + extend5
				+ ", transType=" + transType + ", posDevId=" + posDevId + ", transStat=" + transStat + ", bankStat="
				+ bankStat + ", gateId=" + gateId + ", merProv=" + merProv + ", merArea=" + merArea + ", posProv="
				+ posProv + ", posArea=" + posArea + ", acctDate=" + acctDate + ", ordId=" + ordId + ", qgjMerId="
				+ qgjMerId + ", merUnit=" + merUnit + ", runDt=" + runDt + ", chfg=" + chfg + ", cratC=" + cratC
				+ ", cratU=" + cratU + ", hbExpt=" + hbExpt + ", iofg=" + iofg + ", rate_rmb=" + rate_rmb
				+ ", rate_usa=" + rate_usa + ", tcitEdt=" + tcitEdt + ", tsTd=" + tsTd + ", tsTm=" + tsTm + "}";
	}



	



	
	
	

}
