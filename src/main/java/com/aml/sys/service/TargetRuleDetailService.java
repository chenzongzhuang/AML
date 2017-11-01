package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TargetRuleDetail;
import com.baomidou.mybatisplus.service.IService;

public interface TargetRuleDetailService  extends IService<TargetRuleDetail>{
	
	List<TargetRuleDetail> findTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void addTargetRuleDetail(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void deleteTargetByTargetId(TargetRuleDetail targetRuleDetail) throws Exception;
	
	void updateTargetByTargetId(TargetRuleDetail targetRuleDetail) throws Exception;
	

}
