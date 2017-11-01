package com.aml.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TStanTargetDetail;
import com.aml.sys.mapper.TStanTargetDetailMapper;
import com.aml.sys.service.TStanTargetDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanTargetDetailServiceImpl extends ServiceImpl<TStanTargetDetailMapper, TStanTargetDetail> implements TStanTargetDetailService{

	@Autowired
	private TStanTargetDetailMapper tStanTargetDetailMapper ;

	@Override
	public List<TStanTargetDetail> findTarget(
			TStanTargetDetail tStanTargetDetail) throws Exception {
		
		return tStanTargetDetailMapper.findTarget(tStanTargetDetail);
	}

	@Override
	public List<TStanTargetDetail> selectTargets(
			TStanTargetDetail tStanTargetDetail) throws Exception {
		// TODO Auto-generated method stub
		return tStanTargetDetailMapper.selectTargets(tStanTargetDetail);
	}

	@Override
	public void addTarget(TStanTargetDetail tStanTargetDetail) throws Exception {
		tStanTargetDetailMapper.addTarget(tStanTargetDetail);
		
	}

	@Override
	public int CountTargets(TStanTargetDetail tStanTargetDetail)
			throws Exception {
		
		return 0;
	}


	@Override
	public void deleteTargetByTargetId(TStanTargetDetail tStanTargetDetail)
			throws Exception {
		tStanTargetDetailMapper.deleteTargetByTargetId(tStanTargetDetail);
		
	}

	@Override
	public void updateTargetByTargetId(TStanTargetDetail tStanTargetDetail)
			throws Exception {
		tStanTargetDetailMapper.updateTargetByTargetId(tStanTargetDetail);
		
	}
	
	

}
