package com.lingyun.web.controller;

import com.lingyun.framework.domain.shop.Member;
import com.lingyun.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/findList")
    public List<Member> findList(Member member) {
        return memberService.findList(member);
    }
}
