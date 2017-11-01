package com.aml.earlyWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.earlyWarning.entity.TStanAreaRollType;
import com.aml.earlyWarning.mapper.TStanAreaRollTypeMapper;
import com.aml.earlyWarning.service.TStanAreaRollTypeService;
import com.aml.sys.entity.TradingStandard;
import com.aml.sys.mapper.TradingStandaraMapper;
import com.aml.sys.service.TradingStandaraMapperService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanAreaRollTypeServiceImpl extends ServiceImpl<TStanAreaRollTypeMapper, TStanAreaRollType> implements TStanAreaRollTypeService{

	@Autowired
	TStanAreaRollTypeMapper TStanAreaRollTypeMapper;
	
	@Override
	public List<TStanAreaRollType> find(TStanAreaRollType tStanAreaRollType)
			throws Exception {
		// TODO Auto-generated method stub
		return TStanAreaRollTypeMapper.find(tStanAreaRollType);
	}

	@Override
	public void add(TStanAreaRollType tStanAreaRollType) throws Exception {
		TStanAreaRollTypeMapper.add(tStanAreaRollType);
	}

	@Override
	public List<TStanAreaRollType> qyeryCount(
			TStanAreaRollType tStanAreaRollType) throws Exception {
		// TODO Auto-generated method stub
		return TStanAreaRollTypeMapper.qyeryCount(tStanAreaRollType);
	}

	@Override
	public void deleteByrollId(List<String> rollIdDelete)
			throws Exception {
		TStanAreaRollTypeMapper.deleteByrollId(rollIdDelete);
	}

	@Override
	public void updateByrollId(TStanAreaRollType tStanAreaRollType)
			throws Exception {
		TStanAreaRollTypeMapper.updateByrollId(tStanAreaRollType);
	}

}
