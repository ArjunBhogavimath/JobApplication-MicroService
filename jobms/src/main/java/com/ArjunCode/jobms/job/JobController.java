package com.ArjunCode.jobms.job;

import com.ArjunCode.jobms.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    //this is done by springboot at run time

    //endpoint to return list of Jobs
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job =  jobService.getJobById(id);
        if(job != null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean isdeleted = jobService.deleteJobById(id);
        if(isdeleted) return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Deletion Failed",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@RequestBody Job job, @PathVariable Long id){
        boolean isUpdated = jobService.updateJobById(job, id);
        if(isUpdated) return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job Failed to Update",HttpStatus.NOT_FOUND);
    }
}
