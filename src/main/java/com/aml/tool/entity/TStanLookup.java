package com.aml.tool.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class TStanLookup extends Model<TStanLookup>{
	

	private static final long serialVersionUID = 1L;

	@TableId(value="lookup_id", type= IdType.UUID)
	private String lookupId;
	
	private String lookupType;
	
	private String lookupName;
	
	private String lookupEn;
	
	private String lookupDesc;
	
	private String lookupNum;
	
	private String lookupCreateDate;
	
	private String lookupCreateBy;
	
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

	public String getLookupId() {
		return lookupId;
	}

	public void setLookupId(String lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public String getLookupEn() {
		return lookupEn;
	}

	public void setLookupEn(String lookupEn) {
		this.lookupEn = lookupEn;
	}

	public String getLookupDesc() {
		return lookupDesc;
	}

	public void setLookupDesc(String lookupDesc) {
		this.lookupDesc = lookupDesc;
	}

	public String getLookupNum() {
		return lookupNum;
	}

	public void setLookupNum(String lookupNum) {
		this.lookupNum = lookupNum;
	}

	public String getLookupCreateDate() {
		return lookupCreateDate;
	}

	public void setLookupCreateDate(String lookupCreateDate) {
		this.lookupCreateDate = lookupCreateDate;
	}

	public String getLookupCreateBy() {
		return lookupCreateBy;
	}

	public void setLookupCreateBy(String lookupCreateBy) {
		this.lookupCreateBy = lookupCreateBy;
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

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
