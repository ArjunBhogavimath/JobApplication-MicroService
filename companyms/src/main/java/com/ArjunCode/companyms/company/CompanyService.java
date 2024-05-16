package com.ArjunCode.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Company updatedCompany, Long id);
    Company getCompanyById();
    boolean deleteCompany(Long id);

    void createCompany(Company company);

    Company getCompany(Long id);
}
