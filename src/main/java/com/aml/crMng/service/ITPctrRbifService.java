package com.aml.crMng.service;

import java.util.List;


import com.aml.crMng.entity.TPctrRbif;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ITPctrRbifService extends IService<TPctrRbif> {
	/**
	 * 
	 * @param page
	 * @return
	 */
	List<TPctrRbif> findAllTPctrRbif(Page page);
}
