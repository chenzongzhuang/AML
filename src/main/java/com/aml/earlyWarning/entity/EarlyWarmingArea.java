package com.aml.earlyWarning.entity;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 个人地区
 * @author zhongrui
 *
 */
public class EarlyWarmingArea extends BaseEntity{
	
	private String customerNumber;//客户号
	
	private String relationType;//关系类型
	
	private String areaType;//地区类型
	
	private String rosterAreaModel;//名单库地区代码
	
	private String rosterAreaName;//名单库地区名称
	
	private String customerName;//客户名称
	
	private String customerAreaModel;//客户地区代码
	
	private String customerAddrType;//客户地址类型
	
	private String earlyWarningDate;//预警时间
	
	private String customerTyoe;//客户类别
	
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

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getRosterAreaModel() {
		return rosterAreaModel;
	}

	public void setRosterAreaModel(String rosterAreaModel) {
		this.rosterAreaModel = rosterAreaModel;
	}

	public String getRosterAreaName() {
		return rosterAreaName;
	}

	public void setRosterAreaName(String rosterAreaName) {
		this.rosterAreaName = rosterAreaName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAreaModel() {
		return customerAreaModel;
	}

	public void setCustomerAreaModel(String customerAreaModel) {
		this.customerAreaModel = customerAreaModel;
	}

	public String getCustomerAddrType() {
		return customerAddrType;
	}

	public void setCustomerAddrType(String customerAddrType) {
		this.customerAddrType = customerAddrType;
	}

	public String getEarlyWarningDate() {
		return earlyWarningDate;
	}

	public void setEarlyWarningDate(String earlyWarningDate) {
		this.earlyWarningDate = earlyWarningDate;
	}

	public String getCustomerTyoe() {
		return customerTyoe;
	}

	public void setCustomerTyoe(String customerTyoe) {
		this.customerTyoe = customerTyoe;
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
