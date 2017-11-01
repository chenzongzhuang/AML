package com.aml.crMng.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.TStanStif;
import com.aml.crMng.mapper.TStanStifMapper;
import com.aml.crMng.service.ITStanStifService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
public class TStanStifServiceImpl extends ServiceImpl<TStanStifMapper, TStanStif> implements ITStanStifService {
	@Autowired
	TStanStifMapper tStanStifMapper;
	@Override
	public List<TStanStif> findAllTStanStif(Page page, String tsdr, BigDecimal cratLeft, BigDecimal cratRight,
			String ticd, Date tstmStart, Date tstmEnd) {
		return tStanStifMapper.findAllTStanStif(page, tsdr, cratLeft, cratRight, ticd, tstmStart, tstmEnd);
	}

}
