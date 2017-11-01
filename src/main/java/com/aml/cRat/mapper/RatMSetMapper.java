package com.aml.cRat.mapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface RatMSetMapper extends BaseMapper<RatMSet> {
	/**
	 * 分页查询风险等级维护
	 */
	List<RatMSet> findAllRatMSet(Page page,@Param("mdlCd") String mdlCd);
	/**
	 * 分页查询评级模型因子
	 */
	List<RatMFct> findAllRatMFct(Page page);
	/**
	 * 查询评级模型因子
	 */
	List<RatMFct> findAllRatMFct(@Param("id") String id);
	/**
	 * 分页查询风险等级维护导出数据
	 */
	List<RatMSet> findAllRatMSet(@Param("mdlCd") String mdlCd);
	/**
	 * 分页查询评级模型因子导出数据
	 */
	List<RatMFct> findAllRatMFct();
	int saveRatMSet(@Param("mdlCd") String mdlCd,@Param("mdlNm") String mdlNm,@Param("mdlVr") String mdlVr,
			@Param("mdlSc") String mdlSc,@Param("status") String status,@Param("remark") String remark,
			@Param("createTime") Timestamp createTime,@Param("creator") String creator,@Param("updateTime") Timestamp updateTime,
			@Param("updator") String updator);
	int updateRatMSet(@Param("mdlCd") String mdlCd,@Param("mdlNm") String mdlNm,@Param("mdlVr") String mdlVr,
			@Param("mdlSc") String mdlSc,@Param("status") String status,@Param("remark") String remark,
			@Param("updateTime") Timestamp updateTime,@Param("updator") String updator);
	int deleteRatMSet(@Param("mdlCd") String mdlCd);
	int saveRatMFct(@Param("mdlCd") String mdlCd,@Param("mdlVer") String mdlVer,@Param("lvlNo") BigDecimal lvlNo,
			@Param("fctLvl") String fctLvl,@Param("fctCd") String fctCd,@Param("fctNm") String fctNm,
			@Param("fctTp") String fctTp,@Param("fctKd") String fctKd,@Param("supLvl") String supLvl,@Param("config") String config,
			@Param("createTime") Timestamp createTime,@Param("creator") String creator,@Param("updateTime") Timestamp updateTime,
			@Param("updator") String updator);
	int updateRatMFct(@Param("mdlCd") String mdlCd,@Param("mdlVer") String mdlVer,@Param("lvlNo") BigDecimal lvlNo,
			@Param("fctLvl") String fctLvl,@Param("fctCd") String fctCd,@Param("fctNm") String fctNm,
			@Param("fctTp") String fctTp,@Param("fctKd") String fctKd,@Param("supLvl") String supLvl,@Param("config") String config,
			@Param("updateTime") Timestamp updateTime,@Param("updator") String updator,@Param("id") BigDecimal id);
	int deleteRatMFct(@Param("id") BigDecimal id);
}