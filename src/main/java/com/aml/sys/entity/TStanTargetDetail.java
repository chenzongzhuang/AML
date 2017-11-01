package com.aml.sys.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class TStanTargetDetail {
	
	@TableId(value="target_detail_id",type=IdType.UUID)
	 private String  targetDetailId ;
	 
	 private String targetNo ;
	 
	 private String targetDesc ;//指标描述
	 
	 private String targetCountConDesc ;//分组属性
	 
	 private Date targetCreateDate ;//指标创建时间
	 
	 private String targetEnable ;//是否停用
	 
	 private String targetColumn1 ;
	 
	 private String targetId;//与target_entity关联Id
	 
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

		public String getTargetDetailId() {
			return targetDetailId;
		}

		public void setTargetDetailId(String targetDetailId) {
			this.targetDetailId = targetDetailId;
		}

		public String getTargetNo() {
			return targetNo;
		}

		public void setTargetNo(String targetNo) {
			this.targetNo = targetNo;
		}

		public String getTargetDesc() {
			return targetDesc;
		}

		public void setTargetDesc(String targetDesc) {
			this.targetDesc = targetDesc;
		}

		public String getTargetCountConDesc() {
			return targetCountConDesc;
		}

		public void setTargetCountConDesc(String targetCountConDesc) {
			this.targetCountConDesc = targetCountConDesc;
		}

		public Date getTargetCreateDate() {
			return targetCreateDate;
		}

		public void setTargetCreateDate(Date targetCreateDate) {
			this.targetCreateDate = targetCreateDate;
		}

		public String getTargetEnable() {
			return targetEnable;
		}

		public void setTargetEnable(String targetEnable) {
			this.targetEnable = targetEnable;
		}

		public String getTargetColumn1() {
			return targetColumn1;
		}

		public void setTargetColumn1(String targetColumn1) {
			this.targetColumn1 = targetColumn1;
		}

		public String getTargetId() {
			return targetId;
		}

		public void setTargetId(String targetId) {
			this.targetId = targetId;
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
			this.currentPage = ((Integer.valueOf(this.page)-1)*Integer.valueOf(this.rows)+1);
		}

		public int getCurrentReslut() {
			return currentReslut;
		}

		public void setCurrentReslut(int currentReslut) {
			this.currentReslut = (Integer.valueOf(this.page))*Integer.valueOf(this.rows);
		}
		
		
 

}
