package com.aml.cRat.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.cRat.entity.CRat;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 */
public interface CRatMapper extends BaseMapper<CRat> {
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据(分页)
	 */
	List<CRat> findAllCRat(Page page,@Param("stus") String stus,@Param("clientTp") String clientTp,@Param("rkTp") String rkTp,@Param("cstId") String cstId,@Param("ctnm") String ctnm,@Param("status") String status,@Param("fstAutRank") String fstAutRank,@Param("fstManRank") String fstManRank,@Param("fstAutTimeStart") Timestamp fstAutTimeStart,@Param("fstAutTimeEnd") Timestamp fstAutTimeEnd,@Param("merUnit") String merUnit);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据
	 */
	List<CRat> findAllCRat(@Param("stus") String stus,@Param("clientTp") String clientTp,@Param("rkTp") String rkTp,@Param("cstId") String cstId,@Param("ctnm") String ctnm,@Param("status") String status,@Param("fstAutRank") String fstAutRank,@Param("fstManRank") String fstManRank,@Param("fstAutTimeStart") Timestamp fstAutTimeStart,@Param("fstAutTimeEnd") Timestamp fstAutTimeEnd,@Param("merUnit") String merUnit);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据(分页)
	 */
	List<CRat> findAllOrgCRat(Page page,@Param("stus") String stus,@Param("clientTp") String clientTp,@Param("rkTp") String rkTp,@Param("cstId") String cstId,@Param("ctnm") String ctnm,@Param("status") String status,@Param("fstAutRank") String fstAutRank,@Param("fstManRank") String fstManRank,@Param("fstAutTimeStart") Timestamp fstAutTimeStart,@Param("fstAutTimeEnd") Timestamp fstAutTimeEnd,@Param("merUnit") String merUnit);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据
	 */
	List<CRat> findAllOrgCRat(@Param("stus") String stus,@Param("clientTp") String clientTp,@Param("rkTp") String rkTp,@Param("cstId") String cstId,@Param("ctnm") String ctnm,@Param("status") String status,@Param("fstAutRank") String fstAutRank,@Param("fstManRank") String fstManRank,@Param("fstAutTimeStart") Timestamp fstAutTimeStart,@Param("fstAutTimeEnd") Timestamp fstAutTimeEnd,@Param("merUnit") String merUnit);

}