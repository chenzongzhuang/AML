package com.aml.earlyWarning.service;

import java.util.List;

import com.aml.earlyWarning.entity.EarlyWarmingArea;

public interface EarlyWarmingAreaService {
	List<EarlyWarmingArea> find(EarlyWarmingArea earlyWarmingArea);//个人地区查询
	List<EarlyWarmingArea> qyeryCount(EarlyWarmingArea earlyWarmingArea);//个人地区查询

}
