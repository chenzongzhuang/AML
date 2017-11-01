package com.aml.crMng.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanTel;
import com.aml.crMng.mapper.TStanTelMapper;
import com.aml.crMng.service.ITStanTelService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TStanTelServiceImpl extends ServiceImpl<TStanTelMapper, TStanTel> implements ITStanTelService {
	@Autowired
	TStanTelMapper tStanTelMapper;
	
	@Override
	public List<TStanTel> findAllTStanTel(Page page, String ctifId) {
		return tStanTelMapper.findAllTStanTel(page, ctifId);
	}

}
