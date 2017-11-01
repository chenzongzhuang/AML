package com.aml.crMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanCert;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanCertMapper extends BaseMapper<TStanCert> {
	
	List<TStanCert> findAllTStanCert(Page page,@Param("ctifId") String ctifId);
	
}
