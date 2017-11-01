package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TPstrRbif;
import com.aml.crMng.mapper.TPstrRbifMapper;
import com.aml.crMng.service.ITPstrRbifService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TPstrRbifServiceImpl extends ServiceImpl<TPstrRbifMapper, TPstrRbif> implements ITPstrRbifService {
	@Autowired
	TPstrRbifMapper tPstrRbifMapper;

	@Override
	public List<TPstrRbif> findAllTPstrRbif(Page page) {
		return tPstrRbifMapper.findAllTPstrRbif(page);
	}

}
