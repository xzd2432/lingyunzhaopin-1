package com.lingyun.api.admin;

import com.lingyun.framework.domain.admin.Info;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api(value = "会员管理接口", description = "会员管理接口，提供会员的增、删、改、查")
public interface InfoControllerApi {
    @RequestMapping("/query")
    List<Info> query();

    @RequestMapping("/selete")
    Info selete(@RequestBody Integer infoid);

    @RequestMapping("/del")
    void del(@RequestBody Integer infoid);

    @RequestMapping("/delte")
    void delte(@RequestBody String ids);
}
