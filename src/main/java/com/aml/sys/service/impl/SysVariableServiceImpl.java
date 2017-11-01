package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.sys.entity.SysVariable;
import com.aml.sys.mapper.SysVariableMapper;
import com.aml.sys.service.ISysVariableService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
@Transactional
public class SysVariableServiceImpl extends ServiceImpl<SysVariableMapper,SysVariable> implements ISysVariableService {

	@Autowired
	SysVariableMapper sysVarMapper;
	@Override
	public List<SysVariable> getSysVariableByNameOrDes(Page page, String id,
			String typCode, String typName) {
		// TODO Auto-generated method stub
		return sysVarMapper.getSysVariableByNameOrDes(page, id, typCode, typName);
	}

}
