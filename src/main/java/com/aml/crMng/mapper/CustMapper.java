package com.aml.crMng.mapper;

import java.util.List;
import java.util.Map;

import com.aml.crMng.entity.Cust;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface CustMapper extends BaseMapper<Cust>{
	/**
	 * 根据条件查询客户信息
	 * @param map
	 * @return
	 */
	List<Cust> getCustInfo(Page page,Map<String,Object> map);
}
