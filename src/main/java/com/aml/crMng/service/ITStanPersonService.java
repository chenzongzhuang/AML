package com.aml.crMng.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.BakStanPerson;
import com.aml.crMng.entity.TStanPerson;
import com.baomidou.mybatisplus.service.IService;

public interface ITStanPersonService extends IService<TStanPerson> {
	/**
	 * 根据客户号查询数据
	 * @param busiRegNo
	 * @return
	 */
	List<TStanPerson> findAllTStanPerson(@Param("busiRegNo") String busiRegNo);

}
