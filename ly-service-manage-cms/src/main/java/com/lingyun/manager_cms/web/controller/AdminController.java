package com.lingyun.manager_cms.web.controller;

import com.lingyun.api.shop.AdminControllerApi;
import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.manager_cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController implements AdminControllerApi {

    @Autowired
    private AdminService adminService;

    @Override
    public List<Admin> findList() {
        return adminService.findList();
    }
}
