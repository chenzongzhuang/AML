package com.aml.propaganda.mapper;

import com.aml.propaganda.model.CmsNewsAndDictModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 宣传培训Mapper
 * @author hb
 * @time 2017年10月22日 下午10:23:57
 * @gitcafe 977203542@qq.com
 */
public interface CmsNewsAndDictMapper  extends BaseMapper<CmsNewsAndDictModel> {
	/**
	 * 查询出全部的宣传培训内容
	 * @return List
	 */
	public List<CmsNewsAndDictModel> findAllCmsNewsJoinId(Page page,@Param("channelId") String channelId,@Param("title") String title);
}
