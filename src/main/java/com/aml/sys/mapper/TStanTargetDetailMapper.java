package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.TStanTargetDetail;
import com.aml.sys.entity.TargetEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TStanTargetDetailMapper extends BaseMapper<TStanTargetDetail>{
	
	List<TStanTargetDetail>findTarget(TStanTargetDetail tStanTargetDetail) throws Exception;
	
	List<TStanTargetDetail> selectTargets(TStanTargetDetail tStanTargetDetail) throws Exception;
	
	 void addTarget(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 int CountTargets(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 
	 
	 void  deleteTargetByTargetId(TStanTargetDetail tStanTargetDetail) throws Exception;
	 
	 void updateTargetByTargetId (TStanTargetDetail tStanTargetDetail)  throws Exception;

}
