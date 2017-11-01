package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TradingStandard;
import com.aml.sys.mapper.TradingStandaraMapper;
import com.aml.sys.service.TradingStandaraMapperService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TradingStandardServiceImpl extends ServiceImpl<TradingStandaraMapper, TradingStandard> implements TradingStandaraMapperService{

	@Autowired
	TradingStandaraMapper tradingStandaraMapper;
	
	@Override
	public List<TradingStandard> findTarget(TradingStandard tradingStandard)
			throws Exception {
		// TODO Auto-generated method stub
		return tradingStandaraMapper.findTarget(tradingStandard);
	}

	@Override
	public void addTarget(TradingStandard tradingStandard) throws Exception {
		tradingStandaraMapper.addTarget(tradingStandard);
	}

	@Override
	public void deleteTargetByTargetId(TradingStandard tradingStandard)
			throws Exception {
		tradingStandaraMapper.deleteTargetByTargetId(tradingStandard);
	}

	@Override
	public void updateTargetByTargetId(TradingStandard tradingStandard)
			throws Exception {
		tradingStandaraMapper.updateTargetByTargetId(tradingStandard);
		
	}

}
