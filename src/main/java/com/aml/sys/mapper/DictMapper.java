
package com.aml.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.aml.sys.entity.Dict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 字典dao
 *
 */
public interface DictMapper extends BaseMapper<Dict> {


    List<Dict> getDictByNameOrId(Page page,@Param("dmTp") String dmTp,@Param("dmCd") String dmCd,@Param("dmNm") String dmNm);
    
    /**
     * 根据dmtp查询下面所有的栏目
     * @param dmTp
     * @return
     */
    List<Dict> findDictByDmTp(@Param("dmTp") String dmTp);
    Dict getDictById(@Param("id") int id);
    
}
