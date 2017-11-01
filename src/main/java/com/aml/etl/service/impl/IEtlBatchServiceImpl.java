package com.aml.etl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.etl.entity.EtlBatch;
import com.aml.etl.entity.EtlMain;
import com.aml.etl.mapper.EtlBatchMapper;
import com.aml.etl.mapper.EtlMainMapper;
import com.aml.etl.service.IEtlBatchService;

@Service
@Transactional
public class IEtlBatchServiceImpl implements IEtlBatchService{

	@Autowired
	EtlBatchMapper batchMapper;
	
	@Autowired
	EtlMainMapper mainMapper;
	
	@Override
	public boolean addTaskBatch(EtlMain main, EtlBatch batch) {

		Integer batchFlag = batchMapper.insert(batch);
		if( batchFlag>0){
			Integer mainFlag = mainMapper.insert(main);
			if(mainFlag>0) return true;
		}
		return false;
	}

}
