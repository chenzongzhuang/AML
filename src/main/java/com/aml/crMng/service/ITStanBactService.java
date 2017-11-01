package com.aml.crMng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanBact;
import com.aml.crMng.entity.TStanCert;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanBactService extends IService<TStanBact> {
	/**
	 * 
	 * @param page
	 * @param ctifId
	 * @return
	 */
	List<TStanBact> findAllTStanBact(Page page,@Param("ctifId") String ctifId);
}
