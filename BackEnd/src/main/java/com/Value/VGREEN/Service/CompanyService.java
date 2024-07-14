package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.Company;
import com.Value.VGREEN.Repository.CompanyRespository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private CompanyRespository companyRepository;
    public CompanyService(CompanyRespository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public String addCompany(Company company){
        this.companyRepository.save(company);
        return "company added successfully";
    }
}
