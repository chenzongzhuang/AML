package com.aml.earlyWarning.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.earlyWarning.entity.EarlyWarmingArea;
import com.aml.earlyWarning.entity.RollIdDelete;
import com.aml.earlyWarning.entity.TStanAreaRoll;
import com.aml.earlyWarning.entity.TStanAreaRollType;
import com.aml.earlyWarning.entity.TStanEsseRoll;
import com.aml.earlyWarning.entity.TStanMateRole;
import com.aml.earlyWarning.service.EarlyWarmingAreaService;
import com.aml.earlyWarning.service.TStanAreaRollService;
import com.aml.earlyWarning.service.TStanEsseRollService;
import com.aml.earlyWarning.service.TStanMateRoleService;
import com.aml.earlyWarning.service.impl.TStanAreaRollTypeServiceImpl;
import com.aml.sys.entity.TStanMaiin;
import com.aml.sys.entity.TradingStandard;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 去噪规则
 * 
 * @author zhongrui
 * 
 */

@Controller
public class EarlyWarningController extends BaseController {

	@Autowired
	TStanAreaRollTypeServiceImpl tStanAreaRollTypeServiceImpl;// 去噪规则

	@Autowired
	TStanMateRoleService tStanMateRoleService;// 匹配规则

	@Autowired
	TStanEsseRollService tStanEsseRollService;// 观察名单

	@Autowired
	TStanAreaRollService tStanAreaRollService;// 地区观察名单

	@Autowired
	EarlyWarmingAreaService earlyWarmingAreaService;// 名单预警个人地区

	// 去噪规则页面访问
	@RequestMapping("/earlyWarning/ruler/TStanAreaRollType.html")
	public String target() {
		return "/earlyWarning/ruler/TStanAreaRollType";
	}

	// 匹配规则页面访问
	@RequestMapping("/earlyWarning/ruler/TStanMateRole.html")
	public String tStanMateRole() {
		return "/earlyWarning/ruler/TStanMateRole";
	}

	// 名单页面访问
	@RequestMapping("/earlyWarning/ruler/TStanEsseRoll.html")
	public String TStanEsseRoll() {
		return "/earlyWarning/ruler/TStanEsseRoll";
	}

	// 地区观察名单页面访问
	@RequestMapping("/earlyWarning/ruler/TStanAreaRoll.html")
	public String TStanAreaRoll() {
		return "/earlyWarning/ruler/TStanAreaRoll";
	}

	// 名单预警个人地区页面访问
	@RequestMapping("/earlyWarning/ruler/EarlyWarmingArea.html")
	public String EarlyWarmingArea() {
		return "/earlyWarning/ruler/EarlyWarmingArea";
	}

	/***************************************** 去噪规则 **************************************************/
	@RequestMapping("/earlyWarning/ruler/QueryTStanAreaRollType")
	@ResponseBody
	public Map<String, Object> AuqryTarget(TStanAreaRollType tStanAreaRollType)
			throws Exception {

		Page<TStanAreaRollType> page = getPage();
		page.setSize(Integer.valueOf(tStanAreaRollType.getRows()));
		page.setCurrent(Integer.valueOf(tStanAreaRollType.getPage()));
		page = tStanAreaRollTypeServiceImpl.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent() + "");
		resObj.put("total", page.getPages() + "");
		resObj.put("records", page.getRecords().size() + "");
		resObj.put("rows", page.getRecords());
		return resObj;
	}

	@RequestMapping("/earlyWarning/ruler/FindTStanAreaRollType")
	@ResponseBody
	public AjaxResult QuaryNaOrEare(HttpServletRequest request,
			TStanAreaRollType tStanAreaRollType) throws Exception {

		tStanAreaRollType.setCurrentPage();
		tStanAreaRollType.setCurrentReslut();

		List<TStanAreaRollType> target = tStanAreaRollTypeServiceImpl
				.find(tStanAreaRollType);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", tStanAreaRollType.getPage() + "");
		resObj.put("total",
				target.size() / (Integer.valueOf(tStanAreaRollType.getRows()))
						+ 1 + "");
		resObj.put("records",
				tStanAreaRollTypeServiceImpl.qyeryCount(tStanAreaRollType)
						.size() + "");
		resObj.put("rows", target);

		return json(resObj);
	}

	@RequestMapping("/earlyWarning/ruler/AddTStanAreaRollType")
	@ResponseBody
	public void AddTStanAreaRollType(TStanAreaRollType tStanAreaRollType)
			throws Exception {

		tStanAreaRollType.setRollId(UUID.randomUUID().toString()
				.replace("-", ""));
		tStanAreaRollTypeServiceImpl.add(tStanAreaRollType);

	}

	@RequestMapping("/earlyWarning/ruler/UpdateTStanAreaRollType")
	@ResponseBody
	public void updateTStanAreaRollType(TStanAreaRollType tStanAreaRollType)
			throws Exception {
		tStanAreaRollTypeServiceImpl.updateByrollId(tStanAreaRollType);
		;
	}

	@RequestMapping("/earlyWarning/ruler/DeleteTStanAreaRollType")
	@ResponseBody
	public void deleteTStanAreaRollType(RollIdDelete rollIdDelete)
			throws Exception {
		tStanAreaRollTypeServiceImpl.deleteByrollId(rollIdDelete
				.getRollIdDelete());
	}

	/***************************************** 去噪规则 **************************************************/

	/***************************************** 匹配规则 **************************************************/

	@RequestMapping("/earlyWarning/ruler/QueryTStanMateRole")
	@ResponseBody
	public Map<String, Object> QueryTStanMateRole(TStanMateRole tStanMateRole)
			throws Exception {

		Page<TStanMateRole> page = getPage();
		page.setSize(Integer.valueOf(tStanMateRole.getRows()));
		page.setCurrent(Integer.valueOf(tStanMateRole.getPage()));
		page = tStanMateRoleService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent() + "");
		resObj.put("total", page.getPages() + "");
		resObj.put("records", page.getRecords().size() + "");
		resObj.put("rows", page.getRecords());
		return resObj;
	}

	@RequestMapping("/earlyWarning/ruler/FindTStanMateRole")
	@ResponseBody
	public AjaxResult FindTStanMateRole(HttpServletRequest request,
			TStanMateRole tStanMateRole) throws Exception {

		tStanMateRole.setCurrentPage();
		tStanMateRole.setCurrentReslut();

		List<TStanMateRole> target = tStanMateRoleService.find(tStanMateRole);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", tStanMateRole.getPage() + "");
		resObj.put("total",
				target.size() / (Integer.valueOf(tStanMateRole.getRows())) + 1
						+ "");
		resObj.put("records", tStanMateRoleService.qyeryCount(tStanMateRole)
				.size() + "");
		resObj.put("rows", target);

		return json(resObj);
	}

	@RequestMapping("/earlyWarning/ruler/AddTStanMateRole")
	@ResponseBody
	public void AddTStanMateRole(TStanMateRole tStanMateRole) throws Exception {

		tStanMateRole.setMateId(UUID.randomUUID().toString().replace("-", ""));
		tStanMateRoleService.add(tStanMateRole);

	}

	@RequestMapping("/earlyWarning/ruler/UpdateTStanMateRole")
	@ResponseBody
	public void UpdateTStanMateRole(TStanMateRole tStanMateRole)
			throws Exception {
		tStanMateRoleService.updateByrollId(tStanMateRole);
		;
	}

	@RequestMapping("/earlyWarning/ruler/QueryMateRoleByMateNo")
	@ResponseBody
	public String queryMateRoleByMateNo(TStanMateRole tStanMateRole)
			throws Exception {
		List<TStanMateRole> target = tStanMateRoleService
				.queryMateRoleByMateNo(tStanMateRole);
		if (target == null || target.size() == 0) {
			return "result:{\"valid\":" + true + "}";
		} else {
			return "result:{\"valid\":" + false + "}";
		}
	}

	@RequestMapping("/earlyWarning/ruler/DeleteTStanMateRole")
	@ResponseBody
	public void DeleteTStanMateRole(RollIdDelete rollIdDelete) throws Exception {
		tStanMateRoleService.deleteByrollId(rollIdDelete.getRollIdDelete());
	}

	/***************************************** 匹配规则 **************************************************/

	/***************************************** 观察名单 **************************************************/

	@RequestMapping("/earlyWarning/ruler/QueryTStanEsseRoll")
	@ResponseBody
	public Map<String, Object> QueryTStanEsseRoll(TStanEsseRoll tStanEsseRoll)
			throws Exception {

		Page<TStanEsseRoll> page = getPage();
		page.setSize(Integer.valueOf(tStanEsseRoll.getRows()));
		page.setCurrent(Integer.valueOf(tStanEsseRoll.getPage()));
		page = tStanEsseRollService.selectPage(page, null);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", page.getCurrent() + "");
		resObj.put("total", page.getPages() + "");
		resObj.put("records", page.getRecords().size() + "");
		resObj.put("rows", page.getRecords());
		return resObj;
	}

	@RequestMapping("/earlyWarning/ruler/FindTStanEsseRoll")
	@ResponseBody
	public AjaxResult FindTStanEsseRoll(HttpServletRequest request,
			TStanEsseRoll tStanEsseRoll) throws Exception {

		tStanEsseRoll.setCurrentPage();
		tStanEsseRoll.setCurrentReslut();

		List<TStanEsseRoll> target = tStanEsseRollService.find(tStanEsseRoll);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", tStanEsseRoll.getPage() + "");
		resObj.put("total",
				target.size() / (Integer.valueOf(tStanEsseRoll.getRows())) + 1
						+ "");
		resObj.put("records", tStanEsseRollService.qyeryCount(tStanEsseRoll)
				.size() + "");
		resObj.put("rows", target);

		return json(resObj);
	}

	@RequestMapping("/earlyWarning/ruler/AddTStanEsseRoll")
	@ResponseBody
	public void AddTStanEsseRoll(TStanEsseRoll tStanEsseRoll) throws Exception {

		tStanEsseRoll.setEsseId(UUID.randomUUID().toString().replace("-", ""));
		tStanEsseRollService.add(tStanEsseRoll);

	}

	@RequestMapping("/earlyWarning/ruler/UpdateTStanEsseRoll")
	@ResponseBody
	public void UpdateTStanEsseRoll(TStanEsseRoll tStanEsseRoll)
			throws Exception {
		tStanEsseRollService.updateByrollId(tStanEsseRoll);
		;
	}

	@RequestMapping("/earlyWarning/ruler/QueryTStanEsseRollByMateNo")
	@ResponseBody
	public String queryTStanEsseRollByMateNo(TStanEsseRoll tStanEsseRoll)
			throws Exception {
		List<TStanEsseRoll> target = tStanEsseRollService
				.queryMateRoleByRollNo(tStanEsseRoll);
		if (target == null || target.size() == 0) {
			return "result:{\"valid\":" + true + "}";
		} else {
			return "result:{\"valid\":" + false + "}";
		}
	}

	@RequestMapping("/earlyWarning/ruler/DeleteTStanEsseRoll")
	@ResponseBody
	public void tStanEsseRollService(RollIdDelete rollIdDelete)
			throws Exception {
		tStanMateRoleService.deleteByrollId(rollIdDelete.getRollIdDelete());
	}

	/***************************************** 观察名单 **************************************************/

	/***************************************** 地区观察名单 **************************************************/

	@RequestMapping("/earlyWarning/ruler/FindTStanAreaRoll")
	@ResponseBody
	public AjaxResult FindTStanAreaRoll(HttpServletRequest request,
			TStanAreaRoll tStanAreaRoll) throws Exception {

		tStanAreaRoll.setCurrentPage();
		tStanAreaRoll.setCurrentReslut();

		List<TStanAreaRoll> target = tStanAreaRollService.find(tStanAreaRoll);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", tStanAreaRoll.getPage() + "");
		resObj.put("total",
				target.size() / (Integer.valueOf(tStanAreaRoll.getRows())) + 1
						+ "");
		resObj.put("records", tStanAreaRollService.qyeryCount(tStanAreaRoll)
				.size() + "");
		resObj.put("rows", target);

		return json(resObj);
	}

	@RequestMapping("/earlyWarning/ruler/AddTStanAreaRoll")
	@ResponseBody
	public void AddTStanAreaRoll(TStanAreaRoll tStanAreaRoll) throws Exception {

		tStanAreaRoll.setAreaRollId(UUID.randomUUID().toString()
				.replace("-", ""));
		tStanAreaRollService.add(tStanAreaRoll);

	}

	@RequestMapping("/earlyWarning/ruler/UpdateTStanAreaRoll")
	@ResponseBody
	public void UpdateTStanAreaRoll(TStanAreaRoll tStanAreaRoll)
			throws Exception {
		tStanAreaRollService.updateByrollId(tStanAreaRoll);
		;
	}

	@RequestMapping("/earlyWarning/ruler/DeleteTStanAreaRoll")
	@ResponseBody
	public void deleteTStanAreaRoll(RollIdDelete rollIdDelete) throws Exception {
		tStanAreaRollService.deleteByrollId(rollIdDelete.getRollIdDelete());
	}

	/***************************************** 地区观察名单 **************************************************/

	/***************************************** 名单预警个人地区 **************************************************/

	@RequestMapping("/earlyWarning/ruler/FindTStanArea")
	@ResponseBody
	public AjaxResult FindArea(HttpServletRequest request,
			EarlyWarmingArea earlyWarmingArea) throws Exception {

		earlyWarmingArea.setCurrentPage();
		earlyWarmingArea.setCurrentReslut();

		List<EarlyWarmingArea> target = earlyWarmingAreaService
				.find(earlyWarmingArea);
		Map<String, Object> resObj = new HashMap<String, Object>();
		resObj.put("page", earlyWarmingArea.getPage() + "");
		resObj.put("total",
				target.size() / (Integer.valueOf(earlyWarmingArea.getRows()))
						+ 1 + "");
		resObj.put("records",
				earlyWarmingAreaService.qyeryCount(earlyWarmingArea).size()
						+ "");
		resObj.put("rows", target);

		return json(resObj);
	}

	/***************************************** 名单预警个人地区 **************************************************/

}
