package com.aml.etl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("t_etl_baseset")
public class EtlBaseset extends Model<EtlBaseset>{
	private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String code;
	private String dataPkgTp;
	private String dataPath;
	private String dataBackPath;
	private String dataUnzipPath;
	private String dataSource;
	private String dataCoverTp;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDataCoverTp() {
		return dataCoverTp;
	}


	public void setDataCoverTp(String dataCoverTp) {
		this.dataCoverTp = dataCoverTp;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDataPkgTp() {
		return dataPkgTp;
	}


	public void setDataPkgTp(String dataPkgTp) {
		this.dataPkgTp = dataPkgTp;
	}


	public String getDataPath() {
		return dataPath;
	}


	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}


	public String getDataBackPath() {
		return dataBackPath;
	}


	public void setDataBackPath(String dataBackPath) {
		this.dataBackPath = dataBackPath;
	}


	public String getDataUnzipPath() {
		return dataUnzipPath;
	}


	public void setDataUnzipPath(String dataUnzipPath) {
		this.dataUnzipPath = dataUnzipPath;
	}


	public String getDataSource() {
		return dataSource;
	}


	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}




	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return id;
	}

}
