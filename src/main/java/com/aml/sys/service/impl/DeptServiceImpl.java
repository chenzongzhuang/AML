package com.aml.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.sys.entity.Dept;
import com.aml.sys.mapper.DeptMapper;
import com.aml.sys.service.IDeptService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 */
@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<Map<String, Object>> list(String id) {
		return deptMapper.list(id);
	}

	@Override
	public List<Dept> getListById(String id) {
		// TODO Auto-generated method stub
		return deptMapper.getListById(id);
	}

	@Override
	public List<Dept> getDeptByNameOrId(Page page,String name,String id) {
		// TODO Auto-generated method stub
		return deptMapper.getDeptByNameOrId(page,name,id);
	}

	@Override
	public Dept getDeptListById(int id) {

		Dept dept=deptMapper.getDeptById(id+"");
		return dept;
	}

	
	
}
