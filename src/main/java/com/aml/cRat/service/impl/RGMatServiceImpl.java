package com.aml.cRat.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.cRat.entity.IQulSet;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.RatRankRule;
import com.aml.cRat.entity.TCraMdlRank;
import com.aml.cRat.mapper.RGMatMapper;
import com.aml.cRat.mapper.RatMSetMapper;
import com.aml.cRat.service.IRGMatService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 风险评级维护 服务实现类
 * </p>
 */
@Service
@Transactional
public class RGMatServiceImpl extends ServiceImpl<RGMatMapper, TCraMdlRank> implements IRGMatService {
	@Autowired
	RGMatMapper rGMatMapper;
	@Autowired
	RatMSetMapper ratMSetMapper;
	@Override
	public List<TCraMdlRank> findAllRGMat(Page page,String rkCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.findAllRGMat(page,rkCd);
	}
	@Override
	public List<RatMSet> findAllRatMSet(Page page,String mdlCd) {
		// TODO Auto-generated method stub
		return ratMSetMapper.findAllRatMSet(page,mdlCd);
	}
	@Override
	public List<IQulSet> findAllIQulSet(Page page, String rlCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.findAllIQulSet(page,rlCd);
	}
	@Override
	public List<RatRankRule> findAllRatRankRule(Page page, String rId) {
		// TODO Auto-generated method stub
		return rGMatMapper.findAllRatRankRule(page,rId);
	}
	@Override
	public List<RatMFct> findAllRatMFct(Page page) {
		// TODO Auto-generated method stub
		return ratMSetMapper.findAllRatMFct(page);
	}
	@Override
	public List<RatMFct> findAllRatMFct( String id) {
		// TODO Auto-generated method stub
		return ratMSetMapper.findAllRatMFct(id);
	}
	@Override
	public List<TCraMdlRank> findAllRGMat(String rkCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.findAllRGMat(rkCd);
	}
	@Override
	public List<RatMSet> findAllRatMSet(String mdlCd) {
		// TODO Auto-generated method stub
		return ratMSetMapper.findAllRatMSet(mdlCd);
	}
	@Override
	public List<RatMFct> findAllRatMFct() {
		// TODO Auto-generated method stub
		return ratMSetMapper.findAllRatMFct();
	}
	@Override
	public int saveTCraMdlRank(String rkCd, String rkNm, BigDecimal minVal, BigDecimal maxVal, String rkds,
			String ctms, BigDecimal ascc, Timestamp createTime, String creator, Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return rGMatMapper.saveTCraMdlRank(rkCd, rkNm, minVal, maxVal, rkds,
				ctms, ascc, createTime, creator, updateTime, updator);
	}
	@Override
	public int updateTCraMdlRank(String rkCd, String rkNm, BigDecimal minVal, BigDecimal maxVal, String rkds,
			String ctms, BigDecimal ascc, Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return rGMatMapper.updateTCraMdlRank(rkCd, rkNm, minVal, maxVal, rkds,
				ctms, ascc, updateTime, updator);
	}
	@Override
	public int deleteTCraMdlRank(String rkCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.deleteTCraMdlRank(rkCd);
	}
	@Override
	public int saveRatMSet(String mdlCd, String mdlNm, String mdlVr, String mdlSc,String status, String remark, Timestamp createTime,
			String creator, Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return ratMSetMapper.saveRatMSet(mdlCd, mdlNm, mdlVr, mdlSc, status,remark,
				createTime, creator, updateTime, updator);
	}
	@Override
	public int updateRatMSet(String mdlCd, String mdlNm, String mdlVr, String mdlSc, String status,String remark,
			Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return ratMSetMapper.updateRatMSet(mdlCd, mdlNm, mdlVr, mdlSc, status,remark,
				updateTime, updator);
	}
	@Override
	public int deleteRatMSet(String mdlCd) {
		// TODO Auto-generated method stub
		return ratMSetMapper.deleteRatMSet(mdlCd);
	}
	@Override
	public int saveRatMFct(String mdlCd, String mdlVer, BigDecimal lvlNo, String fctLvl, String fctCd, String fctNm,
			String fctTp, String fctKd, String supLvl, String config, Timestamp createTime, String creator,
			Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return ratMSetMapper.saveRatMFct(mdlCd, mdlVer, lvlNo, fctLvl, fctCd, fctNm,
				fctTp, fctKd, supLvl, config, createTime, creator,
				updateTime, updator);
	}
	@Override
	public int updateRatMFct(String mdlCd, String mdlVer, BigDecimal lvlNo, String fctLvl, String fctCd, String fctNm,
			String fctTp, String fctKd, String supLvl, String config, Timestamp updateTime, String updator,BigDecimal id) {
		// TODO Auto-generated method stub
		return ratMSetMapper.updateRatMFct(mdlCd, mdlVer, lvlNo, fctLvl, fctCd, fctNm,
				fctTp, fctKd, supLvl, config, updateTime, updator,id);
	}
	@Override
	public int deleteRatMFct(BigDecimal id) {
		// TODO Auto-generated method stub
		return ratMSetMapper.deleteRatMFct(id);
	}
	@Override
	public int saveIQulSet(String rlNm, String rlTp, String status, String adjRank, String tgtRank, BigDecimal priority,
			Timestamp createTime, String creator, Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return rGMatMapper.saveIQulSet(rlNm, rlTp, status, adjRank, tgtRank,
				priority, createTime, creator,updateTime, updator);
	}
	@Override
	public int updateIQulSet(String rlNm, String rlTp, String status, String adjRank, String tgtRank,
			BigDecimal priority, Timestamp updateTime, String updator, BigDecimal rlCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.updateIQulSet(rlNm, rlTp, status, adjRank, tgtRank,
				priority, updateTime, updator,rlCd);
	}
	@Override
	public int deleteIQulSet(BigDecimal rlCd) {
		// TODO Auto-generated method stub
		return rGMatMapper.deleteIQulSet(rlCd);
	}
	@Override
	public int saveRatRankRule(String rId, String modleInd, String indMatch, Timestamp createTime, String creator,
			Timestamp updateTime, String updator) {
		// TODO Auto-generated method stub
		return rGMatMapper.saveRatRankRule(rId, modleInd, indMatch, createTime, creator,updateTime, updator);
	}
}
