package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TradingStandard;
import com.baomidou.mybatisplus.service.IService;

public interface TradingStandaraMapperService extends IService<TradingStandard>{
	
	List<TradingStandard>findTarget(TradingStandard tradingStandard) throws Exception;
	
	void addTarget(TradingStandard tradingStandard) throws Exception;
	
	void deleteTargetByTargetId(TradingStandard tradingStandard) throws Exception;
	
	void updateTargetByTargetId(TradingStandard tradingStandard) throws Exception;
	

}
