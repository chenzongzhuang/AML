package com.aml.shadinessSub.entity;

import java.util.List;

import com.aml.earlyWarning.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
/**
 * 待确认可疑 筛选的主体--筛选交易
 * @author zhongrui
 *
 */


public class ShadinessSub extends BaseEntity{
	private String warningDate;//预警日期
	 
	 private String earlyWarRules;//预警规则
	 
	 private String subName;//主体名称
	 
	 private String idNo;//身份号
	 
	 private String pMertNumr;//特约商户编号
	 
	 private String traAmo;//交易金额(收/付)
	 
	 private String  numOfTran;//交易笔数(收/付)
	 
	 private String riskGrade;//风险等级
	 
	 private String compScore;//综合评分
	 
	 private String causeExp;//事由说明
	 
	 private String details;
	 
	 private String branch;//分支机构
	 
	 private String areaRollType;
	 
	 private List<String> idNoList;
	 
	 private String tranDate;//交易时间 
	 
	 private String fundMark;//资金收付标志
	 
	 private String tranAmount;//交易金额
	 
	 private String counName;//交易对手名称
	 
	 private String counIdNo;//交易对手证件号码
	 
	 private String traCommName;//交易对手商品名称 
	 
	 private String workNo;//业务标识号
	 
	 private String bankAccount;//银行账号
	 
	 private String mts;//交易账号
	 
	 private String starAmount;
	 
	 private String endAmount;
	 
	 private String makeUpState;//补录状态
	 
	 private String verifyStatus;//校验状态
	 
	 private String causecCategory;//事由类别
	 
	 private String id;
	 
	 @TableField(exist = false)
		private String page;//当前页数
		
		@TableField(exist = false)
		private String rows;//每页显示行数
		
		@TableField(exist = false)
		private String total;
		
		@TableField(exist = false)
		private String type;
		
		@TableField(exist = false)
		private int currentPage;
		
		@TableField(exist = false)
		private int currentReslut;

		public String getWarningDate() {
			return warningDate;
		}

		public void setWarningDate(String warningDate) {
			this.warningDate = warningDate;
		}

		public String getEarlyWarRules() {
			return earlyWarRules;
		}

		public void setEarlyWarRules(String earlyWarRules) {
			this.earlyWarRules = earlyWarRules;
		}

		public String getSubName() {
			return subName;
		}

		public void setSubName(String subName) {
			this.subName = subName;
		}

		public String getIdNo() {
			return idNo;
		}

		public void setIdNo(String idNo) {
			this.idNo = idNo;
		}

		public String getpMertNumr() {
			return pMertNumr;
		}

		public void setpMertNumr(String pMertNumr) {
			this.pMertNumr = pMertNumr;
		}

		public String getTraAmo() {
			return traAmo;
		}

		public void setTraAmo(String traAmo) {
			this.traAmo = traAmo;
		}

		public String getNumOfTran() {
			return numOfTran;
		}

		public void setNumOfTran(String numOfTran) {
			this.numOfTran = numOfTran;
		}

		public String getRiskGrade() {
			return riskGrade;
		}

		public void setRiskGrade(String riskGrade) {
			this.riskGrade = riskGrade;
		}

		public String getCompScore() {
			return compScore;
		}

		public void setCompScore(String compScore) {
			this.compScore = compScore;
		}

		public String getCauseExp() {
			return causeExp;
		}

		public void setCauseExp(String causeExp) {
			this.causeExp = causeExp;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getAreaRollType() {
			return areaRollType;
		}

		public void setAreaRollType(String areaRollType) {
			this.areaRollType = areaRollType;
		}

		public List<String> getIdNoList() {
			return idNoList;
		}

		public void setIdNoList(List<String> idNoList) {
			this.idNoList = idNoList;
		}

		public String getTranDate() {
			return tranDate;
		}

		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
		}

		public String getFundMark() {
			return fundMark;
		}

		public void setFundMark(String fundMark) {
			this.fundMark = fundMark;
		}

		public String getTranAmount() {
			return tranAmount;
		}

		public void setTranAmount(String tranAmount) {
			this.tranAmount = tranAmount;
		}

		public String getCounName() {
			return counName;
		}

		public void setCounName(String counName) {
			this.counName = counName;
		}

		public String getCounIdNo() {
			return counIdNo;
		}

		public void setCounIdNo(String counIdNo) {
			this.counIdNo = counIdNo;
		}

		public String getTraCommName() {
			return traCommName;
		}

		public void setTraCommName(String traCommName) {
			this.traCommName = traCommName;
		}

		public String getWorkNo() {
			return workNo;
		}

		public void setWorkNo(String workNo) {
			this.workNo = workNo;
		}

		public String getBankAccount() {
			return bankAccount;
		}

		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}

		public String getMts() {
			return mts;
		}

		public void setMts(String mts) {
			this.mts = mts;
		}

		public String getStarAmount() {
			return starAmount;
		}

		public void setStarAmount(String starAmount) {
			this.starAmount = starAmount;
		}

		public String getEndAmount() {
			return endAmount;
		}

		public void setEndAmount(String endAmount) {
			this.endAmount = endAmount;
		}

		public String getMakeUpState() {
			return makeUpState;
		}

		public void setMakeUpState(String makeUpState) {
			this.makeUpState = makeUpState;
		}

		public String getVerifyStatus() {
			return verifyStatus;
		}

		public void setVerifyStatus(String verifyStatus) {
			this.verifyStatus = verifyStatus;
		}

		public String getCausecCategory() {
			return causecCategory;
		}

		public void setCausecCategory(String causecCategory) {
			this.causecCategory = causecCategory;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public String getRows() {
			return rows;
		}

		public void setRows(String rows) {
			this.rows = rows;
		}

		public String getTotal() {
			return total;
		}

		public void setTotal(String total) {
			this.total = total;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage() {
			this.currentPage = Integer.valueOf(this.page);
		}

		public int getCurrentReslut() {
			return currentReslut;
		}

		public void setCurrentReslut() {
			this.currentReslut = (Integer.valueOf(this.page))+Integer.valueOf(this.rows);
		}
		
		
		
		
	 
	 
		
		
	 
	 
	 
	 
	 
	 
	 
}
