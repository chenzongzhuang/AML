package com.aml.sys.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.Dept;
import com.aml.sys.entity.Dict;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 */
public interface IDictService extends IService<Dict> {
    List<Dict> getDictByNameOrId(Page page,@Param("dmTp") String dmTp,@Param("dmCd") String dmCd,@Param("dmNm") String dmNm);
    /**
     * 根据dmtp查询下面所有的栏目
     * @param dmTp
     * @return
     */
    List<Dict> findDictByDmTp(@Param("dmTp") String dmTp);
    
    Dict getDictById(int id);
}
