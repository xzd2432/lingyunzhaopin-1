package com.lingyun.web.controller;


import com.lingyun.framework.domain.admin.Job;
import com.lingyun.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;

	@RequestMapping("/toJob")
	public String toJob(){
		return "job/index";
	}
	@RequestMapping("/deleteJob")
	@ResponseBody
	public void deleteJob(Integer id){
		jobService.deleteJob(id);
	}
	@RequestMapping("/toEditJob")
	public String toEditJob(Model model,Integer id){
		Job job = jobService.queryJobById(id);
		model.addAttribute("job",job);
		return "job/editJob";
	}
	@RequestMapping("editJob")
	@ResponseBody
	public void editJob(Job job){
		jobService.editJob(job);
	}
	@RequestMapping("/queryJob")
	@ResponseBody
	public List<Job> queryJob(){
		return jobService.queryJob();
	}
}
