package com.lingyun.manager_cms.dao;

import com.lingyun.framework.domain.admin.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer infoid);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer infoid);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    List<Info> query();

    void delete(@Param("ids") String ids);
}