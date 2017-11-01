package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanCert;
import com.aml.crMng.mapper.TStanCertMapper;
import com.aml.crMng.service.ITStanCertService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanCertServiceImpl extends ServiceImpl<TStanCertMapper, TStanCert> implements ITStanCertService {
	@Autowired
	TStanCertMapper tStanCertMapper;

	@Override
	public List<TStanCert> findAllTStanCert(Page page,String ctifId) {
		return tStanCertMapper.findAllTStanCert(page,ctifId);
	}

}
