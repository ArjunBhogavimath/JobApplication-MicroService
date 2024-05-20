package com.ArjunCode.jobms.job.service;


import com.ArjunCode.jobms.job.Job;
import com.ArjunCode.jobms.job.JobRepository;
import com.ArjunCode.jobms.job.dto.JobWithCompanyDTO;
import com.ArjunCode.jobms.job.external.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

   // private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Job> jobs =  jobRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobWithCompanyDTO convertToDTO(Job job) {
        //RestTemplate restTemplate = new RestTemplate();
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setJob(job);
        Company company = restTemplate.getForObject("http://COMPANY-SERVICE:8081/companies/" + job.getCompanyId(), Company.class);
        jobWithCompanyDTO.setCompany(company);
        return jobWithCompanyDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for (Job job : jobs){
//            if(job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        return jobs.removeIf(job -> job.getId().equals(id));
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Job job, Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job1 = jobOptional.get();
            job1.setDescription(job.getDescription());
            job1.setLocation(job.getLocation());
            job1.setTitle(job.getTitle());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setMinSalary(job.getMinSalary());
            jobRepository.save(job1);
            return true;
        }
        return false;
    }
}
