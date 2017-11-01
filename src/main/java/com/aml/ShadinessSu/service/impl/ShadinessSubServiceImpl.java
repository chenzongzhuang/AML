package com.aml.ShadinessSu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.ShadinessSu.service.ShadinessSubService;
import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.shadinessSub.entity.ShadinessSub;
import com.aml.shadinessSub.mapper.ShadinessSubMapper;
/**
 * 待确认可疑
 * @author zhongrui
 *
 */


@Service
public class ShadinessSubServiceImpl implements ShadinessSubService{

	@Autowired
	ShadinessSubMapper shadinessSubMapper;
	@Override
	public List<ShadinessSub> find(ShadinessSub shadinessSub) {
		return shadinessSubMapper.find(shadinessSub);
	}

	@Override
	public List<ShadinessSub> qyeryCount(ShadinessSub shadinessSub) {
		return shadinessSubMapper.qyeryCount(shadinessSub);
	}

	@Override
	public void updateById(ShadinessSub shadinessSub) {
		shadinessSubMapper.updateById(shadinessSub);
		
	}

	@Override
	public List<ShadinessSub> findTrd(ShadinessSub shadinessSub) {
		// TODO Auto-generated method stub
		return shadinessSubMapper.findTrd(shadinessSub);
	}

	@Override
	public List<ShadinessSub> qyeryCountTrd(ShadinessSub shadinessSub) {
		// TODO Auto-generated method stub
		return shadinessSubMapper.qyeryCount(shadinessSub);
	}

	@Override
	public void updateTrdById(ShadinessSub shadinessSub) {
		shadinessSubMapper.updateTrdById(shadinessSub);
	}

}
