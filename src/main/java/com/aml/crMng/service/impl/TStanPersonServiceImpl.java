package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanPerson;
import com.aml.crMng.mapper.TStanPersonMapper;
import com.aml.crMng.service.ITStanPersonService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanPersonServiceImpl extends ServiceImpl<TStanPersonMapper, TStanPerson> implements ITStanPersonService {

	@Autowired
	TStanPersonMapper tStanPersonMapper;

	@Override
	public List<TStanPerson> findAllTStanPerson(String busiRegNo) {
		return tStanPersonMapper.findAllTStanPerson(busiRegNo);
	}

}
