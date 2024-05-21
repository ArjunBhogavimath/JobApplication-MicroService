package com.ArjunCode.jobms.job.service;


import com.ArjunCode.jobms.job.Job;
import com.ArjunCode.jobms.job.JobRepository;
import com.ArjunCode.jobms.job.clients.CompanyClient;
import com.ArjunCode.jobms.job.clients.ReviewClient;
import com.ArjunCode.jobms.job.dto.JobDTO;
import com.ArjunCode.jobms.job.external.Company;
import com.ArjunCode.jobms.job.external.Review;
import com.ArjunCode.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

   // private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    private CompanyClient companyClient;

    private ReviewClient reviewClient;

    public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs =  jobRepository.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobDTO convertToDTO(Job job) {
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());

        JobDTO jobDTO = JobMapper.mapToJobWithCompanyDTO(job,company, reviews);
        return jobDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
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
