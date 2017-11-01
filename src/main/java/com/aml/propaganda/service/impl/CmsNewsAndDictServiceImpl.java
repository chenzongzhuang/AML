package com.aml.propaganda.service.impl;

import com.aml.propaganda.mapper.CmsNewsAndDictMapper;
import com.aml.propaganda.model.CmsNewsAndDictModel;
import com.aml.propaganda.service.CmsNewsAndDictService;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hb on 2017/10/24.
 */
@Service
@Transactional
public class CmsNewsAndDictServiceImpl extends ServiceImpl<CmsNewsAndDictMapper,CmsNewsAndDictModel> implements CmsNewsAndDictService{

    @Autowired
    private CmsNewsAndDictMapper cmsNewsAndDictMapper;

    @Override
    public List<CmsNewsAndDictModel> findAllCmsNewsJoinId(Page page,String channelId,String title) {
        return cmsNewsAndDictMapper.findAllCmsNewsJoinId(page,channelId,title);
    }
}
