package com.aml.propaganda.web;

import com.aml.common.toolbox.AjaxResult;
import com.aml.common.web.BaseController;
import com.aml.propaganda.entity.CmsNewsEntity;
import com.aml.propaganda.model.CmsNewsAndDictModel;
import com.aml.propaganda.service.CmsNewsAndDictService;
import com.aml.propaganda.service.CmsNewsService;
import com.aml.sys.entity.User;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cms")
public class CmsNewsController extends BaseController {

    private static final String PREFIX = "/propaganda";

    @Autowired
    private CmsNewsService cmsNewsService;

    @Autowired
    private CmsNewsAndDictService cmsNewsAndDictService;

    @RequestMapping(value = "/work.html")
    public String setWork(@RequestParam("channelId") String channelId,@RequestParam("dmNm") String dmNm) {
        List<CmsNewsEntity> getAllNews = cmsNewsService.findAllCmsNews();
        List<CmsNewsEntity> checkNews = new ArrayList<>(16);
        List<CmsNewsEntity> otherNews = new ArrayList<>(16);
        for (CmsNewsEntity entity : getAllNews){
            if(channelId.equals(entity.getChannelId())){
                checkNews.add(entity);
            }else{
                otherNews.add(entity);
            }
        }
        request.setAttribute("checkNews",checkNews);
        request.setAttribute("otherNews",otherNews);
        request.setAttribute("channelId",channelId);
        request.setAttribute("dmNm",dmNm);
        return "work";

    }

    @RequestMapping(value = "/{id}")
    public String showNews(@PathVariable int id){
        List<CmsNewsEntity> getOneNews = cmsNewsService.findAllCmsNewsByChannelId(null,id);
        request.setAttribute("getOneNews",getOneNews);
        return PREFIX+"/showCmsNews";
    }
    @RequestMapping(value = "/cmsNews")
    public String showAllNews(){
        return PREFIX+"/cmsNews";
    }

    @RequestMapping(value = "getCmsList")
    @ResponseBody
    public AjaxResult roleList() {
        Page<CmsNewsAndDictModel> page = getPage();
        List<CmsNewsAndDictModel> cmsNewsAndDictModel = cmsNewsAndDictService.findAllCmsNewsJoinId(page,request.getParameter("channelId"),request.getParameter("title"));
        page.setRecords(cmsNewsAndDictModel);
        Map<String, Object> resObj = new HashMap<>(16);
        resObj.put("total", page.getTotal());

        resObj.put("rows", page.getRecords());
        return json(resObj);
    }

    @RequestMapping(value = "/addCmsNews",method = RequestMethod.GET)
    public String addCmsNews(){
        return PREFIX+"/cms_add";
    }
    
    @RequestMapping(value="/getCmsEntity")
    @ResponseBody
    public AjaxResult getCmsEntity(){
    	CmsNewsEntity cmsNewsAndDictModel  = cmsNewsService.selectById(request.getParameter("id"));
    	Map<String, Object> resObj = new HashMap<>(16);
    	if(cmsNewsAndDictModel!=null){
    		resObj.put("arg","success");
    		resObj.put("cms",cmsNewsAndDictModel);
    	}else{
    		resObj.put("arg","获取失败");
    	}
    	return json(resObj);
    }
    
    @RequestMapping(value="/delCms")
    @ResponseBody
    public AjaxResult delCms(){
    	boolean isFlag = cmsNewsService.deleteById(Integer.valueOf(request.getParameter("id")));
    	Map<String, Object> resObj = new HashMap<>(16);
    	if(isFlag){
    		resObj.put("arg","success");
    	}else{
    		resObj.put("arg","error");
    	}
    	return json(resObj);
    }
    
    
    @RequestMapping(value="/editCmsEntity")
    @ResponseBody
    public AjaxResult editCmsEntity(){
    	CmsNewsEntity cms = new CmsNewsEntity();
    	cms.setEndDate(new Date());
    	cms.setContent(request.getParameter("editContent"));
    	cms.setTitle(request.getParameter("editTitle"));
    	cms.setId(Integer.valueOf(request.getParameter("editId")));
    	boolean isFlage = cmsNewsService.updateById(cms);
    	Map<String, Object> resObj = new HashMap<>(16);
    	if(isFlage){
    		resObj.put("arg","success");
    	}else{
    		resObj.put("arg","error");
    	}
    	
    	return json(resObj);
    }
    
    @RequestMapping(value = "/saveCmsNews",method = RequestMethod.POST)
    public String saveCmsNews(@RequestParam("content") String content,
                              @RequestParam("title") String title,
                              @RequestParam("channelId") String channelId){
        User user = (User)session.getAttribute("user");
        CmsNewsEntity cms = new CmsNewsEntity();
        cms.setAuditer(user.getAccount());
        cms.setAuditTime(new Date());
        cms.setBegDate(new Date());
        cms.setEndDate(new Date());
        cms.setIsDisplay("0");
        cms.setChannelId(channelId);
        cms.setAuthor(user.getAccount());
        cms.setContent(content);
        cms.setIsNew("0");
        cms.setIsPublish("0");
        cms.setIsScroll("0");
        cms.setKeyword(title);
        cms.setPublisher(user.getAccount());
        cms.setTitle(title);
        cms.setVisitCount("0");
        cmsNewsService.insert(cms);
        return PREFIX+"/cmsNews";
    }
}
