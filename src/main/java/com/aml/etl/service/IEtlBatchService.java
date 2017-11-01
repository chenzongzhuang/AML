package com.aml.etl.service;

import com.aml.etl.entity.EtlBatch;
import com.aml.etl.entity.EtlMain;

public interface IEtlBatchService  {
	 boolean addTaskBatch(EtlMain main,EtlBatch batch);
}
