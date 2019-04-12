package com.lingyun.manager_cms.service.impl;

import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;
import com.lingyun.manager_cms.dao.*;
import com.lingyun.manager_cms.service.BackstageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackstageUserServiceImpl implements BackstageUserService {

    @Autowired
    private BackstageUserMapper backstageUserMapper;
    @Autowired
    private BackstageUserRoleMapper backstageUserRoleMapper;
    @Autowired
    private BackstageRoleMapper backstageRoleMapper;
   @Autowired
    private BackstagePowerMapper backstagePowerMapper;
   @Autowired
    private BackstageRolePowerMapper backstageRolePowerMapper;
   @Autowired
   private BackstageOutfitMapper backstageOutfitMapper;


    @Override
    public List<BackstageUser> queryBuser(BackstageUser backstageUser) {
        return backstageUserMapper.queryBuser(backstageUser);
    }

    @Override
    public void addBackstageUser(BackstageUser backstageUser) {
        backstageUserMapper.insert(backstageUser);
    }

    @Override
    public BackstageUser queryBuserById(int id) {
        return backstageUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updstatus(Integer id) {
        backstageUserMapper.updstatus(id);
    }

    @Override
    public List<BackstageOutfit> queryBoutfit() {
        return backstageOutfitMapper.queryBoutfit();
    }

    @Override
    public void updstatus1(Integer id) {
        backstageUserMapper.updstatus1(id);
    }

    @Override
    public List<BackstageUser> queryBuserjy(BackstageUser backstageUser) {
        return backstageUserMapper.queryBuserjy(backstageUser);
    }

    @Override
    public void updspstatus(Integer id) {
        backstageUserMapper.updspstatus(id);
    }

    @Override
    public void updspstatus1(Integer id) {
        backstageUserMapper.updspstatus1(id);
    }

    @Override
    public List<BackstageUser> queryBusersp(BackstageUser backstageUser) {
        return backstageUserMapper.queryBusersp(backstageUser);
    }

    @Override
    public void updBackstageUser(BackstageUser backstageUser) {
        backstageUserMapper.updateByPrimaryKey(backstageUser);
    }
}
