package com.aml.cRat.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.DataDctnry;
import com.aml.cRat.entity.SysUnit;
import com.aml.cRat.mapper.CRatMapper;
import com.aml.cRat.mapper.DataDctnryMapper;
import com.aml.cRat.mapper.SysUnitMapper;
import com.aml.cRat.service.ICRatService;
import com.aml.sys.entity.Dict;
import com.aml.sys.mapper.DictMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 */
@Service
@Transactional
public class CRatServiceImpl extends ServiceImpl<CRatMapper, CRat> implements ICRatService {
	@Autowired
	CRatMapper cRatMapper;
	@Autowired
	DataDctnryMapper dataDctnryMapper;
	@Autowired
	SysUnitMapper sysUnitMapper;
	@Autowired
	DictMapper dictMapper;
	@Override
	public List<CRat> findAllCRat(Page page,String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit) {
		// TODO Auto-generated method stub
		return cRatMapper.findAllCRat(page,stus,clientTp, rkTp,cstId,ctnm,status,fstAutRank,fstManRank,fstAutTimeStart,fstAutTimeEnd,merUnit);
	}
	@Override
	public List<DataDctnry> findAllDataDctnry(Page page, String grpCd) {
		// TODO Auto-generated method stub
		return dataDctnryMapper.findAllDataDctnry(page,grpCd);
	}
	@Override
	public List<CRat> findAllCRat(String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit) {
		// TODO Auto-generated method stub
		return cRatMapper.findAllCRat(stus,clientTp, rkTp,cstId,ctnm,status,fstAutRank,fstManRank,fstAutTimeStart,fstAutTimeEnd,merUnit);
	}
	public List<CRat> findAllOrgCRat(Page page,String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit) {
		// TODO Auto-generated method stub
		return cRatMapper.findAllOrgCRat(page,stus,clientTp, rkTp,cstId,ctnm,status,fstAutRank,fstManRank,fstAutTimeStart,fstAutTimeEnd,merUnit);
	}
	@Override
	public List<CRat> findAllOrgCRat(String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit) {
		// TODO Auto-generated method stub
		return cRatMapper.findAllOrgCRat(stus,clientTp, rkTp,cstId,ctnm,status,fstAutRank,fstManRank,fstAutTimeStart,fstAutTimeEnd,merUnit);
	}
	@Override
	public List<SysUnit> findAllSysUnit() {
		// TODO Auto-generated method stub
		return sysUnitMapper.findAllSysUnit();
	}
	@Override
	public List<Dict> findDictByDmTp(String dmTp) {
		// TODO Auto-generated method stub
		return dictMapper.findDictByDmTp(dmTp);
	}
}
