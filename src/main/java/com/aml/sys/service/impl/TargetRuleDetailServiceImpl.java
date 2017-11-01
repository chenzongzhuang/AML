package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







import com.aml.sys.entity.TargetRuleDetail;
import com.aml.sys.mapper.TargetRuleDetailMapper;
import com.aml.sys.service.TargetRuleDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TargetRuleDetailServiceImpl extends ServiceImpl<TargetRuleDetailMapper, TargetRuleDetail> implements TargetRuleDetailService{

	@Autowired TargetRuleDetailMapper targetRuleDetailMapper;
	
	@Override
	public List<TargetRuleDetail> findTargetRuleDetail(
			TargetRuleDetail targetRuleDetail) throws Exception {
		// TODO Auto-generated method stub
		return targetRuleDetailMapper.findTargetRuleDetail(targetRuleDetail);
	}

	@Override
	public void addTargetRuleDetail(TargetRuleDetail targetRuleDetail)
			throws Exception {
		targetRuleDetailMapper.addTargetRuleDetail(targetRuleDetail);
		
	}

	@Override
	public void deleteTargetByTargetId(TargetRuleDetail targetRuleDetail)
			throws Exception {
		targetRuleDetailMapper.deleteTargetByTargetId(targetRuleDetail);
		
	}

	@Override
	public void updateTargetByTargetId(TargetRuleDetail targetRuleDetail)
			throws Exception {
		targetRuleDetailMapper.updateTargetByTargetId(targetRuleDetail);
		
	}

}
