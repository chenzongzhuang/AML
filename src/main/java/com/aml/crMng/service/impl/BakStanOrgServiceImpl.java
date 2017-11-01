package com.aml.crMng.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.BakStanOrg;
import com.aml.crMng.mapper.BakStanOrgMapper;
import com.aml.crMng.service.IBakStanOrgService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class BakStanOrgServiceImpl extends ServiceImpl<BakStanOrgMapper, BakStanOrg> implements IBakStanOrgService {
	@Autowired
	BakStanOrgMapper bakStanOrgMapper;

	@Override
	public List<BakStanOrg> findAllBakStanOrg(Page page, String busiRegNo, String ctnm, String clientTp,
			String agencyCtid, String endtime, String riskLevel, String merUnit, Date rgdtStart, Date rgdtEnd) {
		return bakStanOrgMapper.findAllBakStanOrg(page, busiRegNo, ctnm, clientTp, agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);
	}

	@Override
	public List<BakStanOrg> findAllBakStanOrg(String busiRegNo, String ctnm, String clientTp, String agencyCtid,
			String endtime, String riskLevel, String merUnit, Date rgdtStart, Date rgdtEnd) {
		return bakStanOrgMapper.findAllBakStanOrg(busiRegNo, ctnm, clientTp, agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);
		
	}

	
	
	

}
