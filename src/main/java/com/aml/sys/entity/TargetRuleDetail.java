package com.aml.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 指标规则详细
 * @author zhongrui
 *
 */
public class TargetRuleDetail extends Model<TargetRuleDetail>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value="rule_id", type= IdType.UUID)
	private String ruleId ;
	
	private String targetRuleId ;
	
	private String ruleNo ;
	
	private String ruleName ;
	
	private String ruleConditionName ;
	
	private String ruleCategory ;
	
	private String ruleDesc ;
	
	private Date ruleCreateDate ;
	
	private String ruleEnable;
	
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

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getTargetRuleId() {
		return targetRuleId;
	}

	public void setTargetRuleId(String targetRuleId) {
		this.targetRuleId = targetRuleId;
	}

	public String getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleConditionName() {
		return ruleConditionName;
	}

	public void setRuleConditionName(String ruleConditionName) {
		this.ruleConditionName = ruleConditionName;
	}

	public String getRuleCategory() {
		return ruleCategory;
	}

	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public Date getRuleCreateDate() {
		return ruleCreateDate;
	}

	public void setRuleCreateDate(Date ruleCreateDate) {
		this.ruleCreateDate = ruleCreateDate;
	}

	public String getRuleEnable() {
		return ruleEnable;
	}

	public void setRuleEnable(String ruleEnable) {
		this.ruleEnable = ruleEnable;
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

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
