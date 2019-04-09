package com.lingyun.manager_cms.service.impl;

import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.manager_cms.dao.AdminMapper;
import com.lingyun.manager_cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService  {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findList() {
        return adminMapper.findList();
    }
}
