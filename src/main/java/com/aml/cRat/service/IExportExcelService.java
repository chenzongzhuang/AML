package com.aml.cRat.service;

import java.util.List;
import java.util.Map;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.TCraMdlRank;
import com.aml.crMng.entity.BakStanOrg;
import com.aml.crMng.entity.BakStanPerson;

/**
 * <p>
 * 导出excel服务类
 * </p>
 *
 */
public interface IExportExcelService {
	
	public Map<String, Object> exportPreserveFile(List<CRat> listCRat,String tmpXmlNm) ;
	
	public Map<String, Object> exportBakStanPersonCustFile(List<BakStanPerson> bakStanPersonList);
	public Map<String, Object> exportRGMatFile(List<TCraMdlRank> listCRat) ;
	public Map<String, Object> exportRatMSetFile(List<RatMSet> listCRat) ;
	public Map<String, Object> exportBakStanPersonShopFile(List<BakStanPerson> bakStanPersonList);
	public Map<String, Object> exportBakStanOrgShopFile(List<BakStanOrg> bakStanOrgList);
	public Map<String, Object> exportBakStanOrgCustFile(List<BakStanOrg> bakStanOrgList);
	public Map<String, Object> exporRatMFctFile(List<RatMFct> listRatMFct);
}
