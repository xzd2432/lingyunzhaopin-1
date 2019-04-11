package com.lingyun.web.controller;

import com.lingyun.framework.domain.admin.Info;
import com.lingyun.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;


    @RequestMapping("/query")
    private ModelAndView query(){
        ModelAndView mv = new ModelAndView();
        List<Info> info = infoService.query();
        mv.addObject(info);
        mv.setViewName("info/infoshow");
        return mv;
    }

    @RequestMapping("/infoshow")
    @ResponseBody
    private List<Info> info(){
        return infoService.query();
    }

    @RequestMapping("/infoquery")
    private String infoquery(){
        return "/info/infoshow";
    }
    @RequestMapping("/selete")
    private String selete(Info info, Model model){
        Info infos = infoService.selete(info.getInfoid());
        model.addAttribute("i",infos);
        return "infoshow";
    }

    @RequestMapping("/del")
    private void del(Info info){
        infoService.del(info.getInfoid());
    }

    @RequestMapping("/delte")
    private void delte(String ids){
        infoService.delte(ids);
    }

}
