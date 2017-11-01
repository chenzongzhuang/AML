package com.aml.sys.service;

import java.util.List;

import com.aml.sys.common.EasyuiTreeNode;
import com.aml.sys.common.MenuNode;
import com.aml.sys.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 */
public interface IMenuService extends IService<Menu> {
	/**
	 * 根据角色获取菜单
	 *
	 * @param roleIds
	 * @return
	 */
	List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);

	/**
	 * 获取菜单列表树
	 *
	 * @return
	 */
	List<EasyuiTreeNode> menuTreeListByMenuIds(List<Integer> menuIds,String roleId);
	
	
	/**
	  * 根据角色和父id获取菜单
	  * @param roleIds
	  * @param pcode
	  * @return
	  */
	 List<MenuNode> getMenusOfCustMenu(List<Integer> roleIds);
	
	

}

