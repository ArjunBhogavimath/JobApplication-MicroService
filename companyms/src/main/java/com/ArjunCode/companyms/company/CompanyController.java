package com.ArjunCode.companyms.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompany(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompany(id);
        if(company != null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany( @RequestBody Company company, @PathVariable Long id){
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany( @PathVariable Long id){
        boolean isDeleted = companyService.deleteCompany(id);
        if(isDeleted){
            return new ResponseEntity<>("Company Deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to delete company", HttpStatus.NOT_FOUND);
    }
}
