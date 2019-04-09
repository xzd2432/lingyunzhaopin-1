package com.lingyun.manager_cms.service;

import com.lingyun.framework.domain.shop.Member;

import java.util.List;

public interface MemberService {

    /**
     * 后台用户列表查询
     * @param member
     * @return
     */
    public List<Member> findList(Member member);
}
