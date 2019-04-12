package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstageOutfit;

import java.util.List;

public interface BackstageOutfitMapper {
    int deleteByPrimaryKey(Integer boid);

    int insert(BackstageOutfit record);

    int insertSelective(BackstageOutfit record);

    BackstageOutfit selectByPrimaryKey(Integer boid);

    int updateByPrimaryKeySelective(BackstageOutfit record);

    int updateByPrimaryKey(BackstageOutfit record);

    List<BackstageOutfit> queryBoutfit();
}