package com.aml.crMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanPact;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanPactMapper extends BaseMapper<TStanPact> {
	List<TStanPact> findAllTStanPact(Page page, @Param("ctifId") String ctifId);
}
