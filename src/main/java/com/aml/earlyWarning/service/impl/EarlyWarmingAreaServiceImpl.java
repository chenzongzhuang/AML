package com.aml.earlyWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.earlyWarning.mapper.EarlyWarmingAreaMapper;
import com.aml.earlyWarning.service.EarlyWarmingAreaService;

@Service
public class EarlyWarmingAreaServiceImpl implements EarlyWarmingAreaService{

	@Autowired EarlyWarmingAreaMapper earlyWarmingAreaMapper;
	@Override
	public List<EarlyWarmingArea> find(EarlyWarmingArea earlyWarmingArea) {
		// TODO Auto-generated method stub
		return earlyWarmingAreaMapper.find(earlyWarmingArea);
	}
	@Override
	public List<EarlyWarmingArea> qyeryCount(EarlyWarmingArea earlyWarmingArea) {
		// TODO Auto-generated method stub
		return earlyWarmingAreaMapper.qyeryCount(earlyWarmingArea);
	}

}
