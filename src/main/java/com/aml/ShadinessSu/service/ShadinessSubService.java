package com.aml.ShadinessSu.service;

import java.util.List;

import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.shadinessSub.entity.ShadinessSub;



public interface ShadinessSubService {
	List<ShadinessSub> find(ShadinessSub shadinessSub);//待确认可疑查询分页
	
	List<ShadinessSub> qyeryCount(ShadinessSub shadinessSub);//待确认可疑查询总数
	
	void updateById(ShadinessSub shadinessSub);//更新状态
	
    List<ShadinessSub> findTrd(ShadinessSub shadinessSub);//待确认可疑查询交易总数
	
	List<ShadinessSub> qyeryCountTrd(ShadinessSub shadinessSub);//待确认可疑交易查询总数

	void updateTrdById(ShadinessSub shadinessSub);//更新状态
}
