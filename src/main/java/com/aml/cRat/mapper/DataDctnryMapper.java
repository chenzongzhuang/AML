package com.aml.cRat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.DataDctnry;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface DataDctnryMapper extends BaseMapper<CRat> {
	/**
	 * 通过元素组号查询数据
	 */
	List<DataDctnry> findAllDataDctnry(Page page,@Param("grpCd") String grpCd);	

}