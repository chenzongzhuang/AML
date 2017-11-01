package com.aml.earlyWarning.entity;

import com.baomidou.mybatisplus.annotations.TableField;

public class BaseEntity {
	@TableField(exist = false)
	private String startEsseBriDate;
	
	@TableField(exist = false)
	private String endEsseBriDate;
	
	@TableField(exist = false)
	private String startEsseCreateDate;
	
	@TableField(exist = false)
	private String endEsseCreateDate;
	
	public String getStartEsseBriDate() {
		return startEsseBriDate;
	}
	public void setStartEsseBriDate(String startEsseBriDate) {
		this.startEsseBriDate = startEsseBriDate;
	}
	public String getEndEsseBriDate() {
		return endEsseBriDate;
	}
	public void setEndEsseBriDate(String endEsseBriDate) {
		this.endEsseBriDate = endEsseBriDate;
	}
	public String getStartEsseCreateDate() {
		return startEsseCreateDate;
	}
	public void setStartEsseCreateDate(String startEsseCreateDate) {
		this.startEsseCreateDate = startEsseCreateDate;
	}
	public String getEndEsseCreateDate() {
		return endEsseCreateDate;
	}
	public void setEndEsseCreateDate(String endEsseCreateDate) {
		this.endEsseCreateDate = endEsseCreateDate;
	}
	
	

}
