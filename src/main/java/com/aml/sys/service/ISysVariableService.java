package com.aml.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.SysVariable;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface ISysVariableService extends IService<SysVariable>{
	List<SysVariable> getSysVariableByNameOrDes(Page page,@Param("id") String id,@Param("typCode") String typCode,@Param("typName") String typName);
}
