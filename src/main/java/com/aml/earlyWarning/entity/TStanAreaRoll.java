package com.aml.earlyWarning.entity;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 地区观察名单
 * @author zhongrui
 *
 */
public class TStanAreaRoll extends BaseEntity{
	
	private String areaRollId;//
	
	private String areaRollType;//名单种类
	
	private String areaType;//地区类型
	
	private String areaEn;//地区名称
	
	private String areaName;//身份号
	
	private String areaQu;//备注
	
	private String areaCreateDate;//创建时间
	
	private String areaCreateBy;//创建人员
	
	private String aresUpdateDate;//更新时间
	
	private String areaUpdateBy;//更新人员
	
	private String areaModel;//地区代码
	
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

		public String getAreaRollId() {
			return areaRollId;
		}

		public void setAreaRollId(String areaRollId) {
			this.areaRollId = areaRollId;
		}

		public String getAreaRollType() {
			return areaRollType;
		}

		public void setAreaRollType(String areaRollType) {
			this.areaRollType = areaRollType;
		}

		public String getAreaType() {
			return areaType;
		}

		public void setAreaType(String areaType) {
			this.areaType = areaType;
		}

		public String getAreaEn() {
			return areaEn;
		}

		public void setAreaEn(String areaEn) {
			this.areaEn = areaEn;
		}

		public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}

		public String getAreaQu() {
			return areaQu;
		}

		public void setAreaQu(String areaQu) {
			this.areaQu = areaQu;
		}

		public String getAreaCreateDate() {
			return areaCreateDate;
		}

		public void setAreaCreateDate(String areaCreateDate) {
			this.areaCreateDate = areaCreateDate;
		}

		public String getAreaCreateBy() {
			return areaCreateBy;
		}

		public void setAreaCreateBy(String areaCreateBy) {
			this.areaCreateBy = areaCreateBy;
		}

		public String getAresUpdateDate() {
			return aresUpdateDate;
		}

		public void setAresUpdateDate(String aresUpdateDate) {
			this.aresUpdateDate = aresUpdateDate;
		}

		public String getAreaUpdateBy() {
			return areaUpdateBy;
		}

		public void setAreaUpdateBy(String areaUpdateBy) {
			this.areaUpdateBy = areaUpdateBy;
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

		public String getAreaModel() {
			return areaModel;
		}

		public void setAreaModel(String areaModel) {
			this.areaModel = areaModel;
		}
		
		
	
	


}
