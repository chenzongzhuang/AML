package com.aml.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 复合指标模型
 * @author zhongrui
 *
 */

public class TStanTargetCom extends Model<TStanTargetCom>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String targetNo ;//指标编号
	
	@TableId(value="target_id", type= IdType.UUID)
	private String targetId ;//
	
	private String targetName ;//指标名称
	
	private String targetDesc ;//指标描述
	
	private String targetCount ;//统计指标
	
	private String targetCountFun  ;//统计函数
	
	private String targetCountPer  ;//统计周期
	
	private String targetCountContaion  ;//包含当前
	
	private String targetCountCon  ;//统计条件
	
	private String targetCountProperties ; //统计属性
	
	private String targetCreateDate ;//创建时间
	
	private String targetEnable  ;//是否停用
	
	private String targetColumn1 ;
	
	@TableField(exist = false)
	private String page;//当前页数
	
	@TableField(exist = false)
	private String rows;//每页显示行数
	
	@TableField(exist = false)
	private String total;//总的页数
	
	@TableField(exist = false)
	private String type;//交易类型
	
	@TableField(exist = false)
	private int currentPage;
	
	@TableField(exist = false)
	private int currentReslut;

	public String getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getTargetDesc() {
		return targetDesc;
	}

	public void setTargetDesc(String targetDesc) {
		this.targetDesc = targetDesc;
	}

	public String getTargetCount() {
		return targetCount;
	}

	public void setTargetCount(String targetCount) {
		this.targetCount = targetCount;
	}

	public String getTargetCountFun() {
		return targetCountFun;
	}

	public void setTargetCountFun(String targetCountFun) {
		this.targetCountFun = targetCountFun;
	}

	public String getTargetCountPer() {
		return targetCountPer;
	}

	public void setTargetCountPer(String targetCountPer) {
		this.targetCountPer = targetCountPer;
	}

	public String getTargetCountContaion() {
		return targetCountContaion;
	}

	public void setTargetCountContaion(String targetCountContaion) {
		this.targetCountContaion = targetCountContaion;
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

	public String getTargetCreateDate() {
		return targetCreateDate;
	}

	public void setTargetCreateDate(String targetCreateDate) {
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
		this.currentPage = ((Integer.valueOf(this.page)-1)*Integer.valueOf(this.rows));
	}

	public int getCurrentReslut() {
		return currentReslut;
	}

	public void setCurrentReslut() {
		this.currentReslut = (Integer.valueOf(this.page))*Integer.valueOf(this.rows);
	}

	
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCurrentReslut(int currentReslut) {
		this.currentReslut = currentReslut;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
