package com.aml.sys.service.impl;

import com.aml.sys.entity.Role;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.mapper.RoleMapper;
import com.aml.sys.service.IRoleService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService {
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<Role> getRoleListByUserRid(String id) {
		return roleMapper.getRoleListByUserRid(id);
	}

	@Override
	public List<RoleNode> roleTreeListByRoleId(String[] roleId) {
		return roleMapper.roleTreeListByRoleId(roleId);
	}

	@Override
	public List<Role> selectAllRole(Page page) {
		return roleMapper.selectAllRole(page);
	}
	

	@Override
	public Role getRoleById(int id) {
	
		return roleMapper.getRoleById(id);
	}
}
