package com.ArjunCode.jobms.job.clients;

import com.ArjunCode.jobms.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE",
            url = "${company-service.url}") //to configure this as feign client
public interface CompanyClient {

    //this will replace restTemplate
    //and this will call company service endpoint, so we need to mention the url and get mapping
    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);
}
//Feign uses ribbon as Load balancer.