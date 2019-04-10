package com.lingyun.service;

import com.lingyun.api.admin.JobControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "LY-SERVICE-MANAGE-CMS")
public interface JobService extends JobControllerApi {
}
