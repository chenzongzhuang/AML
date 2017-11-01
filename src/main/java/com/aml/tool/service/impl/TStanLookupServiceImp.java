package com.aml.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.tool.entity.TStanLookup;
import com.aml.tool.mapper.TStanLookupMapper;
import com.aml.tool.service.TStanLookupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TStanLookupServiceImp extends ServiceImpl<TStanLookupMapper,TStanLookup> implements TStanLookupService{

	@Autowired TStanLookupMapper tStanLookupMapper;
	
	@Override
	public List<TStanLookup> find(TStanLookup tStanLookup) throws Exception {
		// TODO Auto-generated method stub
		return tStanLookupMapper.find(tStanLookup);
	}

	@Override
	public List<TStanLookup> findByType(TStanLookup tStanLookup)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanLookupMapper.findByType(tStanLookup);
	}

	@Override
	public void add(TStanLookup tStanLookup) throws Exception {
		tStanLookupMapper.add(tStanLookup);
		
	}

	@Override
	public List<TStanLookup> qyeryCount(TStanLookup tStanLookup)
			throws Exception {
		// TODO Auto-generated method stub
		return tStanLookupMapper.qyeryCount(tStanLookup);
	}

	@Override
	public void deleteByrollId(List<String> rollIdDelete) throws Exception {
		tStanLookupMapper.deleteByrollId(rollIdDelete);
		
	}

	@Override
	public void updateByrollId(TStanLookup tStanLookup) throws Exception {
		tStanLookupMapper.updateByrollId(tStanLookup);
	}

	 
}
