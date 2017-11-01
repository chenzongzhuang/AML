package com.aml.crMng.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.BakStanPerson;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface IBakStanPersonService extends IService<BakStanPerson> {
	/**
	 * 分页查询
	 * @param page
	 * @param busiRegNo
	 * @param ctnm
	 * @param clientTp
	 * @param agencyCtid
	 * @param endtime
	 * @param riskLevel
	 * @param merUnit
	 * @param rgdtStart
	 * @param rgdtEnd
	 * @return
	 */
	List<BakStanPerson> findAllBakStanPerson(Page page,@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);

	/**
	 * 查询
	 * @param busiRegNo
	 * @param ctnm
	 * @param clientTp
	 * @param agencyCtid
	 * @param endtime
	 * @param riskLevel
	 * @param merUnit
	 * @param rgdtStart
	 * @param rgdtEnd
	 * @return
	 */
	List<BakStanPerson> findAllBakStanPerson(@Param("busiRegNo") String busiRegNo,@Param("ctnm") String ctnm,@Param("clientTp") String clientTp,@Param("agencyCtid") String agencyCtid,@Param("endtime") String endtime,@Param("riskLevel") String riskLevel,@Param("merUnit") String merUnit,@Param("rgdtStart") Date rgdtStart,@Param("rgdtEnd") Date rgdtEnd);




}
