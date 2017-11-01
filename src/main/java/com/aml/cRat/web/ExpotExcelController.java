package com.aml.cRat.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.TCraMdlRank;
import com.aml.cRat.service.ICRatService;
import com.aml.cRat.service.IExportExcelService;
import com.aml.cRat.service.IRGMatService;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;

/**
 * <p>
 * 导出excel 前端控制器
 * </p>
 *
 */
@Controller
public class ExpotExcelController extends BaseController {
	private static Logger logger = Logger.getLogger(ExpotExcelController.class);
	@Autowired
	private IExportExcelService iExportExcelService;
	@Autowired
	private ICRatService iCRatService;
	@Autowired
	private IRGMatService iRGMatService;
	private Map<String,String> result = new HashMap<String,String>();
	private Map<String, Object> map;
	private InputStream inputStream = null;//文件流
	@ResponseBody
	@RequestMapping("/produceExcel")
	public AjaxResult getExcel() {
		//查询列表数据
		Timestamp fstAutTimeStart = null;
		Timestamp fstAutTimeEnd = null;
		List<CRat> listCRat = null;
		String title="";
		String tmpXmlNm="";
		String flag = request.getParameter("flag");
		if(!"".equals(request.getParameter("fstAutTimeStart"))&&request.getParameter("fstAutTimeStart")!=null){
//			sysRatTimeStart = sdf.parse("2017-10-11 08:08:08");
			fstAutTimeStart = Timestamp.valueOf(request.getParameter("fstAutTimeStart")+" 00:00:00");
		}
		if(!"".equals(request.getParameter("fstAutTimeEnd"))&&request.getParameter("fstAutTimeEnd")!=null){
	//			sysRatTimeEnd = sdf.parse(request.getParameter("sysRatTimeEnd"));
			fstAutTimeEnd = Timestamp.valueOf(request.getParameter("fstAutTimeEnd")+" 00:00:00");
		}
		//代表个人客户或个人商户
		if("prsn".equals(flag)){
			//clientTp-1代表客户,2代表商户 
			//rkTp-1:新用户评级。2: 存量用户初评 3:重新评定，4：定期复核，5：评级变动 6：人工评级
			if("1".equals(request.getParameter("clientTp"))){
				title = "个人客户评级-";
			}
			if("2".equals(request.getParameter("clientTp"))){
				title = "个人商户评级-";
			}
			if("1".equals(request.getParameter("rkTp"))){
				title = title+"新客户评级";
			}
			if("3".equals(request.getParameter("rkTp"))){
				title = title+"触发重新评级";
			}
			if("4".equals(request.getParameter("rkTp"))){
				title = title+"定期复核评级";
			}
			listCRat = iCRatService.findAllCRat(request.getParameter("stus"),request.getParameter("clientTp"), request.getParameter("rkTp"),request.getParameter("cstId"), request.getParameter("ctnm"),request.getParameter("status"), request.getParameter("fstAutRank"),request.getParameter("fstManRank"), fstAutTimeStart,fstAutTimeEnd, request.getParameter("merUnit"));
		}
		//机构客户或机构商户
		if("org".equals(flag)){
			//clientTp-1代表客户,2代表商户
			//rkTp-1:新用户评级。2: 存量用户初评 3:重新评定，4：定期复核，5：评级变动 6：人工评级
			if("1".equals(request.getParameter("clientTp"))){
				title = "机构客户评级-";
			}
			if("2".equals(request.getParameter("clientTp"))){
				title = "机构商户评级-";
			}
			if("1".equals(request.getParameter("rkTp"))){
				title = title+"新客户评级";
			}
			if("3".equals(request.getParameter("rkTp"))){
				title = title+"触发重新评级";
			}
			if("4".equals(request.getParameter("rkTp"))){
				title = title+"定期复核评级";
			}
			listCRat = iCRatService.findAllOrgCRat(request.getParameter("stus"),request.getParameter("clientTp"), request.getParameter("rkTp"),request.getParameter("cstId"), request.getParameter("ctnm"),request.getParameter("status"), request.getParameter("fstAutRank"),request.getParameter("fstManRank"), fstAutTimeStart,fstAutTimeEnd, request.getParameter("merUnit"));
		}
//		for (int i = 0; i < listCRat.size(); i++) {
//			listCRat.get(i).setTitle(title);
//		}
		if("个人客户评级-新客户评级".equals(title)){
			tmpXmlNm = "crNewCRat.xml";
		}
		if("个人客户评级-触发重新评级".equals(title)){
			tmpXmlNm = "crTrigRat.xml";
		}
		if("个人客户评级-定期复核评级".equals(title)){
			tmpXmlNm = "crRegRRat.xml";
		}
		if("机构客户评级-新客户评级".equals(title)){
			tmpXmlNm = "ocNewCRat.xml";
		}
		if("机构客户评级-触发重新评级".equals(title)){
			tmpXmlNm = "ocTrigRat.xml";
		}
		if("机构客户评级-定期复核评级".equals(title)){
			tmpXmlNm = "ocRegRRat.xml";
		}
		if("个人商户评级-新客户评级".equals(title)){
			tmpXmlNm = "imNewCRat.xml";
		}
		if("个人商户评级-触发重新评级".equals(title)){
			tmpXmlNm = "imTrigRat.xml";
		}
		if("个人商户评级-定期复核评级".equals(title)){
			tmpXmlNm = "imRegRRat.xml";
		}
		if("机构商户评级-新客户评级".equals(title)){
			tmpXmlNm = "omNewCRat.xml";
		}
		if("机构商户评级-触发重新评级".equals(title)){
			tmpXmlNm = "omTrigRat.xml";
		}
		if("机构商户评级-定期复核评级".equals(title)){
			tmpXmlNm = "omRegRRat.xml";
		}
		map = iExportExcelService.exportPreserveFile(listCRat,tmpXmlNm);	
		
		if (map.get("ERROR") != null && !"".equals((String)map.get("ERROR"))) {
			result.put("result", "error");
			result.put("msg", (String)map.get("ERROR"));
		}else {
			result.put("result", "success");
			result.put("fileName", (String)map.get("FILE_NAME"));
		}
		return json(result);
	}
	@ResponseBody
	@RequestMapping(value="/{param}", method = RequestMethod.GET)
	public AjaxResult getRGMatExcel(@PathVariable String param) {
		//查询列表数据
		System.out.println(param);
		List<TCraMdlRank> listRGMat = null;
		List<RatMSet> listRatMSet = null;
		List<RatMFct> listRatMFct = null;
		if("rGMatExcel".equals(param)){
			listRGMat = iRGMatService.findAllRGMat(request.getParameter("rkCd"));
			map = iExportExcelService.exportRGMatFile(listRGMat);	
		}
		if("ratMSetExcel".equals(param)){
			listRatMSet = iRGMatService.findAllRatMSet(request.getParameter("mdlCd"));
			map = iExportExcelService.exportRatMSetFile(listRatMSet);
		}
		if("ratMFctExcel".equals(param)){
			listRatMFct = iRGMatService.findAllRatMFct();
			map = iExportExcelService.exporRatMFctFile(listRatMFct);
		}
		if (map.get("ERROR") != null && !"".equals((String)map.get("ERROR"))) {
			result.put("result", "error");
			result.put("msg", (String)map.get("ERROR"));
		}else {
			result.put("result", "success");
			result.put("fileName", (String)map.get("FILE_NAME"));
		}
		return json(result);
	}
	@RequestMapping(value = "/downExcel")
	public void getExcelForm() {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		String filePath = amlPath+"download\\test.xls";
		 response.setContentType("application/octet-stream;charset=UTF-8");  
         //下载  
          response.setHeader("Content-disposition", "attachment;filename=test.xls"); //文件名，在这下载了是乱码
          BufferedInputStream bis = null;
          ServletOutputStream sos = null;
          BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));  
            sos=response.getOutputStream();  
            bos = new BufferedOutputStream(sos);   
            byte[] buffer = new byte[1024];   
            int len = -1;   
            while ((len = bis.read(buffer)) != -1) {   
                bos.write(buffer, 0, len);   
            }     
//			inputStream = new BufferedInputStream(new FileInputStream(filePath));
		} catch (Exception e) {
			logger.error("创建流失败："+e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				bos.close();
				sos.close();   
				bis.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("流关闭失败："+e.getMessage());
				e.printStackTrace();
			}   
		}
	}
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
