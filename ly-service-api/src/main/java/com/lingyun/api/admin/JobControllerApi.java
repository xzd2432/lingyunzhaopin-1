package com.lingyun.api.admin;

import com.lingyun.framework.domain.admin.Job;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "职位管理接口",description = "提供职位的删，改查")
public interface JobControllerApi {

	final String API_PRE = "/admin/job";
	@RequestMapping(API_PRE+"/queryJob")
	public List<Job> queryJob();

	@RequestMapping(API_PRE+"/deleteJob")
	public void deleteJob(@RequestParam(value = "id") Integer id);

	@RequestMapping(API_PRE+"/queryJobById")
	public Job queryJobById(@RequestParam(value = "id") Integer id );

	@RequestMapping(API_PRE+"/editJob")
	public void editJob(Job job);
}
