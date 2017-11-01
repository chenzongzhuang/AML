package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TStanTargetCom;
import com.aml.sys.entity.TStanTargetDetail;
import com.aml.sys.mapper.TargetComMapper;
import com.aml.sys.service.TargetComService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TargetComServiceImp extends ServiceImpl<TargetComMapper,TStanTargetCom> implements TargetComService  {

	@Autowired
	TargetComMapper targetComMapper;

	@Override
	public List<TStanTargetCom> findTargetCom(TStanTargetCom tStanTargetCom)
			throws Exception {
		// TODO Auto-generated method stub
		return targetComMapper.findTargetCom(tStanTargetCom);
	}

	@Override
	public void addTargetCom(TStanTargetCom tStanTargetCom) throws Exception {
		// TODO Auto-generated method stub
		targetComMapper.addTargetCom(tStanTargetCom);
	}

	@Override
	public void deleteTargetComByTargetId(TStanTargetCom tStanTargetCom)
			throws Exception {
		// TODO Auto-generated method stub
		targetComMapper.deleteTargetComByTargetId(tStanTargetCom);
	}

	@Override
	public void updateTargeComtByTargetId(TStanTargetCom tStanTargetCom)
			throws Exception {
		// TODO Auto-generated method stub
		targetComMapper.updateTargeComtByTargetId(tStanTargetCom);
	}
	

}