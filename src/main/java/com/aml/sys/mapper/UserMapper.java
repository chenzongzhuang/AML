package com.aml.sys.mapper;

import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface UserMapper extends BaseMapper<User> {
	List<User> findAllUser(Page page,@Param("name") String name,@Param("tel") String tel);
	
	 /**
     * 通过账密码获取用户
     *
     * @param account
     */
    User getByAccount(@Param("account") String account);

	/**
	 * 根据编号查询出用户信息
	 * @param id
	 * @return
	 */
	User getUserListById(@Param("id") int id);
}