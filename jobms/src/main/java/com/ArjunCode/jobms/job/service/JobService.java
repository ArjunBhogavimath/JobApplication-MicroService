package com.ArjunCode.jobms.job.service;

import com.ArjunCode.jobms.job.Job;
import com.ArjunCode.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Job job, Long id);
}
