package com.aml.sys.mapper;

import java.util.List;

import com.aml.sys.entity.Menu;
import com.aml.sys.entity.TargetEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

	
public interface TargetMapper extends BaseMapper<TargetEntity>{
	
	 List<TargetEntity> selectTargets(TargetEntity targetEntity) throws Exception;
	
	 void addTarget(TargetEntity targetEntity) throws Exception;
	 
	 int CountTargets(TargetEntity targetEntity) throws Exception;
	 
	 List<TargetEntity>  findTarget(TargetEntity targetEntity) throws Exception; 
	 
	 
	 void  deleteTargetByTargetId(TargetEntity targetEntity) throws Exception;
	 
	 void updateTargetByTargetId (TargetEntity targetEntity)  throws Exception;
}
