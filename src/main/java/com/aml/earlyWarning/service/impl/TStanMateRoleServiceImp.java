package com.aml.earlyWarning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.earlyWarning.entity.TStanMateRole;
import com.aml.earlyWarning.mapper.TStanMateRoleMapper;
import com.aml.earlyWarning.service.TStanMateRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanMateRoleServiceImp extends ServiceImpl<TStanMateRoleMapper, TStanMateRole> implements TStanMateRoleService{
	@Autowired
	TStanMateRoleMapper tStanMateRoleMapper; 
	@Override
	public List<TStanMateRole> find(TStanMateRole tStanMateRole)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanMateRoleMapper.find(tStanMateRole);
	}

	@Override
	public void add(TStanMateRole tStanMateRole) throws Exception {
		tStanMateRoleMapper.add(tStanMateRole);
		
	}

	@Override
	public List<TStanMateRole> qyeryCount(TStanMateRole tStanMateRole)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanMateRoleMapper.qyeryCount(tStanMateRole);
	}
	
	@Override
	public List<TStanMateRole> queryMateRoleByMateNo(TStanMateRole tStanMateRole)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanMateRoleMapper.queryMateRoleByMateNo(tStanMateRole);
	}

	@Override
	public void deleteByrollId(List<String> rollIdDelete) throws Exception {
		tStanMateRoleMapper.deleteByrollId(rollIdDelete);
		
	}

	@Override
	public void updateByrollId(TStanMateRole tStanMateRole) throws Exception {
		tStanMateRoleMapper.updateByrollId(tStanMateRole);
		
	}

}
