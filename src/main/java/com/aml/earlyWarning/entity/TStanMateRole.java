
package com.aml.earlyWarning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 匹配规则
 * @author zhongrui
 *
 */

public class TStanMateRole extends Model<TStanMateRole>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value="mate_id", type= IdType.UUID)
	private String mateId;
	
	private String mateNo;
	
	private String mateName;
	
	private String mateType;
	
	private String mateTypeRoll;
	
	private String mateDesc;
	
	private String mateRoleCon;
	
	private String mateStatus;
	
	private String mateCreateDate;
	
	private String mateCreateBy;
	
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

	public String getMateId() {
		return mateId;
	}

	public void setMateId(String mateId) {
		this.mateId = mateId;
	}

	public String getMateNo() {
		return mateNo;
	}

	public void setMateNo(String mateNo) {
		this.mateNo = mateNo;
	}

	public String getMateName() {
		return mateName;
	}

	public void setMateName(String mateName) {
		this.mateName = mateName;
	}

	public String getMateType() {
		return mateType;
	}

	public void setMateType(String mateType) {
		this.mateType = mateType;
	}

	public String getMateTypeRoll() {
		return mateTypeRoll;
	}

	public void setMateTypeRoll(String mateTypeRoll) {
		this.mateTypeRoll = mateTypeRoll;
	}

	public String getMateDesc() {
		return mateDesc;
	}

	public void setMateDesc(String mateDesc) {
		this.mateDesc = mateDesc;
	}

	public String getMateRoleCon() {
		return mateRoleCon;
	}

	public void setMateRoleCon(String mateRoleCon) {
		this.mateRoleCon = mateRoleCon;
	}

	public String getMateStatus() {
		return mateStatus;
	}

	public void setMateStatus(String mateStatus) {
		this.mateStatus = mateStatus;
	}

	public String getMateCreateDate() {
		return mateCreateDate;
	}

	public void setMateCreateDate(String mateCreateDate) {
		this.mateCreateDate = mateCreateDate;
	}

	public String getMateCreateBy() {
		return mateCreateBy;
	}

	public void setMateCreateBy(String mateCreateBy) {
		this.mateCreateBy = mateCreateBy;
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
