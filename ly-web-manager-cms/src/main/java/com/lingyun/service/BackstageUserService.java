package com.lingyun.service;

import com.lingyun.api.admin.BackstageUserControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ly-service-manage-cms")
public interface BackstageUserService extends BackstageUserControllerApi {

}
