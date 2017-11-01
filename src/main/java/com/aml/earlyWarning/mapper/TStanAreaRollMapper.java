package com.aml.earlyWarning.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.TStanAreaRoll;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TStanAreaRollMapper extends BaseMapper<TStanAreaRoll>{
	List<TStanAreaRoll>find(TStanAreaRoll tStanAreaRoll ) throws Exception;
	
	void add(TStanAreaRoll tStanAreaRoll) throws Exception;
	
	List<TStanAreaRoll>qyeryCount(TStanAreaRoll tStanAreaRoll) throws Exception;
	
	void deleteByrollId(List<String> rollIdDelete) throws Exception;
	
	void updateByrollId(TStanAreaRoll tStanAreaRoll ) throws Exception;
}
