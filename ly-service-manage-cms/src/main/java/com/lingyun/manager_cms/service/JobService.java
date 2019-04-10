package com.lingyun.manager_cms.service;

import com.lingyun.framework.domain.admin.Job;

import java.util.List;

public interface JobService {
	List<Job> queryJob();

	void deleteJob(Integer id);

	Job queryJobById(Integer id);

	void editJob(Job job);
}
