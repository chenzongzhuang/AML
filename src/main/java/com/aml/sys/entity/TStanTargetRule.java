package com.aml.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 监测规则模型
 * @author zhongrui
 *
 */
public class TStanTargetRule  extends Model<TStanTargetRule>{
	
	@TableId(value="rule_id", type= IdType.UUID)
	private String 	ruleId  ;   
	
	private String	ruleNo  ;// 规则编号
	
	private String	ruleName   ;  //规则名称
	
	private String	ruleCategory ;  // 规则类别
	
	private String	ruleApply   ; //适用范围
	
	private String	rulePer   ;  //筛选周期 
	
	private String	ruleCondition ; //规则条件
	
	private String	ruleStatus ;  //状态
	
	private String	ruleDesc  ;  //规则描述 
	
	private String	ruleCreateDate;//创建时间
	
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

	public String getRuleCategory() {
		return ruleCategory;
	}

	public void setRuleCategory(String ruleCategory) {
		this.ruleCategory = ruleCategory;
	}

	public String getRuleApply() {
		return ruleApply;
	}

	public void setRuleApply(String ruleApply) {
		this.ruleApply = ruleApply;
	}

	public String getRulePer() {
		return rulePer;
	}

	public void setRulePer(String rulePer) {
		this.rulePer = rulePer;
	}

	public String getRuleCondition() {
		return ruleCondition;
	}

	public void setRuleCondition(String ruleCondition) {
		this.ruleCondition = ruleCondition;
	}

	public String getRuleStatus() {
		return ruleStatus;
	}

	public void setRuleStatus(String ruleStatus) {
		this.ruleStatus = ruleStatus;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getRuleCreateDate() {
		return ruleCreateDate;
	}

	public void setRuleCreateDate(String ruleCreateDate) {
		this.ruleCreateDate = ruleCreateDate;
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
