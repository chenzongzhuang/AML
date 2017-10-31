package com.aml.sys.mapper;

import com.aml.sys.entity.Dept;
import com.aml.sys.entity.Role;
import com.aml.sys.entity.RoleNode;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 角色表 Mapper 接口
 * </p>
 *
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 获取角色列表树
     *
     * @return
     */
    List<RoleNode> roleTreeListByRoleId(String[] roleId);
    
    
    /**
     *根据查询用户拥有的所有权限
     */
    List<Role> getRoleListByUserRid(@Param("rid") String id);

    /**
     * 查询全部角色
     * @return
     */
    List<Role> selectAllRole(Page page);
    Role getRoleById(@Param("id") int id);
    
}