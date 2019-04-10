package com.lingyun.api.shop;

import com.lingyun.framework.domain.shop.Admin;
import com.lingyun.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "后台用户管理接口", description = "后台用户管理接口，提供用户的增、删、改、查")
public interface AdminControllerApi {

    final String API_PRE = "/shop/admin";
    //分页查询页面
    @GetMapping(API_PRE+"/list")
    @ApiOperation("分页查询后台用户列表")
    public List<Admin> findList();

}
