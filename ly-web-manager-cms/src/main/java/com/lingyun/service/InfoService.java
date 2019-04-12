package com.lingyun.service;

import com.lingyun.api.admin.InfoControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "ly-service-manage-cms")
public interface InfoService extends InfoControllerApi{
}
