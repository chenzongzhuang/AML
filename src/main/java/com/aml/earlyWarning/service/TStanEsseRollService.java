package com.aml.earlyWarning.service;

import java.util.List;

import com.aml.earlyWarning.entity.TStanEsseRoll;
import com.baomidou.mybatisplus.service.IService;

public interface TStanEsseRollService extends IService<TStanEsseRoll>{
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
