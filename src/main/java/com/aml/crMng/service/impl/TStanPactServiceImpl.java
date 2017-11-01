package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanPact;
import com.aml.crMng.mapper.TStanPactMapper;
import com.aml.crMng.service.ITStanPactService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TStanPactServiceImpl extends ServiceImpl<TStanPactMapper, TStanPact> implements ITStanPactService {
	@Autowired
	TStanPactMapper tStanPactMapper;
	@Override
	public List<TStanPact> findAllTStanPact(Page page, String ctifId) {
		return tStanPactMapper.findAllTStanPact(page, ctifId);
	}

}
