package com.lingyun.manager_cms.dao;


import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackstageUserMapper {
    int deleteByPrimaryKey(Integer buid);

    int insert(BackstageUser record);

    int insertSelective(BackstageUser record);

    BackstageUser selectByPrimaryKey(Integer buid);

    int updateByPrimaryKeySelective(BackstageUser record);

    int updateByPrimaryKey(BackstageUser record);

    List<BackstageUser> queryBuser(BackstageUser backstageUser);

    void updstatus(@Param("id") Integer id);

    void updstatus1(@Param("id") Integer id);

    List<BackstageUser> queryBuserjy(BackstageUser backstageUser);

    void updspstatus(@Param("id") Integer id);

    void updspstatus1(@Param("id") Integer id);

    List<BackstageUser> queryBusersp(BackstageUser backstageUser);

    void updBackstageUser(BackstageUser backstageUser);
}