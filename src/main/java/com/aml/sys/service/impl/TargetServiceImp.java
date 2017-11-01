package com.aml.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.sys.entity.TargetEntity;
import com.aml.sys.entity.User;
import com.aml.sys.mapper.TargetMapper;
import com.aml.sys.service.TargetService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class TargetServiceImp extends ServiceImpl<TargetMapper, TargetEntity> implements TargetService{

	@Autowired
	private TargetMapper targetMapper;
	
	@Override
	public List<TargetEntity> SelectTargets(TargetEntity targetEntity)
			throws Exception {
		// TODO Auto-generated method stub
		return targetMapper.selectTargets(targetEntity);
	}

	@Override
	public void AddTarget(TargetEntity targetEntity) throws Exception {
		
		 targetMapper.addTarget(targetEntity);
	}

	
	
	@Override
	public int CountTargets(TargetEntity targetEntity) throws Exception {
		// TODO Auto-generated method stub
		return targetMapper.CountTargets(targetEntity);
	}
	
	@Override
	public List<TargetEntity> findTarget(TargetEntity targetEntity) throws Exception {
		// TODO Auto-generated method stub
		return targetMapper.findTarget(targetEntity);
	}


	
	public void deleteTargetByTargetId(TargetEntity targetEntity) throws Exception {
		
		targetMapper.deleteTargetByTargetId(targetEntity);
		
	}

	@Override
	public void updateTargetByTargetId(TargetEntity targetEntity)
			throws Exception {
		
		targetMapper.updateTargetByTargetId(targetEntity);
	}

	

}
