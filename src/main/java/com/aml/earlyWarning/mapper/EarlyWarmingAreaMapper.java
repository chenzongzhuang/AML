package com.aml.earlyWarning.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.EarlyWarmingArea;

public interface EarlyWarmingAreaMapper {
	
	List<EarlyWarmingArea> find(EarlyWarmingArea earlyWarmingArea);//个人地区查询
	
	List<EarlyWarmingArea> qyeryCount(EarlyWarmingArea earlyWarmingArea);//个人地区查询
	
}
