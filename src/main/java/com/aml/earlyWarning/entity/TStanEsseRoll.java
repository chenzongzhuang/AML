package com.aml.earlyWarning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 观察名单
 * @author zhongrui
 *
 */

public class TStanEsseRoll extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value="esse_id ", type= IdType.UUID)
	private String  esseId;
	
	private String esseName;//实体名称
	
	private String esseNation;//国籍/注册国家
	
	private String esseCustType;//身份类型
	
	private String esseCustName;//身份号
	
	private String esseBriDate;//出生/注册日期
	
	private String esseAddress;//联系地址
	
	private String esseTel;//联系电话
	
	private String esseRollCategory;//名单类别
	
	private String esseRollSource;//名单来源
	
	private String esseType;//名单种类
	
	private String esseCreateDate;//创建时间
	
	private String esseCreateBy;//创建人
	
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
	
	public String getEsseId() {
		return esseId;
	}

	public void setEsseId(String esseId) {
		this.esseId = esseId;
	}

	public String getEsseName() {
		return esseName;
	}

	public void setEsseName(String esseName) {
		this.esseName = esseName;
	}

	public String getEsseNation() {
		return esseNation;
	}

	public void setEsseNation(String esseNation) {
		this.esseNation = esseNation;
	}

	public String getEsseCustType() {
		return esseCustType;
	}

	public void setEsseCustType(String esseCustType) {
		this.esseCustType = esseCustType;
	}

	public String getEsseCustName() {
		return esseCustName;
	}

	public void setEsseCustName(String esseCustName) {
		this.esseCustName = esseCustName;
	}

	public String getEsseBriDate() {
		return esseBriDate;
	}

	public void setEsseBriDate(String esseBriDate) {
		this.esseBriDate = esseBriDate;
	}

	public String getEsseAddress() {
		return esseAddress;
	}

	public void setEsseAddress(String esseAddress) {
		this.esseAddress = esseAddress;
	}

	public String getEsseTel() {
		return esseTel;
	}

	public void setEsseTel(String esseTel) {
		this.esseTel = esseTel;
	}

	public String getEsseRollCategory() {
		return esseRollCategory;
	}

	public void setEsseRollCategory(String esseRollCategory) {
		this.esseRollCategory = esseRollCategory;
	}

	public String getEsseRollSource() {
		return esseRollSource;
	}

	public void setEsseRollSource(String esseRollSource) {
		this.esseRollSource = esseRollSource;
	}

	public String getEsseType() {
		return esseType;
	}

	public void setEsseType(String esseType) {
		this.esseType = esseType;
	}

	public String getEsseCreateDate() {
		return esseCreateDate;
	}

	public void setEsseCreateDate(String esseCreateDate) {
		this.esseCreateDate = esseCreateDate;
	}

	public String getEsseCreateBy() {
		return esseCreateBy;
	}

	public void setEsseCreateBy(String esseCreateBy) {
		this.esseCreateBy = esseCreateBy;
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
