package com.lingyun.manager_cms.service.impl;

import com.lingyun.framework.domain.shop.Member;
import com.lingyun.manager_cms.dao.MemberMapper;
import com.lingyun.manager_cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> findList(Member member) {
        return memberMapper.findList(member);
    }
}
