package com.lingyun.manager_cms.service.impl;

import com.lingyun.framework.domain.admin.Info;
import com.lingyun.manager_cms.dao.InfoMapper;
import com.lingyun.manager_cms.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> query() {
        return infoMapper.query();
    }

    @Override
    public Info select(Integer infoid) {
        return  infoMapper.selectByPrimaryKey(infoid);
    }

    @Override
    public void del(Integer infoid) {
        infoMapper.deleteByPrimaryKey(infoid);
    }

    @Override
    public void delte(String ids) {
        infoMapper.delete(ids);
    }

    @Override
    public void add(Info info) {
        infoMapper.insertSelective(info);
    }
}
