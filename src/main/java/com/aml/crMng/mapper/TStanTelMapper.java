package com.aml.crMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanCert;
import com.aml.crMng.entity.TStanTel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanTelMapper extends BaseMapper<TStanTel> {
	
	List<TStanTel> findAllTStanTel(Page page, @Param("ctifId") String ctifId);
	
}
