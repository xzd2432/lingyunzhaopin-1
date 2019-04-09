package com.lingyun.service;

import com.lingyun.api.shop.AdminControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ly-service-manage-cms")
public interface AdminService extends AdminControllerApi{
}
