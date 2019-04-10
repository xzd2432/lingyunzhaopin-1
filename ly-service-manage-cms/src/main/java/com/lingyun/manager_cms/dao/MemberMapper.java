package com.lingyun.manager_cms.dao;

import com.lingyun.framework.domain.shop.Member;

import java.util.List;

public interface MemberMapper {

    /**
     * 会员列表查询
     * @param member
     * @return
     */
    public List<Member> findList(Member member);
}