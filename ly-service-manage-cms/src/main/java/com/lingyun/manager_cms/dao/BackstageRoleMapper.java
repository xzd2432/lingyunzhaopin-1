package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstageRole;

public interface BackstageRoleMapper {
    int deleteByPrimaryKey(Integer broleid);

    int insert(BackstageRole record);

    int insertSelective(BackstageRole record);

    BackstageRole selectByPrimaryKey(Integer broleid);

    int updateByPrimaryKeySelective(BackstageRole record);

    int updateByPrimaryKey(BackstageRole record);
}