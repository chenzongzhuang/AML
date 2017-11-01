package com.aml.shadinessSub.entity;

import com.baomidou.mybatisplus.annotations.TableField;



public class SuspiciousReport {
	private String reportName;//报告名称
	
	private String NumOfSub;//报送次数
	
	private String suTran;//可疑交易
	
	private String numOfSuspiciouSub;//可疑主体数量
	
	private String versionType ;//报文类型
	
	private String packetState;//组包状态
	
	private String auditStatus;//审核状态
	
	private String subStatus;//报送状态
	
	private String createDate;//生成时间
	
	private String detail;//
	
	private String mts;
	
	private String receiptPackName;//回执包名 
	
	private String receiptImDate;//回执导入 
	
	private String receiptCreateDate;//回执生成日期
	
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

		public String getReportName() {
			return reportName;
		}

		public void setReportName(String reportName) {
			this.reportName = reportName;
		}

		public String getNumOfSub() {
			return NumOfSub;
		}

		public void setNumOfSub(String numOfSub) {
			NumOfSub = numOfSub;
		}

		public String getSuTran() {
			return suTran;
		}

		public void setSuTran(String suTran) {
			this.suTran = suTran;
		}

		public String getNumOfSuspiciouSub() {
			return numOfSuspiciouSub;
		}

		public void setNumOfSuspiciouSub(String numOfSuspiciouSub) {
			this.numOfSuspiciouSub = numOfSuspiciouSub;
		}

		public String getVersionType() {
			return versionType;
		}

		public void setVersionType(String versionType) {
			this.versionType = versionType;
		}

		public String getPacketState() {
			return packetState;
		}

		public void setPacketState(String packetState) {
			this.packetState = packetState;
		}

		public String getAuditStatus() {
			return auditStatus;
		}

		public void setAuditStatus(String auditStatus) {
			this.auditStatus = auditStatus;
		}

		public String getSubStatus() {
			return subStatus;
		}

		public void setSubStatus(String subStatus) {
			this.subStatus = subStatus;
		}

		public String getCreateDate() {
			return createDate;
		}

		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getMts() {
			return mts;
		}

		public void setMts(String mts) {
			this.mts = mts;
		}

		public String getReceiptPackName() {
			return receiptPackName;
		}

		public void setReceiptPackName(String receiptPackName) {
			this.receiptPackName = receiptPackName;
		}

		public String getReceiptImDate() {
			return receiptImDate;
		}

		public void setReceiptImDate(String receiptImDate) {
			this.receiptImDate = receiptImDate;
		}

		public String getReceiptCreateDate() {
			return receiptCreateDate;
		}

		public void setReceiptCreateDate(String receiptCreateDate) {
			this.receiptCreateDate = receiptCreateDate;
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
