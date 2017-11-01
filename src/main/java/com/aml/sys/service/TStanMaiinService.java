package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TStanMaiin;
import com.baomidou.mybatisplus.service.IService;

public interface TStanMaiinService extends IService<TStanMaiin> {
	
	List<TStanMaiin> findTarget(TStanMaiin tStanMaiin);
	
	void addTarget(TStanMaiin tStanMaiin );
	
	List<TStanMaiin> qyeryUserTarget(TStanMaiin tStanMaiin);
	
	void deleteTargetByTargetId(TStanMaiin tStanMaiin);
	
	void updateTargetByTargetId(TStanMaiin tStanMaiin);

}
