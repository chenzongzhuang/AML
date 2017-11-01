package com.aml.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.common.EasyuiTreeNode;
import com.aml.sys.common.MenuNode;
import com.aml.sys.common.ZTreeNode;
import com.aml.sys.entity.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 */
public interface MenuMapper extends BaseMapper<Menu> {

	
	 List<Menu> getUserOfMenu(List<Integer> roleIds);
    /**
     * 根据条件查询菜单
     *
     * @return
     */
    List<Integer> getMenuIdsByRoleId(@Param("roleId") Integer roleId);

    /**
     * 获取菜单列表树
     *
     * @return
     */
    List<ZTreeNode> menuTreeList();

    /**
     * 获取菜单列表树
     *
     * @return
     */
    List<EasyuiTreeNode> menuTreeListByMenuIds(@Param("list") List<Integer> menuIds,@Param("roleId") String roleId);

    /**
     * 获取资源url通过角色id
     *
     * @param roleId
     */
    List<String> getResUrlsByRoleId(Integer roleId);

    /**
     * 根据角色获取菜单
     *
     * @param roleIds
     * @return
     */
    List<MenuNode> getMenusByRoleIds(List<Integer> roleIds);
    
    
    
    /**
	  * 根据角色和父id获取菜单
	  * @param roleIds
	  * @param pcode
	  * @return
	  */
	 List<MenuNode> getMenusOfCustMenu(List<Integer> roleIds);
}