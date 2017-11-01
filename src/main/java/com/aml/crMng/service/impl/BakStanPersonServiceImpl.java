package com.aml.crMng.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aml.crMng.entity.BakStanPerson;
import com.aml.crMng.mapper.BakStanPersonMapper;
import com.aml.crMng.service.IBakStanPersonService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class BakStanPersonServiceImpl extends ServiceImpl<BakStanPersonMapper, BakStanPerson> implements IBakStanPersonService{
	@Autowired
	BakStanPersonMapper bakStanPersonMapper;

	@Override
	public List<BakStanPerson> findAllBakStanPerson(Page page, String busiRegNo, String ctnm, String clientTp,
			String agencyCtid, String endtime, String riskLevel, String merUnit, Date rgdtStart, Date rgdtEnd) {
		return bakStanPersonMapper.findAllBakStanPerson(page, busiRegNo, ctnm, clientTp, agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);
	}

	@Override
	public List<BakStanPerson> findAllBakStanPerson(String busiRegNo, String ctnm, String clientTp, String agencyCtid,
			String endtime, String riskLevel, String merUnit, Date rgdtStart, Date rgdtEnd) {
		return bakStanPersonMapper.findAllBakStanPerson(busiRegNo, ctnm, clientTp, agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);
	}
	
	

}
