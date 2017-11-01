package com.aml.crMng.service;

import java.util.List;

import com.aml.crMng.entity.TPstrRbif;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITPstrRbifService extends IService<TPstrRbif> {
	/**
	 * 根据查询可疑报告信息
	 * @param busiRegNo
	 * @return
	 */
	List<TPstrRbif> findAllTPstrRbif(Page page);
}
