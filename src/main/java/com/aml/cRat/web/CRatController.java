package com.aml.cRat.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.annotion.BussinessLog;
import com.aml.cRat.entity.CRat;
import com.aml.cRat.entity.IQulSet;
import com.aml.cRat.entity.RatMFct;
import com.aml.cRat.entity.RatMSet;
import com.aml.cRat.entity.RatRankRule;
import com.aml.cRat.entity.TCraMdlRank;
import com.aml.cRat.service.ICRatService;
import com.aml.cRat.service.IRGMatService;
import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.core.util.Convert;
import com.aml.sys.entity.RoleNode;
import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 */
@Controller
public class CRatController extends BaseController {
	private final static String PRE_FIX = "cRat/";
	private static Logger LOGGER = Logger.getLogger(CRatController.class);
	@Autowired
	private ICRatService iCRatService;
	@Autowired
	private IRGMatService iRGMatService;
	/**查询个人客户评级初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getCRatList")
	public AjaxResult getCRatList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<CRat> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		Timestamp fstAutTimeStart = null;
		Timestamp fstAutTimeEnd = null;
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
			page.setRecords(iCRatService.findAllCRat(page,request.getParameter("stus"),request.getParameter("clientTp"), request.getParameter("rkTp"),request.getParameter("cstId"), request.getParameter("ctnm"),request.getParameter("status"), request.getParameter("fstAutRank"),request.getParameter("fstManRank"), fstAutTimeStart,fstAutTimeEnd, request.getParameter("merUnit")));
		}
		//机构客户或机构商户
		if("org".equals(flag)){
			page.setRecords(iCRatService.findAllOrgCRat(page,request.getParameter("stus"),request.getParameter("clientTp"), request.getParameter("rkTp"),request.getParameter("cstId"), request.getParameter("ctnm"),request.getParameter("status"), request.getParameter("fstAutRank"),request.getParameter("fstManRank"), fstAutTimeStart,fstAutTimeEnd, request.getParameter("merUnit")));
		}
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	
	@ResponseBody
	@RequestMapping("/loadSysUnit")
	public AjaxResult loadSysUnit() {
		//获取form提交的数据
		String id= request.getParameter("id");
		String grpCd="";
		Page page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		if("merUnit".equals(id)){
			grpCd = "sysUnit";
			page.setRecords(iCRatService.findAllSysUnit());
			resObj.put("total", page.getTotal());
			resObj.put("rows", page.getRecords());
		}
		// 判断用户是否存在
		return json(resObj);
	}
	@ResponseBody
	@RequestMapping("/loadCRatList")
	public AjaxResult loadSysRatLev() {
		//获取form提交的数据
		String id= request.getParameter("id");
		String dmTp="";
		Page page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		if("status".equals(id)){
			dmTp = "STATUS";
		}
		if("fstAutRank".equals(id)){
			dmTp = "FST_AUT_RANK";
		}
		if("fstManRank".equals(id)){
			dmTp = "FST_MAN_RANK";
		}
		page.setRecords(iCRatService.findDictByDmTp(dmTp));
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	@RequestMapping(value = "/cRat/{param}", method = RequestMethod.GET)
    public String toUser(@PathVariable String param) {
		System.out.println(param);
        return PRE_FIX + param;
        
    }
	/**查询风险评级维护初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getRGMatList")
	public AjaxResult getRGMatList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<TCraMdlRank> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(iRGMatService.findAllRGMat(page,request.getParameter("rkCd")));
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	/**
	 * 新增风险等级维护
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/addRGMat")
    public AjaxResult addRGMat() {
		Page<TCraMdlRank> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		//1、根据主键查询是否存在相同的数据
		String rkCd = request.getParameter("rkCd");
		//查询数据
		List<TCraMdlRank> rgmList = iRGMatService.findAllRGMat(page,request.getParameter("rkCd"));
		//2、存在返回提示信息
		if(rgmList.size()>0){
		   resObj.put("pkConf", true);
	       return json(resObj);
		}
		//3、不存在则保存新数据
		User user = (User) request.getSession().getAttribute("user");
        iRGMatService.saveTCraMdlRank(rkCd,request.getParameter("rkNm"),new BigDecimal(request.getParameter("minVal")),new BigDecimal(request.getParameter("maxVal")),request.getParameter("rkds"),request.getParameter("ctms"),new BigDecimal(request.getParameter("ascc")),new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**修改风险等级维护*/
	@RequestMapping(value = "/sys/cRat/showRGMat",method = RequestMethod.GET)
	public String showRGMat(@PathParam("rkCd") String rkCd) {
		//查询数据
		List<TCraMdlRank> rgmList = iRGMatService.findAllRGMat(request.getParameter("rkCd"));
		TCraMdlRank tCraMdlRank = new TCraMdlRank();
		tCraMdlRank = rgmList.get(0);
		request.setAttribute("tCraMdlRank", tCraMdlRank);
		return "/cRat/editRGMat";
	}
	/**
	 * 风险等级维护
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/editRGMat")
    public AjaxResult editRGMat() {
		Page<TCraMdlRank> page = getPage();
		TCraMdlRank tCraMdlRank = new TCraMdlRank();
		Map<String, Object> resObj = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("user");
		//1、根据主键查询是否存在相同的数据
		String rkCd = request.getParameter("rkCd");
		//查询数据
		List<TCraMdlRank> rgmList = iRGMatService.findAllRGMat(page,request.getParameter("rkCd"));
		//2、存在更新数据
		if(rgmList.size()>0){
//			tCraMdlRank=rgmList.get(0);
//			tCraMdlRank.setRkCd(rkCd);
//			tCraMdlRank.setRkNm(request.getParameter("rknm"));
//			tCraMdlRank.setMinVal(new BigDecimal(request.getParameter("minVal")));
//			tCraMdlRank.setMaxVal(new BigDecimal(request.getParameter("maxVal")));
//			tCraMdlRank.setAscc(new BigDecimal(request.getParameter("ascc")));
//			tCraMdlRank.setCtms(request.getParameter("ctms"));
//			tCraMdlRank.setRkds(request.getParameter("rkds"));
//			tCraMdlRank.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//			tCraMdlRank.setUpdator(user.getName());
//			boolean rsulFlag = iRGMatService.updateBatchById(rgmList);
			iRGMatService.updateTCraMdlRank(rkCd,request.getParameter("rkNm"),new BigDecimal(request.getParameter("minVal")),new BigDecimal(request.getParameter("maxVal")),request.getParameter("rkds"),request.getParameter("ctms"),new BigDecimal(request.getParameter("ascc")),new Timestamp(System.currentTimeMillis()),user.getName());
//			if(!rsulFlag){
//				resObj.put("arg", "err");
//				return json(resObj);
//			}
			resObj.put("arg", "suc");
	        return json(resObj);
		}
		//3、不存在则保存新数据
        iRGMatService.saveTCraMdlRank(rkCd,request.getParameter("rkNm"),new BigDecimal(request.getParameter("minVal")),new BigDecimal(request.getParameter("maxVal")),request.getParameter("rkds"),request.getParameter("ctms"),new BigDecimal(request.getParameter("ascc")),new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
    /**
	 * 删除风险等级维护
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/delRGMat")
    public AjaxResult delRGMat() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		String rkCd = request.getParameter("rkCd");
		//1、删除数据
        int rsuFlag = iRGMatService.deleteTCraMdlRank(rkCd);
        if(rsuFlag<=0){
        	resObj.put("arg", "err");
            return json(resObj);
        }
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**查询评级模型设置初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getRatMSetList")
	public AjaxResult getRatMSetList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<RatMSet> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(iRGMatService.findAllRatMSet(page,request.getParameter("mdlCd")));
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	/**查询风指标定性设置初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getIQulSetList")
	public AjaxResult getIQulSetList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<IQulSet> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(iRGMatService.findAllIQulSet(page,request.getParameter("rlCd")));
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	
	@RequestMapping(value = "/cRat/ratRankRule",method = RequestMethod.GET)
	public String index(){
		String rlCd = request.getParameter("rlCd");
		request.setAttribute("url","/cRat/ratRankRule.html");
		session.setAttribute("rlCd", rlCd);
		return "/cRat/ratRankRule";
	}
	/**查询风指标定性设置初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getRatRankRuleList")
	public AjaxResult getRatRankRuleList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<RatRankRule> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(iRGMatService.findAllRatRankRule(page,request.getParameter("rlCd")));
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	@RequestMapping(value = "/cRat/ratMSetMod",method = RequestMethod.GET)
	public String getRatMSetMod(){
		request.setAttribute("url","/cRat/ratMFct.html");
		return "/cRat/ratMFct";
	}
	/**查询评级模型因子表初始化数据*/
	@ResponseBody
	@RequestMapping("/sys/cRat/getRatMFctList")
	public AjaxResult getRatMFctList() {
		//获取form提交的数据
//		String userName= request.getParameter("searchName");
		Page<RatMFct> page = getPage();
		Map<String, Object> resObj = new HashMap<String, Object>();
		page.setRecords(iRGMatService.findAllRatMFct(page));
//		page.setTotal(1);
		resObj.put("total", page.getTotal());
		resObj.put("rows", page.getRecords());
		// 判断用户是否存在
		return json(resObj);
	}
	/**
	 * 新增评级模型设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/addRatMSet")
    public AjaxResult addRatMSet() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		//1、根据主键查询是否存在相同的数据
		String mdlCd = request.getParameter("mdlCd");
		//查询数据
		List<RatMSet> ramList = iRGMatService.findAllRatMSet(request.getParameter("mdlCd"));
		//2、存在返回提示信息
		if(ramList.size()>0){
		   resObj.put("pkConf", true);
	       return json(resObj);
		}
		//3、不存在则保存新数据
		User user = (User) request.getSession().getAttribute("user");
        iRGMatService.saveRatMSet(mdlCd,request.getParameter("mdlNm"),request.getParameter("mdlVr"),request.getParameter("mdlSc"),request.getParameter("status"),request.getParameter("remark"),new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**修改评级模型设置*/
	@RequestMapping(value = "/sys/cRat/showRatMSet",method = RequestMethod.GET)
	public String showRatMSet(@PathParam("mdlCd") String mdlCd) {
		//查询数据
		List<RatMSet> ramList = iRGMatService.findAllRatMSet(request.getParameter("mdlCd"));
		RatMSet ratMSet = new RatMSet();
		ratMSet = ramList.get(0);
		request.setAttribute("ratMSet", ratMSet);
		return "/cRat/editRatMSet";
	}
	/**
	 * 评级模型设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/editRatMSet")
    public AjaxResult editRatMSet() {
		Page<RatMSet> page = getPage();
		RatMSet ratMSet = new RatMSet();
		Map<String, Object> resObj = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("user");
		//1、根据主键查询是否存在相同的数据
		String mdlCd = request.getParameter("mdlCd");
		//查询数据
		List<RatMSet> ramList = iRGMatService.findAllRatMSet(request.getParameter("mdlCd"));
		//2、存在更新数据
		if(ramList.size()>0){
//			tCraMdlRank=rgmList.get(0);
//			tCraMdlRank.setRkCd(rkCd);
//			tCraMdlRank.setRkNm(request.getParameter("rknm"));
//			tCraMdlRank.setMinVal(new BigDecimal(request.getParameter("minVal")));
//			tCraMdlRank.setMaxVal(new BigDecimal(request.getParameter("maxVal")));
//			tCraMdlRank.setAscc(new BigDecimal(request.getParameter("ascc")));
//			tCraMdlRank.setCtms(request.getParameter("ctms"));
//			tCraMdlRank.setRkds(request.getParameter("rkds"));
//			tCraMdlRank.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//			tCraMdlRank.setUpdator(user.getName());
//			boolean rsulFlag = iRGMatService.updateBatchById(rgmList);
			iRGMatService.updateRatMSet(mdlCd,request.getParameter("mdlNm"),request.getParameter("mdlVr"),request.getParameter("mdlSc"),request.getParameter("status"),request.getParameter("remark"),new Timestamp(System.currentTimeMillis()),user.getName());
//			if(!rsulFlag){
//				resObj.put("arg", "err");
//				return json(resObj);
//			}
			resObj.put("arg", "suc");
	        return json(resObj);
		}
		//3、不存在则保存新数据
		iRGMatService.saveRatMSet(mdlCd,request.getParameter("mdlNm"),request.getParameter("mdlVr"),request.getParameter("mdlSc"),request.getParameter("status"),request.getParameter("remark"),new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
    /**
	 * 删除评级模型设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/delRatMSet")
    public AjaxResult delRatMSet() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		String mdlCd = request.getParameter("mdlCd");
		//1、删除数据
        int rsuFlag = iRGMatService.deleteRatMSet(mdlCd);
        if(rsuFlag<=0){
        	resObj.put("arg", "err");
            return json(resObj);
        }
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**
	 * 新增评级模型因子
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/addRatMFct")
    public AjaxResult addRatMFct() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		//1、根据主键查询是否存在相同的数据
		String mdlCd = request.getParameter("mdlCd");
		//查询数据
//		List<RatMFct> ramList = iRGMatService.findAllRatMFct(request.getParameter("mdlCd"));
//		//2、存在返回提示信息
//		if(ramList.size()>0){
//		   resObj.put("pkConf", true);
//	       return json(resObj);
//		}
		//3、不存在则保存新数据
		User user = (User) request.getSession().getAttribute("user");
        iRGMatService.saveRatMFct(mdlCd,request.getParameter("mdlVer"),new BigDecimal(request.getParameter("lvlNo")), request.getParameter("fctLvl"),request.getParameter("fctCd"),request.getParameter("fctNm"),request.getParameter("fctTp"),request.getParameter("fctKd"), request.getParameter("supLvl"), request.getParameter("config"), new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**修改评级模型因子*/
	@RequestMapping(value = "/sys/cRat/showRatMFct",method = RequestMethod.GET)
	public String showRatMFct(@PathParam("id") String id) {
		//查询数据
		List<RatMFct> ramList = iRGMatService.findAllRatMFct(request.getParameter("id"));
		RatMFct ratMFct = new RatMFct();
		ratMFct = ramList.get(0);
		request.setAttribute("ratMFct", ratMFct);
		return "/cRat/editRatMFct";
	}
	/**
	 * 评级模型因子
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/editRatMFct")
    public AjaxResult editRatMFct() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("user");
		//1、根据主键查询是否存在相同的数据
		String mdlCd = request.getParameter("mdlCd");
		//查询数据
		List<RatMFct> ramList = iRGMatService.findAllRatMFct(request.getParameter("id"));
		//2、存在更新数据
		if(ramList.size()>0){
			iRGMatService.updateRatMFct(mdlCd,request.getParameter("mdlVer"),new BigDecimal(request.getParameter("lvlNo")), request.getParameter("fctLvl"),request.getParameter("fctCd"),request.getParameter("fctNm"),request.getParameter("fctTp"),request.getParameter("fctKd"), request.getParameter("supLvl"), request.getParameter("config"), new Timestamp(System.currentTimeMillis()),user.getName(),new BigDecimal(request.getParameter("id")));
			resObj.put("arg", "suc");
	        return json(resObj);
		}
		//3、不存在则保存新数据
		iRGMatService.saveRatMFct(mdlCd,request.getParameter("mdlVer"),new BigDecimal(request.getParameter("lvlNo")), request.getParameter("fctLvl"),request.getParameter("fctCd"),request.getParameter("fctNm"),request.getParameter("fctTp"),request.getParameter("fctKd"), request.getParameter("supLvl"), request.getParameter("config"), new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
    /**
	 * 删除评级模型因子
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/delRatMFct")
    public AjaxResult delRatMFct() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		BigDecimal id = new BigDecimal(request.getParameter("id"));
		//1、删除数据
        int rsuFlag = iRGMatService.deleteRatMFct(id);
        if(rsuFlag<=0){
        	resObj.put("arg", "err");
            return json(resObj);
        }
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**
	 * 新增指标定性设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/addIQulSet")
    public AjaxResult addIQulSet() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		//1、根据主键查询是否存在相同的数据
		String rlNm = request.getParameter("rlNm");
		//3、保存新数据
		User user = (User) request.getSession().getAttribute("user");
		//String rlNm,String rlTp,String status,String adjRank,String tgtRank,BigDecimal priority,Timestamp createTime,String creator,Timestamp updateTime,String updator
        iRGMatService.saveIQulSet(rlNm,request.getParameter("rlTp"),request.getParameter("status"), request.getParameter("adjRank"),request.getParameter("tgtRank"),new BigDecimal(request.getParameter("priority")), new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**修改指标定性设置*/
	@RequestMapping(value = "/sys/cRat/showIQulSet",method = RequestMethod.GET)
	public String showIQulSet(@PathParam("rlCd") String rlCd) {
		Page<IQulSet> page = getPage();
		//查询数据
		List<IQulSet> iqsList = iRGMatService.findAllIQulSet(page, request.getParameter("rlCd"));
		IQulSet iQulSet = new IQulSet();
		iQulSet = iqsList.get(0);
		request.setAttribute("iQulSet", iQulSet);
		return "/cRat/editIQulSet";
	}
	/**
	 * 指标定性设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/editIQulSet")
    public AjaxResult editIQulSet() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		User user = (User) request.getSession().getAttribute("user");
		Page<IQulSet> page = getPage();
		//1、根据主键查询是否存在相同的数据
		String rlCd = request.getParameter("rlCd");
		//查询数据
		List<IQulSet> iqsList = iRGMatService.findAllIQulSet(page, request.getParameter("rlCd"));
		//2、存在更新数据
		if(iqsList.size()>0){
			iRGMatService.updateIQulSet(request.getParameter("rlNm"),request.getParameter("rlTp"),request.getParameter("status"), request.getParameter("adjRank"),request.getParameter("tgtRank"),new BigDecimal(request.getParameter("priority")), new Timestamp(System.currentTimeMillis()),user.getName(),new BigDecimal(request.getParameter("rlCd")));
			resObj.put("arg", "suc");
	        return json(resObj);
		}
		//3、不存在则保存新数据
		iRGMatService.saveIQulSet(request.getParameter("rlNm"),request.getParameter("rlTp"),request.getParameter("status"), request.getParameter("adjRank"),request.getParameter("tgtRank"),new BigDecimal(request.getParameter("priority")), new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
    /**
	 * 删除指标定性设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/delIQulSet")
    public AjaxResult delIQulSet() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		BigDecimal rlCd = new BigDecimal(request.getParameter("rlCd"));
		//1、删除数据
        int rsuFlag = iRGMatService.deleteIQulSet(rlCd);
        if(rsuFlag<=0){
        	resObj.put("arg", "err");
            return json(resObj);
        }
        resObj.put("arg", "suc");
        return json(resObj);
    }
	/**
	 * 新增指标定性设置
	 */
	@ResponseBody
	@RequestMapping("/sys/cRat/addRankRule")
    public AjaxResult addRankRule() {
		Map<String, Object> resObj = new HashMap<String, Object>();
		//3、保存新数据
		User user = (User) request.getSession().getAttribute("user");
        iRGMatService.saveRatRankRule(request.getParameter("rId"),request.getParameter("modleInd"),request.getParameter("indMatch"),new Timestamp(System.currentTimeMillis()),user.getName(),new Timestamp(System.currentTimeMillis()),user.getName());
        resObj.put("arg", "suc");
        return json(resObj);
    }
}
