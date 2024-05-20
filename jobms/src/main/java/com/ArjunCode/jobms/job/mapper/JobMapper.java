package com.ArjunCode.jobms.job.mapper;

import com.ArjunCode.jobms.job.Job;
import com.ArjunCode.jobms.job.dto.JobWithCompanyDTO;
import com.ArjunCode.jobms.job.external.Company;

public class JobMapper {

    public static JobWithCompanyDTO mapToJobWithCompanyDTO(Job job, Company company){
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());

        return jobWithCompanyDTO;
    }
}
