package com.aml.crMng.mapper;

import java.util.List;

import com.aml.crMng.entity.TPstrRbif;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TPstrRbifMapper extends BaseMapper<TPstrRbif> {
	/**
	 * 根据查询可疑报告信息
	 * @param busiRegNo
	 * @return
	 */
	List<TPstrRbif> findAllTPstrRbif(Page page);
}
