package com.aml.sys.entity;

import java.io.Serializable;
import java.util.Date;

import org.jboss.logging.Field;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 监测指标
 * @author zhongrui
 *
 */

public class TargetEntity extends Model<TargetEntity>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value="target_id", type= IdType.UUID)
	private String targetId;//
	
	private String targetNo;//指标编号
	
	private String targetDesc;//指标描述
	
	private String targetProperties;//分组属性
	
	private String targetCountFun;//统计函数
	
	private String targetCountCon;//统计条件
	
	private String targetCountProperties;//统计属性
	
	private Date targetCreateDate;//指标创建时间
	
	private String targetEnable;//是否停用
	
	private String targetColumn1;
	
	private String targetName;//指标名称
	
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
	
	
	public String getTargetId() {
		return targetId;
	}



	public void setTargetId(String targetId) {
		this.targetId = targetId;
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



	public String getTargetProperties() {
		return targetProperties;
	}



	public void setTargetProperties(String targetProperties) {
		this.targetProperties = targetProperties;
	}



	public String getTargetCountFun() {
		return targetCountFun;
	}



	public void setTargetCountFun(String targetCountFun) {
		this.targetCountFun = targetCountFun;
	}



	public String getTargetCountCon() {
		return targetCountCon;
	}



	public void setTargetCountCon(String targetCountCon) {
		this.targetCountCon = targetCountCon;
	}



	public String getTargetCountProperties() {
		return targetCountProperties;
	}



	public void setTargetCountProperties(String targetCountProperties) {
		this.targetCountProperties = targetCountProperties;
	}

	public String getTargetName() {
		return targetName;
	}



	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
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



	public void setCurrentReslut() {
		this.currentReslut = (Integer.valueOf(this.page))*Integer.valueOf(this.rows);
	}
	
	
	
	
	
	
	

}
