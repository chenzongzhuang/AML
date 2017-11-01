package com.aml.propaganda.service;

import com.aml.propaganda.entity.CmsNewsEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 宣传培训Service
 * @author hb
 * @time 2017年10月22日 下午10:25:48
 * @gitcafe 977203542@qq.com
 */
public interface CmsNewsService  extends IService<CmsNewsEntity> {
	/**
	 * 查询出全部的宣传培训内容
	 * @return List
	 */
	public List<CmsNewsEntity> findAllCmsNews();
	
	/**
	 * 修改宣传培训状态
	 * @param id
	 */
	public void updateCmsNewsById(Integer id);
	
	/**
	 * 删除宣传培训内容
	 * @param id
	 */
	public void delCmsNewsById(Integer id);
	
	/**
	 * 根据栏目ID查询出所有的内容
	 * @param channelId
	 * @return 查询出该栏目Id下面的所有宣传培训内容
	 */
	public List<CmsNewsEntity> findAllCmsNewsByChannelId(String channelId,int id);
}
