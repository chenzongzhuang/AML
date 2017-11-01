package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TStanTargetDetail;
import com.baomidou.mybatisplus.service.IService;

public interface TStanTargetDetailService extends IService<TStanTargetDetail>{

List<TStanTargetDetail>findTarget(TStanTargetDetail tStanTargetDetail) throws Exception;
	
	 List<TStanTargetDetail> selectTargets(TStanTargetDetail tStanTargetDetail) throws Exception;
	
	 void addTarget(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 int CountTargets(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 
	 void  deleteTargetByTargetId(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 void updateTargetByTargetId (TStanTargetDetail tStanTargetDetail)  throws Exception;
}
