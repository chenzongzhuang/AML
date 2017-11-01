package com.aml.earlyWarning.service;

import java.util.List;

import com.aml.earlyWarning.entity.TStanAreaRoll;
import com.baomidou.mybatisplus.service.IService;

public interface TStanAreaRollService extends IService<TStanAreaRoll>{
	
	List<TStanAreaRoll>find(TStanAreaRoll tStanAreaRoll ) throws Exception;
	
	void add(TStanAreaRoll tStanAreaRoll) throws Exception;
	
	List<TStanAreaRoll>qyeryCount(TStanAreaRoll tStanAreaRoll) throws Exception;
	
	void deleteByrollId(List<String> rollIdDelete) throws Exception;
	
	void updateByrollId(TStanAreaRoll tStanAreaRoll ) throws Exception;

}
