package com.aml.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

public class TStanMaiin  extends Model<TStanMaiin>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mainId ;
	
	private String mainType ;//类型
	
	private String mainEn ;//英文代码
	
	private String mainIn ;//数字代码
	
	private String mainCn ;//中文简称
	
	private String mainCnFull ;//中文全称
	
	private String mainEnName ;//英文简称
	
	private String mainEnFull ;//英文全称
	
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

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

	public String getMainType() {
		return mainType;
	}

	public void setMainType(String mainType) {
		this.mainType = mainType;
	}

	public String getMainEn() {
		return mainEn;
	}

	public void setMainEn(String mainEn) {
		this.mainEn = mainEn;
	}

	public String getMainIn() {
		return mainIn;
	}

	public void setMainIn(String mainIn) {
		this.mainIn = mainIn;
	}

	public String getMainCn() {
		return mainCn;
	}

	public void setMainCn(String mainCn) {
		this.mainCn = mainCn;
	}

	public String getMainCnFull() {
		return mainCnFull;
	}

	public void setMainCnFull(String mainCnFull) {
		this.mainCnFull = mainCnFull;
	}

	public String getMainEnName() {
		return mainEnName;
	}

	public void setMainEnName(String mainEnName) {
		this.mainEnName = mainEnName;
	}

	public String getMainEnFull() {
		return mainEnFull;
	}

	public void setMainEnFull(String mainEnFull) {
		this.mainEnFull = mainEnFull;
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
