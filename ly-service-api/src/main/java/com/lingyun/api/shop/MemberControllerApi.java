package com.lingyun.api.shop;

import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.framework.domain.shop.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "会员管理接口", description = "会员管理接口，提供会员的增、删、改、查")
public interface MemberControllerApi {
    final String API_PRE = "/shop/member";
    //分页查询会员
    @RequestMapping(API_PRE+"/list")
    @ApiOperation("分页查询会员列表")
    public List<Member> findList(Member member);

}
