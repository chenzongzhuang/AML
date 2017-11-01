package com.aml.crMng.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.aml.cRat.service.IExportExcelService;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.TrimUtil;
import com.aml.crMng.entity.BakStanPerson;
import com.aml.crMng.service.IBakStanPersonService;
import com.aml.sys.entity.Dict;
import com.aml.sys.service.IDictService;
import com.baomidou.mybatisplus.plugins.Page;

@Controller
@RequestMapping("/crMng/perCustomer")
public class BakStanPersonCustController extends BaseController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static String PRE_FIX = "crMng/perCustomer/";
	// @Autowired
	// private ICustService custService;
	@Autowired
	private IBakStanPersonService bakStanPersonService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private IExportExcelService iExportExcelService;
	private Map<String, Object> map;
	private InputStream inputStream = null;//文件流
	private Map<String,String> result = new HashMap<String,String>();
	private static Logger logger = Logger.getLogger(BakStanPersonCustController.class);
	/*
	 * 个人客户
	 */
	// @RequestMapping(value="/custAction")
	// public ModelAndView custAction(Model model){
	// int id = (int) session.getAttribute("avtiveId");
	// @SuppressWarnings("unchecked")
	// Map<Integer,List<MenuNode>> menuNodeList = (Map<Integer, List<MenuNode>>)
	// session.getAttribute("menuNodeList");
	// Map<String,Object> map = new HashMap<>();
	// @SuppressWarnings("unchecked")
	// List<Cust> listCust = custService.getCustInfo(map);
	// //model.addAttribute("url", "/crMng/perCustomer/perCustomer.html");
	// //model.addAttribute("listCust",listCust);
	// //model.addAttribute("titles",menuNodeList.get(id));
	// return new
	// ModelAndView("index").addObject("url","/crMng/perCustomer/perCustomer.html").addObject("listCust",listCust).addObject("titles",menuNodeList.get(id));
	// }

	@ResponseBody
	@RequestMapping("/toPerCustomer")
	public AjaxResult toPerCustomer() {
		Page<BakStanPerson> page = getPage();
		String busiRegNo = TrimUtil.trimValue(request.getParameter("busiRegNo"));// 客户号
		String ctnm = TrimUtil.trimValue(request.getParameter("ctnm"));// 客户名称
		String clientTp = TrimUtil.trimValue(request.getParameter("clientTp"));// 客户类别
		String agencyCtid = TrimUtil.trimValue(request.getParameter("agencyCtid"));// 主体证件号码
		String endtime = TrimUtil.trimValue(request.getParameter("endtime"));// 证件到期
		String riskLevel = TrimUtil.trimValue(request.getParameter("riskLevel"));// 风险等级
		String merUnit = TrimUtil.trimValue(request.getParameter("merUnit"));// 分支机构
		Date rgdtStart = null;
		Date rgdtEnd = null;
		try {
			if (!"".equals(request.getParameter("rgdtStart")) && request.getParameter("rgdtStart") != null) {
				rgdtStart = sdf.parse(request.getParameter("rgdtStart") + " 00:00:00");// 开户日期
			}
			if (!"".equals(request.getParameter("rgdtEnd")) && request.getParameter("rgdtEnd") != null) {
				rgdtEnd = sdf.parse(request.getParameter("rgdtEnd") + " 00:00:00");// 开户日期
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> resObj = new HashMap<String, Object>();
		List<BakStanPerson> listCust = bakStanPersonService.findAllBakStanPerson(page, busiRegNo, ctnm, clientTp,
				agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);

		page.setRecords(listCust);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}

	@RequestMapping(value = "/{param}", method = RequestMethod.GET)
	public String toCust(@PathVariable String param) {
		System.out.println(param);
		return PRE_FIX + param;

	}

	@ResponseBody
	@RequestMapping("/loadDict")
	public AjaxResult loadSysRatLev() {
		// 获取form提交的数据
		String id = request.getParameter("id");
		String dmTP = "";
		if ("clientTp".equals(id)) {
			dmTP = "client_tp";
		}
		if ("riskLevel".equals(id)) {
			dmTP = "risk_level";
		}
		if ("endtime".equals(id)) {
			dmTP = "cert_warn_tp";
		}
		if ("merUnit".equals(id)) {
			dmTP = "SYS_UNIT";
		}
		if("tsdr".equals(id)){
			dmTP = "TSDR";
		}
		Page<Dict> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(dictService.findDictByDmTp(dmTP));
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}

	/**
	 * 导出
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/exportExcel")
	public AjaxResult getExcel() {
		// 查询列表数据
		String busiRegNo = TrimUtil.trimValue(request.getParameter("busiRegNo"));// 客户号
		String ctnm = TrimUtil.trimValue(request.getParameter("ctnm"));// 客户名称
		String clientTp = TrimUtil.trimValue(request.getParameter("clientTp"));// 客户类别
		String agencyCtid = TrimUtil.trimValue(request.getParameter("agencyCtid"));// 主体证件号码
		String endtime = TrimUtil.trimValue(request.getParameter("endtime"));// 证件到期
		String riskLevel = TrimUtil.trimValue(request.getParameter("riskLevel"));// 风险等级
		String merUnit = TrimUtil.trimValue(request.getParameter("merUnit"));// 分支机构
		Date rgdtStart = null;
		Date rgdtEnd = null;
		try {
			if (!"".equals(request.getParameter("rgdtStart")) && request.getParameter("rgdtStart") != null) {
				rgdtStart = sdf.parse(request.getParameter("rgdtStart") + " 00:00:00");// 开户日期
			}
			if (!"".equals(request.getParameter("rgdtEnd")) && request.getParameter("rgdtEnd") != null) {
				rgdtEnd = sdf.parse(request.getParameter("rgdtEnd") + " 00:00:00");// 开户日期
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, Object> resObj = new HashMap<String, Object>();
		List<BakStanPerson> listCust = bakStanPersonService.findAllBakStanPerson(busiRegNo, ctnm, clientTp,
				agencyCtid, endtime, riskLevel, merUnit, rgdtStart, rgdtEnd);

		map = iExportExcelService.exportBakStanPersonCustFile(listCust);

		if (map.get("ERROR") != null && !"".equals((String) map.get("ERROR"))) {
			result.put("result", "error");
			result.put("msg", (String) map.get("ERROR"));
		} else {
			result.put("result", "success");
			result.put("fileName", (String) map.get("FILE_NAME"));
		}
		return json(result);
	}
	
	
	@RequestMapping(value = "/downExcel")
	public void getExcelForm() {
		String amlPath = request.getServletContext().getRealPath("");//获取项目动态绝对路径  
		String filePath = amlPath+"download\\perCustomer.xls";
		 response.setContentType("application/octet-stream;charset=UTF-8");  
         //下载  
          response.setHeader("Content-disposition", "attachment;filename=perCustomer.xls"); //文件名，在这下载了是乱码
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
}
