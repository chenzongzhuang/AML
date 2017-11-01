package com.aml.crMng.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanStif;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanStifMapper extends BaseMapper<TStanStif> {
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
