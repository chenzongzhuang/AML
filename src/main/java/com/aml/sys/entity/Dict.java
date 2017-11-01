
package com.aml.sys.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 */
public class Dict extends Model<Dict> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 类别
     */
	private String dmTp;
    /**
     * 代码
     */
	private String dmCd;
    /**
     * 名称
     */
	private String dmNm;
    /**
     * 父码
     */
	private String dmSp;
    /**
     * 备注
     */
	private String dmDs;
   


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDmTp() {
		return dmTp;
	}

	public void setDmTp(String dmTp) {
		this.dmTp = dmTp;
	}

	public String getDmCd() {
		return dmCd;
	}

	public void setDmCd(String dmCd) {
		this.dmCd = dmCd;
	}

	public String getDmNm() {
		return dmNm;
	}

	public void setDmNm(String dmNm) {
		this.dmNm = dmNm;
	}

	public String getDmSp() {
		return dmSp;
	}

	public void setDmSp(String dmSp) {
		this.dmSp = dmSp;
	}

	public String getDmDs() {
		return dmDs;
	}

	public void setDmDs(String dmDs) {
		this.dmDs = dmDs;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


}
