package com.aml.cRat.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.cRat.entity.IQulSet;
import com.aml.cRat.entity.RatRankRule;
import com.aml.cRat.entity.TCraMdlRank;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface RGMatMapper extends BaseMapper<TCraMdlRank> {
	/**
	 * 分页查询风险等级维护
	 */
	List<TCraMdlRank> findAllRGMat(Page page,@Param("rkCd") String rkCd);
	/**
	 * 分页查询风险等级维护导出数据
	 */
	List<TCraMdlRank> findAllRGMat(@Param("rkCd") String rkCd);
	/**
	 * 分页查询指标定性设置
	 */
	List<IQulSet> findAllIQulSet(Page page,@Param("rlCd") String rlCd);
	/**
	 * 分页查询指标定性设置
	 *
	 */
	List<RatRankRule> findAllRatRankRule(Page page,@Param("rId") String rId);
	
	int saveTCraMdlRank(@Param("rkCd") String rkCd,@Param("rkNm") String rkNm,@Param("minVal") BigDecimal minVal,
			@Param("maxVal") BigDecimal maxVal,@Param("rkds") String rkds,@Param("ctms") String ctms,@Param("ascc") BigDecimal ascc,
			@Param("createTime") Timestamp createTime,@Param("creator") String creator,@Param("updateTime") Timestamp updateTime,
			@Param("updator") String updator);
	int updateTCraMdlRank(@Param("rkCd") String rkCd,@Param("rkNm") String rkNm,@Param("minVal") BigDecimal minVal,
			@Param("maxVal") BigDecimal maxVal,@Param("rkds") String rkds,@Param("ctms") String ctms,@Param("ascc") BigDecimal ascc,
			@Param("updateTime") Timestamp updateTime,@Param("updator") String updator);
	int deleteTCraMdlRank(@Param("rkCd") String rkCd);
	int saveIQulSet(@Param("rlNm") String rlNm,@Param("rlTp") String rlTp,
			@Param("status") String status,@Param("adjRank") String adjRank,@Param("tgtRank") String tgtRank,@Param("priority") BigDecimal priority,
			@Param("createTime") Timestamp createTime,@Param("creator") String creator,@Param("updateTime") Timestamp updateTime,
			@Param("updator") String updator);
	int updateIQulSet(@Param("rlNm") String rlNm,@Param("rlTp") String rlTp,
			@Param("status") String status,@Param("adjRank") String adjRank,@Param("tgtRank") String tgtRank,@Param("priority") BigDecimal priority,
			@Param("updateTime") Timestamp updateTime,@Param("updator") String updator,@Param("rlCd") BigDecimal rlCd);
	int deleteIQulSet(@Param("rlCd") BigDecimal rlCd);
	int saveRatRankRule(@Param("rId") String rId,@Param("modleInd") String modleInd,@Param("indMatch") String indMatch,
			@Param("createTime") Timestamp createTime,@Param("creator") String creator,@Param("updateTime") Timestamp updateTime,
			@Param("updator") String updator);
}