package com.aml.sys.mapper;

import java.util.List;

import org.springframework.ui.Model;

import com.aml.sys.entity.TStanMaiin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * 维护
 * @author zhongrui
 *
 */

public interface TStanMaiinMapper extends  BaseMapper<TStanMaiin>{
	
	List<TStanMaiin> findTarget(TStanMaiin tStanMaiin);
	
	void addTarget(TStanMaiin tStanMaiin );
	
	List<TStanMaiin> qyeryUserTarget(TStanMaiin tStanMaiin);
	
	void deleteTargetByTargetId(TStanMaiin tStanMaiin);
	
	void updateTargetByTargetId(TStanMaiin tStanMaiin);
	
	
}
