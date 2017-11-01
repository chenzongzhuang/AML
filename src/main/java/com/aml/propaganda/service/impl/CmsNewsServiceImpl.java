package com.aml.propaganda.service.impl;

import com.aml.propaganda.entity.CmsNewsEntity;
import com.aml.propaganda.mapper.CmsNewsMapper;
import com.aml.propaganda.service.CmsNewsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 宣传培训实现方法
 * @author hb
 * @time 2017年10月22日 下午10:26:28
 * @gitcafe 977203542@qq.com
 */
@Service
@Transactional
public class CmsNewsServiceImpl extends ServiceImpl<CmsNewsMapper, CmsNewsEntity> implements CmsNewsService{
	
	@Autowired
	private CmsNewsMapper cmsNewsMapper;

	@Override
	public List<CmsNewsEntity> findAllCmsNews() {
		return cmsNewsMapper.findAllCmsNews();
	}

	@Override
	public void updateCmsNewsById(Integer id) {
		
	}

	@Override
	public void delCmsNewsById(Integer id) {
		
	}

	@Override
	public List<CmsNewsEntity> findAllCmsNewsByChannelId(String channelId,int id) {
		return cmsNewsMapper.findAllCmsNewsByChannelId(channelId,id);
	}

}
