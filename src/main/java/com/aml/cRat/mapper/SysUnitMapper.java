package com.aml.cRat.mapper;

import java.util.List;

import com.aml.cRat.entity.SysUnit;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface SysUnitMapper extends BaseMapper<SysUnit> {
	/**
	 * 通过元素组号查询数据
	 */
	List<SysUnit> findAllSysUnit();	
	
}