package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TPctrRbif;
import com.aml.crMng.mapper.TPctrRbifMapper;
import com.aml.crMng.service.ITPctrRbifService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TPctrRbifServiceImpl extends ServiceImpl<TPctrRbifMapper, TPctrRbif> implements ITPctrRbifService {

	@Autowired
	TPctrRbifMapper tPctrRbifMapper;
	@Override
	public List<TPctrRbif> findAllTPctrRbif(Page page) {
		return tPctrRbifMapper.findAllTPctrRbif(page);
	}

}
