
package com.aml.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.sys.entity.Dict;
import com.aml.sys.mapper.DictMapper;
import com.aml.sys.service.IDictService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 */
@Service
@Transactional
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {
	@Autowired
	DictMapper dictMapper;

	@Override
	public List<Dict> getDictByNameOrId(Page page, String dmTp, String dmCd, String dmNm) {
		return dictMapper.getDictByNameOrId(page, dmTp, dmCd, dmNm);
	}

	@Override
	public List<Dict> findDictByDmTp(String dmTp) {
		return dictMapper.findDictByDmTp(dmTp);
	}

	@Override
	public Dict getDictById(int id) {
		
		return dictMapper.getDictById(id);
	}
	
}
