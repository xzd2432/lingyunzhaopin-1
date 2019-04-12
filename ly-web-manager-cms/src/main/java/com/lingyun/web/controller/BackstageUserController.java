package com.lingyun.web.controller;

import com.lingyun.framework.domain.admin.BackstageOutfit;
import com.lingyun.framework.domain.admin.BackstageUser;
import com.lingyun.framework.utils.IpToolUtis;
import com.lingyun.service.BackstageUserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.lingyun.framework.utils.IpToolUtis.getLinuxLocalIp;

@Controller
@RequestMapping("/back")
public class BackstageUserController {

    @Autowired
    private BackstageUserService backstageUserService;

    @RequestMapping("/showUser")
    public String showUser() {
        return "houtaiuser/showuser";
    }

    @RequestMapping("/showUser2")
    public String showUser2() {
        return "houtaiuser/showuserjy";
    }

    @RequestMapping("/showUser3")
    public String showUser3() {
        return "houtaiuser/showusersp";
    }

    @RequestMapping("/queryBuser")
    @ResponseBody
    public List<BackstageUser> queryBuser(BackstageUser backstageUser) {

        return backstageUserService.queryBuser(backstageUser);
    }
    @RequestMapping("/queryBuserjy")
    @ResponseBody
    public List<BackstageUser> queryBuserjy(BackstageUser backstageUser) {

        return backstageUserService.queryBuserjy(backstageUser);
    }

    @RequestMapping("/queryBusersp")
    @ResponseBody
    public List<BackstageUser> queryBusersp(BackstageUser backstageUser) {

        return backstageUserService.queryBusersp(backstageUser);
    }

    @RequestMapping("/upd")
    public String upd(int id,Model model) {
        BackstageUser backstageUser=backstageUserService.queryBuserById(id);
        List<BackstageOutfit> backstageOutfits=backstageUserService.queryBoutfit();
        model.addAttribute("user",backstageUser);
        model.addAttribute("outfit",backstageOutfits);
        return "houtaiuser/updBackstageUser";
    }

    @RequestMapping("/addBackstageUser")
    @ResponseBody
    public void addBackstageUser(BackstageUser backstageUser, HttpServletRequest request) {
        String ip = IpToolUtis.getLinuxLocalIp();
            backstageUser.setBuip(ip);
            backstageUserService.addBackstageUser(backstageUser);
    }

    @RequestMapping("/updBackstageUser")
    @ResponseBody
    public void updBackstageUser(BackstageUser backstageUser) {
        backstageUserService.updBackstageUser(backstageUser);
    }

    @RequestMapping("upImg")
    @ResponseBody
    public String upImg(MultipartFile artImg,HttpServletRequest req) throws Exception{
        //获取原文件名称
        String fileName = artImg.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = req.getSession().getServletContext().getRealPath("/")+
                "upload/";
        File file = new File(folderPath);
        //	        该目录是否已经存在
        if(!file.exists()){
            //   创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(artImg.getBytes());
        fos.flush();
        fos.close();
        return  "/upload/"+onlyFileName;
    }

    /*正常转禁用*/
    @RequestMapping("/updstatus")
    @ResponseBody
    public void updstatus(Integer id){
        backstageUserService.updstatus(id);
    }

    /*禁用转正常*/
    @RequestMapping("/updstatus1")
    @ResponseBody
    public void updstatus1(Integer id){
        backstageUserService.updstatus1(id);
    }

    /*通过审批*/
    @RequestMapping("/updspstatus")
    @ResponseBody
    public void updspstatus(Integer id){
        backstageUserService.updspstatus(id);
    }

    /*未通过审批*/
    @RequestMapping("/updspstatus1")
    @ResponseBody
    public void updspstatus1(Integer id){
        backstageUserService.updspstatus1(id);
    }

    @RequestMapping("/queryOutfit")
    public String queryOutfit(Model model){
        List<BackstageOutfit> list=backstageUserService.queryBoutfit();
        model.addAttribute("outfit",list);
        return "houtaiuser/addBackstageUser";

    }

}
