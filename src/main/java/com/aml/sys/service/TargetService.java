package com.aml.sys.service;

import java.util.List;

import com.aml.sys.entity.Menu;
import com.aml.sys.entity.TargetEntity;
import com.baomidou.mybatisplus.service.IService;

public interface TargetService extends IService<TargetEntity>{

	List<TargetEntity> SelectTargets(TargetEntity targetEntity) throws Exception;
	
	void AddTarget(TargetEntity targetEntity) throws Exception;
	
	int CountTargets(TargetEntity targetEntity) throws Exception;
	
	List<TargetEntity>  findTarget(TargetEntity targetEntity) throws Exception;
	
	
	void deleteTargetByTargetId(TargetEntity targetEntity) throws Exception;
	
	void updateTargetByTargetId (TargetEntity targetEntity)  throws Exception;
	
}
