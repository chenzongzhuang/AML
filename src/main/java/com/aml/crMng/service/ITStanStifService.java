package com.aml.crMng.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanStif;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanStifService extends IService<TStanStif> {
	/**
	 * 
	 * @param page
	 * @param tsdr
	 * @param cratLeft
	 * @param cratRight
	 * @param ticd
	 * @param tstmStart
	 * @param tstmEnd
	 * @return
	 */
	List<TStanStif> findAllTStanStif(Page page, @Param("tsdr") String tsdr, @Param("cratLeft") BigDecimal cratLeft,
			@Param("cratRight") BigDecimal cratRight, @Param("ticd") String ticd, @Param("tstmStart") Date tstmStart,
			@Param("tstmEnd") Date tstmEnd);

}
