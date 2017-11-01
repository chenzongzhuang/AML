package com.aml.earlyWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.earlyWarning.entity.TStanEsseRoll;
import com.aml.earlyWarning.mapper.TStanEsseRollMapper;
import com.aml.earlyWarning.service.TStanEsseRollService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanEsseRollServiceImpl extends ServiceImpl<TStanEsseRollMapper, TStanEsseRoll> implements TStanEsseRollService{

	@Autowired TStanEsseRollMapper tStanEsseRollMapper;
	
	@Override
	public List<TStanEsseRoll> find(TStanEsseRoll tStanEsseRoll)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanEsseRollMapper.find(tStanEsseRoll);
	}

	@Override
	public void add(TStanEsseRoll tStanEsseRoll) throws Exception {
		tStanEsseRollMapper.add(tStanEsseRoll);
		
	}

	@Override
	public List<TStanEsseRoll> qyeryCount(TStanEsseRoll tStanEsseRoll)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanEsseRollMapper.queryMateRoleByRollNo(tStanEsseRoll);
	}

	@Override
	public List<TStanEsseRoll> queryMateRoleByRollNo(TStanEsseRoll tStanEsseRoll)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanEsseRollMapper.queryMateRoleByRollNo(tStanEsseRoll);
	}

	@Override
	public void deleteByrollId(List<String> rollIdDelete) throws Exception {
		// TODO Auto-generated method stub
		tStanEsseRollMapper.deleteByrollId(rollIdDelete);
	}

	@Override
	public void updateByrollId(TStanEsseRoll tStanEsseRoll) throws Exception {
		// TODO Auto-generated method stub
		tStanEsseRollMapper.updateByrollId(tStanEsseRoll);
	}

}
