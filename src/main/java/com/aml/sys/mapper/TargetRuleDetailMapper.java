package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.TargetRuleDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TargetRuleDetailMapper extends BaseMapper<TargetRuleDetail>{
	
	List<TargetRuleDetail> findTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void addTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void deleteTargetByTargetId(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void updateTargetByTargetId(TargetRuleDetail targetRuleDetail) throws Exception;
	

}
