package com.aml.earlyWarning.service;

import java.util.List;

import com.aml.earlyWarning.entity.TStanAreaRollType;
import com.baomidou.mybatisplus.service.IService;

public interface TStanAreaRollTypeService   extends IService<TStanAreaRollType>{
	
    List<TStanAreaRollType> find(TStanAreaRollType tStanAreaRollType ) throws Exception;
	
	void add(TStanAreaRollType tStanAreaRollType) throws Exception;
	
	List<TStanAreaRollType> qyeryCount(TStanAreaRollType tStanAreaRollType) throws Exception;
	
	void deleteByrollId(List<String> rollIdDelete) throws Exception;
	
	void updateByrollId(TStanAreaRollType tStanAreaRollType) throws Exception;

}
