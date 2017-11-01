package com.aml.crMng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.Cust;
import com.aml.crMng.mapper.CustMapper;
import com.aml.crMng.service.ICustService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service
public class CustServiceImpl extends ServiceImpl<CustMapper, Cust> implements ICustService{
	@Autowired
	CustMapper custMapper;
	
	@Override
	public List<Cust> getCustInfo(Page page , Map<String, Object> map) {
		return custMapper.getCustInfo(page,map);
	}
	
}
