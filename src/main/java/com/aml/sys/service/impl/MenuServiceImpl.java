package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.sys.common.EasyuiTreeNode;
import com.aml.sys.common.MenuNode;
import com.aml.sys.entity.Menu;
import com.aml.sys.mapper.MenuMapper;
import com.aml.sys.service.IMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
	@Autowired
	MenuMapper menuMapper;

	@Override
	public List<MenuNode> getMenusByRoleIds(List<Integer> roleIds) {
		return menuMapper.getMenusByRoleIds(roleIds);
	}


	@Override
	public List<EasyuiTreeNode> menuTreeListByMenuIds(List<Integer> menuIds,String roleId) {
		return menuMapper.menuTreeListByMenuIds(menuIds,roleId);

	}


	@Override
	public List<MenuNode> getMenusOfCustMenu(List<Integer> roleIds) {
		return menuMapper.getMenusOfCustMenu(roleIds);
	}
	
}
