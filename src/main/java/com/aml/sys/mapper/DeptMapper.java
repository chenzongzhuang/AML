package com.aml.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.Dept;
import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * 部门dao
 *
 */
public interface DeptMapper extends BaseMapper<Dept> {


    List<Map<String, Object>> list(@Param("condition") String condition);
    List<Dept> getListById(@Param("id") String id);
    List<Dept> getDeptByNameOrId(Page page,@Param("name") String name,@Param("id") String id);

	/**
	 * 根据编号查询出用户信息
	 * @param id
	 * @return
	 */
	Dept getDeptListById(@Param("id") int id);
	Dept getDeptById(@Param("id") String id);
	
}
