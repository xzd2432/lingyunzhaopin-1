package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstageUserRole;

public interface BackstageUserRoleMapper {
    int deleteByPrimaryKey(Integer burid);

    int insert(BackstageUserRole record);

    int insertSelective(BackstageUserRole record);

    BackstageUserRole selectByPrimaryKey(Integer burid);

    int updateByPrimaryKeySelective(BackstageUserRole record);

    int updateByPrimaryKey(BackstageUserRole record);
}