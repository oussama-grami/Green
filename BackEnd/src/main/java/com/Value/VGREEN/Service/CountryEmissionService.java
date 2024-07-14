package com.Value.VGREEN.Service;

import com.Value.VGREEN.Repository.CompanyRespository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class CountryEmissionService {
        private final Map<String, Double> countryEmissionFactors;
        private final CompanyRespository companyRespository;

        public CountryEmissionService(ResourceLoader resourceLoader, CompanyRespository companyRespository) throws IOException {
            Resource resource = new ClassPathResource("emission_factors.json");
            ObjectMapper objectMapper = new ObjectMapper();
            this.countryEmissionFactors = objectMapper.readValue(resource.getInputStream(), Map.class);
            this.companyRespository = companyRespository;
        }

        public Double getEmissionFactorForCountry(String country) {
            return countryEmissionFactors.getOrDefault(country, null);
        }
    }
