package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.TradingStandard;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TradingStandaraMapper extends BaseMapper<TradingStandard>{
	
	List<TradingStandard>findTarget(TradingStandard tradingStandard) throws Exception;
	
	void addTarget(TradingStandard tradingStandard) throws Exception;
	
	void deleteTargetByTargetId(TradingStandard tradingStandard) throws Exception;
	
	void updateTargetByTargetId(TradingStandard tradingStandard) throws Exception;
	

}
