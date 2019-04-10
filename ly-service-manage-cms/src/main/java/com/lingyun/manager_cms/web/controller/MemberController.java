package com.lingyun.manager_cms.web.controller;

import com.lingyun.api.shop.MemberControllerApi;
import com.lingyun.framework.domain.shop.Member;
import com.lingyun.manager_cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController implements MemberControllerApi  {

    @Autowired
    private MemberService memberService;

    @Override
    public List<Member> findList(Member member) {
        return memberService.findList(member);
    }
}
