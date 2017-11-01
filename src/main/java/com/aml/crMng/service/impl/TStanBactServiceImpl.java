package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanBact;
import com.aml.crMng.mapper.TStanBactMapper;
import com.aml.crMng.service.ITStanBactService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanBactServiceImpl extends ServiceImpl<TStanBactMapper, TStanBact> implements ITStanBactService {
	@Autowired
	TStanBactMapper tStanBactMapper;
	@Override
	public List<TStanBact> findAllTStanBact(Page page, String ctifId) {
		return tStanBactMapper.findAllTStanBact(page, ctifId);
	}

}
