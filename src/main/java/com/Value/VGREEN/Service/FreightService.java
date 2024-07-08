package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.Freight;
import com.Value.VGREEN.Repository.FreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreightService {
    @Autowired
    FreightRepository freightRepository;

    public double calculateSum(Freight freight) {
        double emA = freight.getBigAirFreight() * 1.89 / 1000;
        double emA1 = freight.getSmallAirFreight() * 2.1 / 1000;
        double emM = freight.getBigSeaFreight() * 0.0141 / 1000;
        double emM1 = freight.getSmallAirFreight() * 0.0184 / 1000;
        this.freightRepository.save(freight);
        return emA + emA1 + emM + emM1;
    }
}
