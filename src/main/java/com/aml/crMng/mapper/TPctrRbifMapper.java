package com.aml.crMng.mapper;

import java.util.List;

import com.aml.crMng.entity.TPctrRbif;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TPctrRbifMapper extends BaseMapper<TPctrRbif> {
	/**
	 * 
	 * @param page
	 * @return
	 */
	List<TPctrRbif> findAllTPctrRbif(Page page);
}
