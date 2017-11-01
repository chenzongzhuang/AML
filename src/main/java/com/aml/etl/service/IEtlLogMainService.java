package com.aml.etl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.etl.entity.EtlLogMain;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface IEtlLogMainService extends IService<EtlLogMain> {
	List<EtlLogMain> getEtlLogByColDtOrResult(Page page,@Param("colDt") String colDt,@Param("result") String result);
}
