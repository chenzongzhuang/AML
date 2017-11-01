package com.aml.cRat.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.cRat.entity.IQulSet;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.RatRankRule;
import com.aml.cRat.entity.TCraMdlRank;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 风险评级维护表 服务类
 * </p>
 *
 */
public interface IRGMatService extends IService<TCraMdlRank> {
	/**
	 * 风险评级维护查询数据(分页)
	 */
	List<TCraMdlRank> findAllRGMat(Page page,String rkCd);
	/**
	 * 风险评级维护查询数据导出查询数据
	 */
	List<TCraMdlRank> findAllRGMat(String rkCd);
	/**
	 * 风险评级维护查询数据(分页)
	 */
	List<RatMSet> findAllRatMSet(Page page,String mdlCd);
	/**
	 * 风险评级维护查询数据导出查询数据
	 */
	List<RatMSet> findAllRatMSet(String mdlCd);
	/**
	 * 指标定性设置查询数据(分页)
	 */
	List<IQulSet> findAllIQulSet(Page page,String rlCd);
	/**
	 * 指标定性设置查询数据(分页)详情
	 */
	List<RatRankRule> findAllRatRankRule(Page page,String rId);
	/**
	 * 评级模型因子表(分页)详情
	 */
	List<RatMFct> findAllRatMFct(Page page);
	/**
	 * 评级模型因子表(分页)详情
	 */
	List<RatMFct> findAllRatMFct(String id);
	/**
	 * 评级模型因子表导出查询数据
	 */
	List<RatMFct> findAllRatMFct();
	/**保存风险等级数据*/
	int saveTCraMdlRank(String rkCd,String rkNm,BigDecimal minVal,BigDecimal maxVal,String rkds,String ctms,BigDecimal ascc,Timestamp createTime,String creator,Timestamp updateTime,String updator);
	/**修改保存风险等级数据*/
	int updateTCraMdlRank(String rkCd,String rkNm,BigDecimal minVal,BigDecimal maxVal,String rkds,String ctms,BigDecimal ascc,Timestamp updateTime,String updator);
	/**修改保存风险等级数据*/
	int deleteTCraMdlRank(String rkCd);
	/**保存模型设置*/
	int saveRatMSet(String mdlCd,String mdlNm,String mdlVr,String mdlSc,String status,String remark,Timestamp createTime,String creator,Timestamp updateTime,String updator);
	/**修改保存模型设置*/
	int updateRatMSet(String mdlCd,String mdlNm,String mdlVr,String mdlSc,String status,String remark,Timestamp updateTime,String updator);
	/**删除模型设置*/
	int deleteRatMSet(String mdlCd);
	/**保存模型因子*/
	int saveRatMFct(String mdlCd,String mdlVer,BigDecimal lvlNo,String fctLvl,String fctCd,String fctNm,String fctTp,String fctKd,String supLvl,String config,Timestamp createTime,String creator,Timestamp updateTime,String updator);
	/**修改保存模型因子*/
	int updateRatMFct(String mdlCd,String mdlVer,BigDecimal lvlNo,String fctLvl,String fctCd,String fctNm,String fctTp,String fctKd,String supLvl,String config,Timestamp updateTime,String updator,BigDecimal id);
	/**删除模型因子*/
	int deleteRatMFct(BigDecimal id);
	/**保存指标定性设置*/
	int saveIQulSet(String rlNm,String rlTp,String status,String adjRank,String tgtRank,BigDecimal priority,Timestamp createTime,String creator,Timestamp updateTime,String updator);
	/**修改指标定性设置*/
	int updateIQulSet(String rlNm,String rlTp,String status,String adjRank,String tgtRank,BigDecimal priority,Timestamp updateTime,String updator,BigDecimal rlCd);
	/**删除指标定性设置*/
	int deleteIQulSet(BigDecimal rlCd);
	/**保存指标定性设置*/
	int saveRatRankRule(String rId,String modleInd,String indMatch,Timestamp createTime,String creator,Timestamp updateTime,String updator);
}
