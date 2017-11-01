package com.aml.shadinessSub.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.shadinessSub.entity.ShadinessSub;
/**
 * 待确认可疑mapper
 * @author zhongrui
 *
 */


public interface ShadinessSubMapper{
	List<ShadinessSub> find(ShadinessSub shadinessSub);//待确认交易查询主体分页
	
	List<ShadinessSub> qyeryCount(ShadinessSub shadinessSub);//待确认可疑交易主体查询总数
	
	void updateById(ShadinessSub shadinessSub);//更新状态
	
	List<ShadinessSub> findTrd(ShadinessSub shadinessSub);//待确认可疑查询交易总数
	
	List<ShadinessSub> qyeryCountTrd(ShadinessSub shadinessSub);//待确认可疑交易查询总数
	
	void updateTrdById(ShadinessSub shadinessSub);//更新状态

}
