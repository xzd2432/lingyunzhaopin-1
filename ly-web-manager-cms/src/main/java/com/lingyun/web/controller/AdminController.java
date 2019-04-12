package com.lingyun.web.controller;

import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
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


