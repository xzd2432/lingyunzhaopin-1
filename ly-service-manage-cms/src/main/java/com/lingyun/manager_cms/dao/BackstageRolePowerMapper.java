package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstageRolePower;

public interface BackstageRolePowerMapper {
    int deleteByPrimaryKey(Integer brpid);

    int insert(BackstageRolePower record);

    int insertSelective(BackstageRolePower record);

    BackstageRolePower selectByPrimaryKey(Integer brpid);

    int updateByPrimaryKeySelective(BackstageRolePower record);

    int updateByPrimaryKey(BackstageRolePower record);
}