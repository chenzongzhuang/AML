package com.aml.earlyWarning.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.TStanAreaRollType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TStanAreaRollTypeMapper extends BaseMapper<TStanAreaRollType>{
	
	List<TStanAreaRollType>find(TStanAreaRollType tStanAreaRollType ) throws Exception;
	
	void add(TStanAreaRollType tStanAreaRollType) throws Exception;
	
	List<TStanAreaRollType>qyeryCount(TStanAreaRollType tStanAreaRollType) throws Exception;
	
	void deleteByrollId(List<String> rollIdDelete) throws Exception;
	
	void updateByrollId(TStanAreaRollType tStanAreaRollType) throws Exception;

}
