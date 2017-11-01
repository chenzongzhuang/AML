package com.aml.crMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanAddress;
import com.aml.crMng.entity.TStanTel;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanTelService extends IService<TStanTel> {
	/**
	 * 根据客户号查询联系信息
	 * @param busiRegNo
	 * @return
	 */
	List<TStanTel> findAllTStanTel(Page page,@Param("ctifId") String ctifId);
}
