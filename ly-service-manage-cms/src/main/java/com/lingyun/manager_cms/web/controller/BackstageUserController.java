package com.lingyun.manager_cms.web.controller;

import com.lingyun.api.admin.BackstageUserControllerApi;
import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;
import com.lingyun.manager_cms.service.BackstageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BackstageUserController implements BackstageUserControllerApi {

    @Autowired
    private BackstageUserService backstageUserService;


    @Override
    public List<BackstageUser> queryBuser(BackstageUser backstageUser) {
        return backstageUserService.queryBuser(backstageUser);
    }

    @Override
    public void addBackstageUser(BackstageUser backstageUser) {
        backstageUserService.addBackstageUser(backstageUser);
    }

    @Override
    public BackstageUser queryBuserById(int id) {
        return backstageUserService.queryBuserById(id);
    }

    @Override
    public void updstatus(Integer id) {
        backstageUserService.updstatus(id);
    }

    @Override
    public List<BackstageOutfit> queryBoutfit() {
        return backstageUserService.queryBoutfit();
    }

    @Override
    public void updstatus1(Integer id) {
        backstageUserService.updstatus1(id);
    }

    @Override
    public List<BackstageUser> queryBuserjy(BackstageUser backstageUser) {
        return backstageUserService.queryBuserjy(backstageUser);
    }

    @Override
    public void updspstatus(Integer id) {
        backstageUserService.updspstatus(id);
    }

    @Override
    public void updspstatus1(Integer id) {
        backstageUserService.updspstatus1(id);
    }

    @Override
    public List<BackstageUser> queryBusersp(BackstageUser backstageUser) {
        return backstageUserService.queryBusersp(backstageUser);
    }

    @Override
    public void updBackstageUser(BackstageUser backstageUser) {
        backstageUserService.updBackstageUser(backstageUser);
    }
}
