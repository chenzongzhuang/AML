package com.aml.earlyWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.earlyWarning.entity.TStanAreaRoll;
import com.aml.earlyWarning.mapper.TStanAreaRollMapper;
import com.aml.earlyWarning.service.TStanAreaRollService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanAreaRollServiceImpl extends ServiceImpl<TStanAreaRollMapper, TStanAreaRoll> implements TStanAreaRollService{

	@Autowired
	TStanAreaRollMapper tStanAreaRollMapper;
	@Override
	public List<TStanAreaRoll> find(TStanAreaRoll tStanAreaRoll)
			throws Exception {
		return tStanAreaRollMapper.find(tStanAreaRoll);
	}

	@Override
	public void add(TStanAreaRoll tStanAreaRoll) throws Exception {
		tStanAreaRollMapper.add(tStanAreaRoll);
	}

	@Override
	public List<TStanAreaRoll> qyeryCount(TStanAreaRoll tStanAreaRoll)
			throws Exception {
		return tStanAreaRollMapper.qyeryCount(tStanAreaRoll);
	}

	@Override
	public void deleteByrollId(List<String> rollIdDelete) throws Exception {
		tStanAreaRollMapper.deleteByrollId(rollIdDelete);
		
	}

	@Override
	public void updateByrollId(TStanAreaRoll tStanAreaRoll) throws Exception {
		tStanAreaRollMapper.updateByrollId(tStanAreaRoll);
		
	}

}
