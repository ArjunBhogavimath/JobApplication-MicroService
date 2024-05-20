package com.ArjunCode.jobms.job.mapper;

import com.ArjunCode.jobms.job.Job;
import com.ArjunCode.jobms.job.dto.JobDTO;
import com.ArjunCode.jobms.job.external.Company;
import com.ArjunCode.jobms.job.external.Review;

import java.util.List;

public class JobMapper {

    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews){
        JobDTO jobDTO = new JobDTO();
        jobDTO.setCompany(company);
        jobDTO.setId(job.getId());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setReview(reviews);

        return jobDTO;
    }
}
