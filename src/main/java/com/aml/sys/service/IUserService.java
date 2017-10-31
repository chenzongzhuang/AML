package com.aml.sys.service;

import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 */
public interface IUserService extends IService<User> {
	List<User> findAllUser(Page page,String name,String tel);
	
	 /**
     * 通过账密码获取用户
     *
     * @param account
     */
    User getByAccount(String account);

	/**
	 * 根据编号查询出用户信息
	 * @param id
	 * @return
	 */
	User getUserListById(int id);
}
