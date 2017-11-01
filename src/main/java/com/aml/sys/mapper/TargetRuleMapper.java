package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.TStanTargetRule;
import com.aml.sys.entity.TargetEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TargetRuleMapper extends BaseMapper<TStanTargetRule>{
	
	  List<TStanTargetRule>	findTarget(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void addTarget(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void  deleteTargetByTargetId(TStanTargetRule tStanTargetRule) throws Exception;
	  
	  void updateTargetByTargetId(TStanTargetRule tStanTargetRule) throws Exception;
}
