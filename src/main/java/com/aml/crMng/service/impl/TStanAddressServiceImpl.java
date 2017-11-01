package com.aml.crMng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanAddress;
import com.aml.crMng.mapper.TStanAddressMapper;
import com.aml.crMng.service.ITStanAddressService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TStanAddressServiceImpl extends ServiceImpl<TStanAddressMapper, TStanAddress> implements ITStanAddressService {
	@Autowired
	TStanAddressMapper tStanAddressMapper;

	@Override
	public List<TStanAddress> findAllTStanAddress(Page page, String ctifId) {
		return tStanAddressMapper.findAllTStanAddress(page, ctifId);
	}

}
