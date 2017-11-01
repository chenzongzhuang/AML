package com.aml.crMng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aml.crMng.entity.TStanAddress;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

public interface TStanAddressMapper extends BaseMapper<TStanAddress> {

	List<TStanAddress> findAllTStanAddress(Page page, @Param("ctifId") String ctifId);
}
