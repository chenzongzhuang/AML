package com.aml.sys.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.sys.entity.Relation;
import com.aml.sys.mapper.RelationMapper;
import com.aml.sys.service.IRelationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
@Service
@Transactional
public class RelationImpl extends ServiceImpl<RelationMapper, Relation> implements IRelationService {

	

}
