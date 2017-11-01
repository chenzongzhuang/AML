package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.TStanTargetCom;
import com.aml.sys.entity.TStanTargetDetail;
import com.baomidou.mybatisplus.service.IService;

public interface TargetComService extends IService<TStanTargetCom>{

	List<TStanTargetCom> findTargetCom(TStanTargetCom tStanTargetCom) throws Exception;
	
	void addTargetCom(TStanTargetCom tStanTargetCom) throws Exception;
	
	void deleteTargetComByTargetId(TStanTargetCom tStanTargetCom) throws Exception;
	
	void updateTargeComtByTargetId(TStanTargetCom tStanTargetCom ) throws Exception;
	
	
}
