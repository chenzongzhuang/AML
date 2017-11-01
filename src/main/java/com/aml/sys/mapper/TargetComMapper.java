package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.TStanTargetCom;
import com.aml.sys.entity.TStanTargetDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * 复合指标Mapper
 * @author zhongrui
 *
 */
public interface TargetComMapper extends BaseMapper<TStanTargetCom>{
	
	List<TStanTargetCom> findTargetCom(TStanTargetCom tStanTargetCom) throws Exception;
	
	void addTargetCom(TStanTargetCom tStanTargetCom) throws Exception;
	
	void deleteTargetComByTargetId(TStanTargetCom tStanTargetCom) throws Exception;
	
	void updateTargeComtByTargetId(TStanTargetCom tStanTargetCom ) throws Exception;
	
}
