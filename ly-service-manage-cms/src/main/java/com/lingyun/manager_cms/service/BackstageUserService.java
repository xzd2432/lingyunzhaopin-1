package com.lingyun.manager_cms.service;

import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;

import java.util.List;

public interface BackstageUserService {
    List<BackstageUser> queryBuser(BackstageUser backstageUser);

    void addBackstageUser(BackstageUser backstageUser);

    BackstageUser queryBuserById(int id);

    void updstatus(Integer id);

    List<BackstageOutfit> queryBoutfit();

    void updstatus1(Integer id);

    List<BackstageUser> queryBuserjy(BackstageUser backstageUser);

    void updspstatus(Integer id);

    void updspstatus1(Integer id);

    List<BackstageUser> queryBusersp(BackstageUser backstageUser);

    void updBackstageUser(BackstageUser backstageUser);
}
