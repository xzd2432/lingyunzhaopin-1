package com.lingyun.service;

import com.lingyun.api.shop.MemberControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ly-service-manage-cms")
public interface MemberService extends MemberControllerApi {
}
