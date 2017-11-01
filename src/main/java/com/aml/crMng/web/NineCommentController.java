package com.aml.crMng.web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.core.util.TrimUtil;
import com.aml.crMng.entity.BakStanPerson;
import com.aml.crMng.entity.TPctrRbif;
import com.aml.crMng.entity.TPstrRbif;
import com.aml.crMng.entity.TStanAddress;
import com.aml.crMng.entity.TStanBact;
import com.aml.crMng.entity.TStanCert;
import com.aml.crMng.entity.TStanPact;
import com.aml.crMng.entity.TStanPerson;
import com.aml.crMng.entity.TStanStif;
import com.aml.crMng.entity.TStanTel;
import com.aml.crMng.service.ITPctrRbifService;
import com.aml.crMng.service.ITPstrRbifService;
import com.aml.crMng.service.ITStanAddressService;
import com.aml.crMng.service.ITStanBactService;
import com.aml.crMng.service.ITStanCertService;
import com.aml.crMng.service.ITStanPactService;
import com.aml.crMng.service.ITStanPersonService;
import com.aml.crMng.service.ITStanStifService;
import com.aml.crMng.service.ITStanTelService;
import com.aml.sys.common.MenuNode;
import com.aml.sys.entity.User;
import com.aml.sys.service.IMenuService;
import com.baomidou.mybatisplus.plugins.Page;

@Controller
@RequestMapping("/crMngInfo")
public class NineCommentController extends BaseController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private IMenuService menuService;
	@Autowired
	private ITStanCertService iTStanCertService;
	@Autowired
	private ITStanAddressService iTStanAddressService;
	@Autowired
	private ITStanTelService iTStanTelService;
	@Autowired
	private ITStanBactService iTStanBactService;
	@Autowired
	private ITStanPactService iTStanPactService;
	@Autowired
	private ITStanPersonService iTStanPersonService;
	@Autowired
	private ITStanStifService iTStanStifService;
	@Autowired
	private ITPstrRbifService iTPstrRbifService;
	@Autowired
	private ITPctrRbifService iTPctrRbifService;
//	@RequestMapping(value="/first")
//	public ModelAndView toFirst(Model model) {
//		User user = (User) session.getAttribute("user");
//		Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
//		List<Integer> roleList = new ArrayList<>();
//		for (int roleId : roleArray) {
//			roleList.add(roleId);
//		}
//		String busiRegNo = request.getParameter("busiRegNo");
//		List<MenuNode> menus = menuService.getMenusOfCustMenu(roleList);
//		request.setAttribute("titles",menus);
//		request.setAttribute("url","/menuOfIndex.html");
//		
//		return new ModelAndView("crMng/cust");
//
//	}
	
	@RequestMapping(value="/first")
	public String toFirst() {
		session.removeAttribute("busiRegNo");
		session.removeAttribute("ctnm");
		String busiRegNo = request.getParameter("busiRegNo");
		String ctnm = request.getParameter("ctnm");
		session.setAttribute("busiRegNo", busiRegNo);
		session.setAttribute("ctnm", ctnm);
		return REDIRECT+"g";

	}
	
	@RequestMapping(value = "g",method = RequestMethod.GET)
	public String index(){
		User user = (User) session.getAttribute("user");
		Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
		List<Integer> roleList = new ArrayList<>();
		for (int roleId : roleArray) {
			roleList.add(roleId);
		}
		List<MenuNode> menus = menuService.getMenusOfCustMenu(roleList);
		request.setAttribute("titles",menus);
		request.setAttribute("url","/menuOfIndex.html");
		return "index";
	}
	
	/**
	 * 概述
	 * @return
	 */
	@RequestMapping(value="/summary")
	public String toSummary() {
		String busiRegNo = (String) session.getAttribute("busiRegNo");
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/summary";

	}
	
	
	/**
	 * 基本信息
	 * @return
	 */
	@RequestMapping(value="/basicInfo")
	public String toBasicInfo() {
		String busiRegNo = (String) session.getAttribute("busiRegNo");
		String ctnm = (String) session.getAttribute("ctnm");
		List<TStanPerson> tStanPersonList =  iTStanPersonService.findAllTStanPerson(busiRegNo);
		TStanPerson tStanPerson = new TStanPerson();
		if(tStanPersonList != null && tStanPersonList.size()>0){
			tStanPerson = tStanPersonList.get(0);
		}
		request.setAttribute("TStanPerson", tStanPerson);
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/basicInfo";

	}
	
	/**
	 * 证件信息
	 * @return
	 */
	@RequestMapping(value="/certInfo")
	public String toCertInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/certInfo";

	}
	
	/**
	 * 证件信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toCertInfo")
	public AjaxResult certInfo() {
		Page<TStanCert> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TStanCert> listCertInfo = iTStanCertService.findAllTStanCert(page,ctifId);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listCertInfo);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	
	/**
	 * 地址信息
	 * @return
	 */
	@RequestMapping(value="/addressInfo")
	public String toAddressInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/addressInfo";

	}
	
	/**
	 * 地址信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAddressInfo")
	public AjaxResult addressInfo() {
		Page<TStanAddress> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TStanAddress> listAddressInfo = iTStanAddressService.findAllTStanAddress(page, ctifId);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listAddressInfo);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	
	/**
	 * 联系信息
	 * @return
	 */
	@RequestMapping(value="/contactInfo")
	public String toContactInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/contactInfo";

	}
	
	/**
	 * 联系信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toContactInfo")
	public AjaxResult contactInfo() {
		Page<TStanTel> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TStanTel> listContactInfo = iTStanTelService.findAllTStanTel(page, ctifId);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listContactInfo);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	/**
	 * 账户信息
	 * @return
	 */
	@RequestMapping(value="/accountInfo")
	public String toAccountInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/accountInfo";

	}
	
	/**
	 * 个人银行账户查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toBack")
	public AjaxResult accountInfoBack() {
		Page<TStanBact> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TStanBact> listTStanBact = iTStanBactService.findAllTStanBact(page, ctifId);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listTStanBact);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	
	/**
	 * 个人支付账户信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toPack")
	public AjaxResult accountInfoPack() {
		Page<TStanPact> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TStanPact> listTStanPact = iTStanPactService.findAllTStanPact(page, ctifId);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listTStanPact);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	/**
	 * 证件信息
	 * @return
	 */
	@RequestMapping(value="/transactionInfo")
	public String toTransactionInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/transactionInfo";

	}
	
	/**
	 * 证件信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toTransactionInfo")
	public AjaxResult transactionInfo() {
		Page<TStanStif> page = getPage();
		String tsdr = TrimUtil.trimValue(request.getParameter("tsdr"));// 资金收付标志
		BigDecimal cratLeft = Convert.toBigDecimal(request.getParameter("cratLeft"));// 交易金额
		BigDecimal cratRight = Convert.toBigDecimal(request.getParameter("cratRight"));// 交易金额
		String ticd = TrimUtil.trimValue(request.getParameter("ticd"));// 业务标识号
		Date tstmStart = null;//交易时间
		Date tstmEnd = null;//交易时间
		try {
			if (!"".equals(request.getParameter("tstmStart")) && request.getParameter("tstmStart") != null) {
				tstmStart = sdf.parse(request.getParameter("tstmStart") + " 00:00:00");// 开户日期
			}
			if (!"".equals(request.getParameter("tstmEnd")) && request.getParameter("tstmEnd") != null) {
				tstmEnd = sdf.parse(request.getParameter("tstmEnd") + " 00:00:00");// 开户日期
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> resObj = new HashMap<String, Object>();
		List<TStanStif> listTStanStif = iTStanStifService.findAllTStanStif(page, tsdr, cratLeft, cratRight, ticd, tstmStart, tstmEnd);
		page.setRecords(listTStanStif);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	/**
	 * 报告信息
	 * @return
	 */
	@RequestMapping(value="/reportInfo")
	public String toReportInfo() {
		String ctnm = (String) session.getAttribute("ctnm");
		request.setAttribute("ctnm", ctnm);
		return "crMng/common/reportInfo";

	}
	
	/**
	 * 可疑报告信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toTPstrRbif")
	public AjaxResult toTPstrRbif() {
		Page<TPstrRbif> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TPstrRbif> listTPstrRbif = iTPstrRbifService.findAllTPstrRbif(page);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listTPstrRbif);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
	
	/**
	 * 补充报告信息查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toTPctrRbif")
	public AjaxResult toTPctrRbif() {
		Page<TPctrRbif> page = getPage();
		String ctifId = (String) session.getAttribute("busiRegNo");
		List<TPctrRbif> listTPctrRbif = iTPctrRbifService.findAllTPctrRbif(page);
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(listTPctrRbif);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		return json(resObj);
	}
	
	
}
