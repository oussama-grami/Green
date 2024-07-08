package com.Value.VGREEN.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class rate_of_change_DT_Service {
    private Map<String, Double> TauxDeChangeDt;

    @Autowired
    public rate_of_change_DT_Service(ResourceLoader resourceLoader) throws IOException {
        Resource resource = new ClassPathResource("rate_of_exchange_DT.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TauxDeChangeDt = objectMapper.readValue(resource.getInputStream(), Map.class);
    }

    public Double getRateDt(String year) {
        return TauxDeChangeDt.get(year);
    }

}