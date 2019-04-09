package com.lingyun.manager_cms.service;

import com.lingyun.framework.domain.shop.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 后台用户列表查询
     * @param admin
     * @return
     */
    public List<Admin> findList();
}
