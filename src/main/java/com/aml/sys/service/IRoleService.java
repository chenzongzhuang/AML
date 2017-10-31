package com.aml.sys.service;

import com.aml.sys.entity.Role;
import com.aml.sys.entity.RoleNode;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 */
public interface IRoleService extends IService<Role> {
    /**
     *根据查询用户拥有的所有权限
     */
    List<Role> getRoleListByUserRid(@Param("rid") String id);
    /**
     * 获取角色列表树
     *
     * @return
     */
    List<RoleNode> roleTreeListByRoleId(String[] roleId);
    /**
     * 查询全部角色
     * @return
     */
    List<Role> selectAllRole(Page page);
    /**
	 * 根据编号查询出角色信息
	 * @param id
	 * @return
	 */
    Role getRoleById(int id);
}
