package com.aml.crMng.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.BakStanOrg;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface IBakStanOrgService extends IService<BakStanOrg> {
	/**
	 * 分页查询
	 */
	List<BakStanOrg> findAllBakStanOrg(Page page,@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);
	
	/**
	 * 分页查询
	 */
	List<BakStanOrg> findAllBakStanOrg(@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);
	
}
