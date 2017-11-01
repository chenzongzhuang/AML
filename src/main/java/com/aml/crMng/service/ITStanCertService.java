package com.aml.crMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanCert;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanCertService extends IService<TStanCert> {
	/**
	 * 根据客户号查询证件信息
	 * @param busiRegNo
	 * @return
	 */
	List<TStanCert> findAllTStanCert(Page page,@Param("ctifId") String ctifId);

	
	
	
	
	
	
}
