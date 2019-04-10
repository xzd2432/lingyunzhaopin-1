package com.lingyun.manager_cms.web.controller;

import com.lingyun.api.admin.InfoControllerApi;
import com.lingyun.framework.domain.admin.Info;
import com.lingyun.manager_cms.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoCntroller implements InfoControllerApi{
    @Autowired
    private InfoService infoService;

    @Override
    public List<Info> query() {
        return infoService.query();
    }

    @Override
    public Info selete(Integer infoid) {
        return infoService.select(infoid);
    }

    @Override
    public void del(Integer infoid) {
        infoService.del(infoid);
    }

    @Override
    public void delte(String ids) {
        infoService.delte(ids);
    }
}
