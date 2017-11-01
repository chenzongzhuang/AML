package com.aml.cRat.service;

import java.sql.Timestamp;
import java.util.List;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.DataDctnry;
import com.aml.cRat.entity.SysUnit;
import com.aml.sys.entity.Dict;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 */
public interface ICRatService extends IService<CRat> {
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据(分页)
	 */
	List<CRat> findAllCRat(Page page,String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit);
	/**
	 * 通过元素组号查询数据
	 */
	List<DataDctnry> findAllDataDctnry(Page page,String grpCd);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据
	 */
	List<CRat> findAllCRat(String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据(分页)
	 */
	List<CRat> findAllOrgCRat(Page page,String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit);
	/**
	 * 通过客户号、客户名称、评级状态、系统评级等级、确认评级等级、系统评级时间开始、系统评级时间结束、分支机构查询数据
	 */
	List<CRat> findAllOrgCRat(String stus,String clientTp, String rkTp,String cstId,String ctnm,String status,String fstAutRank,String fstManRank,Timestamp fstAutTimeStart,Timestamp fstAutTimeEnd,String merUnit);
	/**
	 * 查询分支机构
	 */
	List<SysUnit> findAllSysUnit();
	/**
	 * 查询评级状态、系统评级等级、确认评级等级、
	 */
	List<Dict> findDictByDmTp(String dmTp);
}
