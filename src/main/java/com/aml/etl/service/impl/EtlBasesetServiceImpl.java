package com.aml.etl.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aml.etl.entity.EtlBaseset;
import com.aml.etl.mapper.EtlBaseSetMapper;
import com.aml.etl.service.IEtlBasesetService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
@Transactional
public class EtlBasesetServiceImpl extends ServiceImpl<EtlBaseSetMapper, EtlBaseset> implements IEtlBasesetService {
	

}
