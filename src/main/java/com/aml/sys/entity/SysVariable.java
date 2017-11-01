package com.aml.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("dic_data")
public class SysVariable extends Model<SysVariable>{

	private static final long serialVersionUID = 1L;
	private String id;
	private String typKind;
	private String typCode;
	private String typName;
	private String typDesc;
	private String typSupCode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypKind() {
		return typKind;
	}

	public void setTypKind(String typKind) {
		this.typKind = typKind;
	}

	public String getTypCode() {
		return typCode;
	}

	public void setTypCode(String typCode) {
		this.typCode = typCode;
	}

	public String getTypName() {
		return typName;
	}

	public void setTypName(String typName) {
		this.typName = typName;
	}

	public String getTypDesc() {
		return typDesc;
	}

	public void setTypDesc(String typDesc) {
		this.typDesc = typDesc;
	}

	public String getTypSupCode() {
		return typSupCode;
	}

	public void setTypSupCode(String typSupCode) {
		this.typSupCode = typSupCode;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}
