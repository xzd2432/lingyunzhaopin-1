package com.lingyun.manager_cms.service.impl;

import com.lingyun.framework.domain.admin.Job;
import com.lingyun.manager_cms.dao.JobMapper;
import com.lingyun.manager_cms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobMapper jobMapper;

	@Override
	public List<Job> queryJob() {
		return jobMapper.queryJob();
	}

	@Override
	public void deleteJob(Integer id) {
		jobMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Job queryJobById(Integer id) {
		return jobMapper.selectByPrimaryKey(id);
	}

	@Override
	public void editJob(Job job) {
		jobMapper.updateByPrimaryKeySelective(job);
	}
}
