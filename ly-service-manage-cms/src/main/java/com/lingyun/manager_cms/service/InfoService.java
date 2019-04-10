package com.lingyun.manager_cms.service;

import com.lingyun.framework.domain.admin.Info;

import java.util.List;

public interface InfoService {
    List<Info> query();

    Info select(Integer infoid);

    void del(Integer infoid);

    void delte(String ids);
}
