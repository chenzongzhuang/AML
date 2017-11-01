package com.aml.cRat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 客户评级表
 * </p>
 *
 */
public class SysUnit extends Model<SysUnit> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，序号
     */
	@TableId(value="ID", type= IdType.AUTO)
	private Integer id ;//PK,ID
	private String code ;//机构代码
	private String name ;//机构名称
	private String pcode ;//上级机构
	private Timestamp createTime ;//创建时间
	private Timestamp updateTime ;//更新时间
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
	@Override
	public String toString() {
		return "SysUnit{" +
			"id=" + id +
			", code=" + code +
			", name=" + name +
			", pcode=" + pcode +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
