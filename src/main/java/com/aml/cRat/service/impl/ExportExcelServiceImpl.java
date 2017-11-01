package com.aml.cRat.service.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.TCraMdlRank;
import com.aml.cRat.mapper.CRatMapper;
import com.aml.cRat.service.IExportExcelService;
import com.aml.common.export.ExportTool;
import com.aml.crMng.entity.BakStanOrg;
import com.aml.crMng.entity.BakStanPerson;

/**
 * <p>
 * 导出excel服务实现类
 * </p>
 */
@Service
@Transactional
public class ExportExcelServiceImpl implements IExportExcelService {
	private static Logger logger = Logger.getLogger(ExportExcelServiceImpl.class);
	@Autowired
	CRatMapper cRatMapper;
	@Autowired
	HttpServletRequest request; 
	public Map<String, Object> exportPreserveFile(List<CRat> listCRat,String tmpXmlNm) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "test.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+tmpXmlNm;
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, listCRat, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}
	
	
	@Override
	public Map<String, Object> exportBakStanPersonCustFile(List<BakStanPerson> bakStanPersonList) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "perCustomer.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"bakStanPersonCust.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, bakStanPersonList, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}	
	public Map<String, Object> exportRGMatFile(List<TCraMdlRank> listRGMat) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "test.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"rGMat.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, listRGMat, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}
	public Map<String, Object> exportRatMSetFile(List<RatMSet> listRatMSet) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "test.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"ratMSet.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, listRatMSet, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}


	@Override
	public Map<String, Object> exportBakStanPersonShopFile(List<BakStanPerson> bakStanPersonList) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "perMerchant.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"bakStanPersonShop.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, bakStanPersonList, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}


	@Override
	public Map<String, Object> exportBakStanOrgShopFile(List<BakStanOrg> bakStanOrgList) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "orgMerchant.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"bakStanOrgShop.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, bakStanOrgList, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}


	@Override
	public Map<String, Object> exportBakStanOrgCustFile(List<BakStanOrg> bakStanOrgList) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "orgCustomer.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"bakStanOrgCust.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, bakStanOrgList, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}
	public Map<String, Object> exporRatMFctFile(List<RatMFct> listRatMFct) {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		System.out.println(amlPath);
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//		List<User> userList = new ArrayList<User>();
//		User user = new User();
//		user.setId(1);
//		userList.add(user);
		// 生成文件名
		String fileName = "test.xls";
		map.put("FILE_NAME", fileName);
		// 生成文件路径
		String filePath = amlPath+"download\\";
		File path = new File(filePath);
		if (!path.exists() || !path.isDirectory()) {
			path.mkdirs();
		}

		map.put("FILE_PATH", filePath + fileName);
		//模板路径加xml模板名称
		String tmpPath = amlPath+"xmlTemplate\\";
		File tmpPath1 = new File(tmpPath);
		if (!tmpPath1.exists() || !tmpPath1.isDirectory()) {
			tmpPath1.mkdirs();
		}
		String xmlName = tmpPath+"ratMFct.xml";
		System.out.println(xmlName);
		ExportTool exportTool = new ExportTool(filePath + fileName, fileName,
				xmlName, listRatMFct, null, 20, 0);
		try {
			exportTool.exportExcel();
		} catch (Exception e) {
			logger.error("生成excel文件异常："+e.getMessage());
			map.put("ERROR", e.getMessage());
			return map;
		}
		return map;
	}
}
