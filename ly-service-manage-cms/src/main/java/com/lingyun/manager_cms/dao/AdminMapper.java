package com.lingyun.manager_cms.dao;

import com.lingyun.framework.domain.shop.Admin;

import java.util.List;

public interface AdminMapper {

    /**
     * 后台用户查询列表
     * @param admin
     * @return
     */
    public List<Admin> findList();
}