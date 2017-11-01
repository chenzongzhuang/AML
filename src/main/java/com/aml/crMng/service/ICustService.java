package com.aml.crMng.service;

import java.util.List;
import java.util.Map;

import com.aml.crMng.entity.Cust;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ICustService extends IService<Cust>{
	/**
	 * 根据条件查询客户信息
	 * @param map
	 * @return
	 */
	List<Cust> getCustInfo(Page page,Map<String,Object> map);
}
