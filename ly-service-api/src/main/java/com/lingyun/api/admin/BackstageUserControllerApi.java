package com.lingyun.api.admin;

import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "后台用户管理接口",description = "提供后台用户的增删改查以及用户付角色角色赋权限")
public interface BackstageUserControllerApi {

    @RequestMapping("/queryBuser")
    @ResponseBody
    List<BackstageUser> queryBuser(BackstageUser backstageUser);

    @RequestMapping("addBackstageUser")
    @ResponseBody
    void addBackstageUser(@RequestBody BackstageUser backstageUser);

    @RequestMapping("/upd")
    @ResponseBody
    BackstageUser queryBuserById(@RequestBody int id);

    @RequestMapping("/updstatus")
    @ResponseBody
    void updstatus(@RequestBody Integer id);

    @RequestMapping("/queryBoutfit")
    @ResponseBody
    List<BackstageOutfit> queryBoutfit();

    @RequestMapping("/updstatus1")
    @ResponseBody
    void updstatus1(@RequestBody Integer id);

    @RequestMapping("/queryBuserjy")
    @ResponseBody
    List<BackstageUser> queryBuserjy(BackstageUser backstageUser);

    @RequestMapping("/updspstatus")
    @ResponseBody
    void updspstatus(@RequestBody Integer id);

    @RequestMapping("/updspstatus1")
    @ResponseBody
    void updspstatus1(@RequestBody Integer id);

    @RequestMapping("/queryBusersp")
    @ResponseBody
    List<BackstageUser> queryBusersp(BackstageUser backstageUser);

    @RequestMapping("updBackstageUser")
    @ResponseBody
    void updBackstageUser(@RequestBody BackstageUser backstageUser);
}
