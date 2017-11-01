package com.aml.etl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.etl.entity.EtlLogMain;
import com.aml.etl.mapper.EtlLogMainMapper;
import com.aml.etl.service.IEtlLogMainService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
@Transactional
public class EtlLogMainServiceImpl extends ServiceImpl<EtlLogMainMapper, EtlLogMain> implements IEtlLogMainService {
	
	@Autowired
	EtlLogMainMapper etlMapper;
	
	@Override
	public List<EtlLogMain> getEtlLogByColDtOrResult(Page page, String colDt, String result) {
		// TODO Auto-generated method stub
		return etlMapper.getEtlLogByColDtOrResult(page,colDt,result);
	}

}
