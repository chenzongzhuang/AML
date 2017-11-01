package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TStanTargetRule;
import com.aml.sys.mapper.TargetRuleMapper;
import com.aml.sys.service.TargetRuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TargetRuleServiceImpl extends ServiceImpl<TargetRuleMapper,TStanTargetRule> implements TargetRuleService{

	@Autowired
	TargetRuleMapper targetRuleMapper;
	
	@Override
	public List<TStanTargetRule> findTarget(TStanTargetRule tStanTargetRule)
			throws Exception {
		// TODO Auto-generated method stub
		return targetRuleMapper.findTarget(tStanTargetRule);
	}

	@Override
	public void addTarget(TStanTargetRule tStanTargetRule) throws Exception {
		targetRuleMapper.addTarget(tStanTargetRule);
	}

	@Override
	public void deleteTargetByTargetId(TStanTargetRule tStanTargetRule)
			throws Exception {
		targetRuleMapper.deleteTargetByTargetId(tStanTargetRule);
		
	}

	@Override
	public void updateTargetByTargetId(TStanTargetRule tStanTargetRule)
			throws Exception {
		targetRuleMapper.updateTargetByTargetId(tStanTargetRule);
	}

}
