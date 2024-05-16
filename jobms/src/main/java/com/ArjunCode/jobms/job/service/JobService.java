package com.ArjunCode.jobms.job.service;

import com.ArjunCode.jobms.job.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Job job, Long id);
}
