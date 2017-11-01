package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TStanTargetRule;
import com.baomidou.mybatisplus.service.IService;

	
public interface TargetRuleService  extends IService<TStanTargetRule>{
	 List<TStanTargetRule>	findTarget(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void addTarget(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void  deleteTargetByTargetId(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void updateTargetByTargetId(TStanTargetRule tStanTargetRule) throws Exception;

}
