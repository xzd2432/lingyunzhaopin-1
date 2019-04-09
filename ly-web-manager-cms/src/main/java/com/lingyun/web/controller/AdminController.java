package com.lingyun.web.controller;

import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/findList")
    public List<Admin> findList() {
        return adminService.findList();
    }

    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin";
    }
}


