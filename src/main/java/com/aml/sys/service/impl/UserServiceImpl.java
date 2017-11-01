package com.aml.sys.service.impl;

import com.aml.sys.entity.User;
import com.aml.sys.mapper.UserMapper;
import com.aml.sys.service.IUserService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.log4j.Logger;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> findAllUser(Page page,String name,String tel) {
		return userMapper.findAllUser(page,name,tel);
	}
	@Override
	public User getByAccount(String account) {
		return userMapper.getByAccount(account);
	}

	@Override
	public User getUserListById(int id) {
		return userMapper.getUserListById(id);
	}
}
