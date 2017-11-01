package com.aml.etl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.etl.entity.EtlLogMain;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface EtlLogMainMapper extends BaseMapper<EtlLogMain> {
	
	List<EtlLogMain> getEtlLogByColDtOrResult(Page page,@Param("colDt") String colDt,@Param("result") String result);
}
