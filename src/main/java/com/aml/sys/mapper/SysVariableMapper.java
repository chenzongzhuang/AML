package com.aml.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.SysVariable;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface SysVariableMapper extends BaseMapper<SysVariable>{
	List<SysVariable> getSysVariableByNameOrDes(Page page,@Param("typKind") String typKind,@Param("typCode") String typCode,@Param("typName") String typName);
}
