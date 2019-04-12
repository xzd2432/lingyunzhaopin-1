package com.lingyun.manager_cms.dao;

import com.lingyun.framework.domain.admin.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(Job job);

    int updateByPrimaryKeyWithBLOBs(Job record);

    int updateByPrimaryKey(Job record);

    List<Job> queryJob();
}