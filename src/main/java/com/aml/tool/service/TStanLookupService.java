package com.aml.tool.service;

import java.util.List;

import com.aml.tool.entity.TStanLookup;
import com.baomidou.mybatisplus.service.IService;

public interface TStanLookupService extends IService<TStanLookup>{
	List<TStanLookup> find(TStanLookup tStanLookup) throws Exception;
	
	List<TStanLookup> findByType (TStanLookup tStanLookup) throws Exception;
	
	void add (TStanLookup tStanLookup) throws Exception;
	
	List<TStanLookup> qyeryCount (TStanLookup tStanLookup) throws Exception; 
	
	void deleteByrollId (List<String> rollIdDelete) throws Exception;
	
	void updateByrollId (TStanLookup tStanLookup) throws Exception;

}	
