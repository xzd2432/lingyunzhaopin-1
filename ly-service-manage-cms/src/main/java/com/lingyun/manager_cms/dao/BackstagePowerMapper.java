package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstagePower;

public interface BackstagePowerMapper {
    int deleteByPrimaryKey(Integer bpid);

    int insert(BackstagePower record);

    int insertSelective(BackstagePower record);

    BackstagePower selectByPrimaryKey(Integer bpid);

    int updateByPrimaryKeySelective(BackstagePower record);

    int updateByPrimaryKey(BackstagePower record);
}