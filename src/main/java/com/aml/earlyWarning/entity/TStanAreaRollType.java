package com.aml.earlyWarning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 去噪规则
 * @author zhongrui
 *
 */

public class TStanAreaRollType extends Model<TStanAreaRollType>{
	
	
	private static final long serialVersionUID = 1L;

	@TableId(value="roll_id", type= IdType.UUID)
    private String rollId ;//
    
    private String rollEn ;//
    
    private String rollName ;//规则名称
    
    private String rollCont ;//规则内容
    
    private String rollDesc ;//规则描述
    
    private String rollType ;//规则类型
    
    private String rollCreateDate ;//创建时间
    
    private String rollCreateBy ;//创建人
    
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

	public String getRollId() {
		return rollId;
	}

	public void setRollId(String rollId) {
		this.rollId = rollId;
	}

	public String getRollEn() {
		return rollEn;
	}

	public void setRollEn(String rollEn) {
		this.rollEn = rollEn;
	}

	public String getRollName() {
		return rollName;
	}

	public void setRollName(String rollName) {
		this.rollName = rollName;
	}

	public String getRollCont() {
		return rollCont;
	}

	public void setRollCont(String rollCont) {
		this.rollCont = rollCont;
	}

	public String getRollDesc() {
		return rollDesc;
	}

	public void setRollDesc(String rollDesc) {
		this.rollDesc = rollDesc;
	}

	public String getRollType() {
		return rollType;
	}

	public void setRollType(String rollType) {
		this.rollType = rollType;
	}

	public String getRollCreate_date() {
		return rollCreateDate;
	}

	public void setRollCreate_date(String rollCreate_date) {
		this.rollCreateDate = rollCreate_date;
	}

	public String getRollCreateBy() {
		return rollCreateBy;
	}

	public void setRollCreateBy(String rollCreateBy) {
		this.rollCreateBy = rollCreateBy;
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
