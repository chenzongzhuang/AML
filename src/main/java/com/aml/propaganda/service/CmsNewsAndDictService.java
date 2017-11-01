package com.aml.propaganda.service;

import com.aml.propaganda.model.CmsNewsAndDictModel;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * Created by hb on 2017/10/24.
 */
public interface CmsNewsAndDictService {
    /**
     * 查询出全部的宣传培训内容
     * @return List
     */
    List<CmsNewsAndDictModel> findAllCmsNewsJoinId(Page page,String channelId,String title);
}
