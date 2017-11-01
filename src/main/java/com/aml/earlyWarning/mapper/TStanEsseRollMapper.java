package com.aml.earlyWarning.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.TStanEsseRoll;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * 观察名单
 * @author zhongrui
 *
 */
public interface TStanEsseRollMapper extends BaseMapper<TStanEsseRoll>{
	
	List<TStanEsseRoll> find(TStanEsseRoll tStanEsseRoll)
			throws Exception;

	void add(TStanEsseRoll tStanEsseRoll) throws Exception;

	List<TStanEsseRoll> qyeryCount(TStanEsseRoll tStanEsseRoll)
			throws Exception;
	List<TStanEsseRoll> queryMateRoleByRollNo(TStanEsseRoll tStanEsseRoll)
			throws Exception;

	void deleteByrollId(List<String> rollIdDelete) throws Exception;

	void updateByrollId(TStanEsseRoll tStanEsseRoll) throws Exception;

}
