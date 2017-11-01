package com.aml.crMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanBact;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanBactMapper extends BaseMapper<TStanBact> {
	List<TStanBact> findAllTStanBact(Page page, @Param("ctifId") String ctifId);
}
