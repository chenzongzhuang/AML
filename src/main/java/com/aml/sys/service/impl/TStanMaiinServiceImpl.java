package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TStanMaiin;
import com.aml.sys.mapper.TStanMaiinMapper;
import com.aml.sys.service.TStanMaiinService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanMaiinServiceImpl extends ServiceImpl<TStanMaiinMapper, TStanMaiin> implements TStanMaiinService{ 

	@Autowired
	TStanMaiinMapper tStanMaiinMapper ;
	@Override
	public List<TStanMaiin> findTarget(TStanMaiin tStanMaiin) {
		// TODO Auto-generated method stub
		return tStanMaiinMapper.findTarget(tStanMaiin);
	}

	@Override
	public void addTarget(TStanMaiin tStanMaiin) {
		tStanMaiinMapper.addTarget(tStanMaiin);
	}

	@Override
	public List<TStanMaiin> qyeryUserTarget(TStanMaiin tStanMaiin) {
		// TODO Auto-generated method stub
		return tStanMaiinMapper.qyeryUserTarget(tStanMaiin);
	}

	@Override
	public void deleteTargetByTargetId(TStanMaiin tStanMaiin) {
		tStanMaiinMapper.deleteTargetByTargetId(tStanMaiin);
	}

	@Override
	public void updateTargetByTargetId(TStanMaiin tStanMaiin) {
		tStanMaiinMapper.updateTargetByTargetId(tStanMaiin);
	}

}
