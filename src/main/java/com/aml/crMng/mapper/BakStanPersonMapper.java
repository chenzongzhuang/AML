package com.aml.crMng.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.BakStanOrg;
import com.aml.crMng.entity.BakStanPerson;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface BakStanPersonMapper extends BaseMapper<BakStanPerson> {
	/**
	 * 分页查询
	 */
	List<BakStanPerson> findAllBakStanPerson(Page page,@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);
	
	
	
	/**
	 * 分页查询
	 */
	List<BakStanPerson> findAllBakStanPerson(@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);
	
}
