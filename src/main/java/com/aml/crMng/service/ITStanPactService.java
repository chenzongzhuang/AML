package com.aml.crMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanCert;
import com.aml.crMng.entity.TStanPact;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanPactService extends IService<TStanPact> {
	/**
	 * 根据客户号查询证件信息
	 * @param busiRegNo
	 * @return
	 */
	List<TStanPact> findAllTStanPact(Page page,@Param("ctifId") String ctifId);

}
