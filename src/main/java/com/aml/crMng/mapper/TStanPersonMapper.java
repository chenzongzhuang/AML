package com.aml.crMng.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.BakStanPerson;
import com.aml.crMng.entity.TStanPerson;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TStanPersonMapper extends BaseMapper<TStanPerson>{
	/**
	 * 查询
	 */
	List<TStanPerson> findAllTStanPerson(@Param("busiRegNo") String busiRegNo);
}
