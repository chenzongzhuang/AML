package com.aml.crMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanAddress;
import com.aml.crMng.entity.TStanCert;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanAddressService extends IService<TStanAddress> {
	/**
	 * 根据客户号查询地址信息
	 * @param busiRegNo
	 * @return
	 */
	List<TStanAddress> findAllTStanAddress(Page page,@Param("ctifId") String ctifId);
}
