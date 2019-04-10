package com.lingyun.manager_cms.web.controller;

import com.lingyun.api.admin.JobControllerApi;
import com.lingyun.framework.domain.admin.Job;
import com.lingyun.manager_cms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController implements JobControllerApi {

	@Autowired
	private JobService jobService;

	@Override
	public List<Job> queryJob() {
		return jobService.queryJob();
	}

	@Override
	public void deleteJob(Integer id) {
		jobService.deleteJob(id);
	}

	@Override
	public Job queryJobById(Integer id) {
		return jobService.queryJobById(id);
	}

	@Override
	public void editJob(Job job) {
		jobService.editJob(job);
	}
}
