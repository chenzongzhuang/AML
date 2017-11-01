package com.aml.earlyWarning.mapper;

import java.util.List;

import com.aml.earlyWarning.entity.TStanMateRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

public interface TStanMateRoleMapper extends BaseMapper<TStanMateRole> {
	
	List<TStanMateRole> find(TStanMateRole tStanMateRole)
			throws Exception;

	void add(TStanMateRole tStanMateRole) throws Exception;

	List<TStanMateRole> qyeryCount(TStanMateRole tStanMateRole)
			throws Exception;
	List<TStanMateRole> queryMateRoleByMateNo(TStanMateRole tStanMateRole)
			throws Exception;

	void deleteByrollId(List<String> rollIdDelete) throws Exception;

	void updateByrollId(TStanMateRole tStanMateRole) throws Exception;

}
