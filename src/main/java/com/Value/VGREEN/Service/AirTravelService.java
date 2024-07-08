package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.AirTravel;
import com.Value.VGREEN.Repository.AirTravelRepository;
import org.springframework.stereotype.Service;

@Service
public class AirTravelService {
    private AirTravelRepository airTravelRepository;
    public AirTravelService(AirTravelRepository airTravelRepository) {
        this.airTravelRepository = airTravelRepository;
    }
    public double CalculateSum(AirTravel airTravel) {
        double emDEPC=airTravel.getShortAirTravel()*0.239*1500/1000;
        double emDEPM=airTravel.getMeduimAirTravel()*0.256*4500/1000;
        double emDEPL=airTravel.getLongAirTravel()*0.216*6000/1000;
        this.airTravelRepository.save(airTravel);
        return emDEPC+emDEPM+emDEPL;
    }
}
