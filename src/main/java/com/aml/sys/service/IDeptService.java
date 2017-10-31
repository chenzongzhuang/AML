package com.aml.sys.service;

import java.util.List;
import java.util.Map;

import com.aml.sys.entity.Dept;
import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 */
public interface IDeptService extends IService<Dept> {
 	List<Map<String, Object>> list(String id);
 	
 	
 	/**
	 * 根据上级机构号查询出部门信息
	 * @param id
	 * @return
	 */
    List<Dept> getListById(String id);
    List<Dept> getDeptByNameOrId(Page page,String name,String id);
    
	/**
	 * 根据编号查询出用户信息
	 * @param id
	 * @return
	 */
	Dept getDeptListById(int id);
}
