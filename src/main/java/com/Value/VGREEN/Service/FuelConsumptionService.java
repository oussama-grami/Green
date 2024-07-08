package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.FuelConsumption;
import com.Value.VGREEN.Repository.FuelConsumptionRepository;
import org.springframework.stereotype.Service;

@Service
public class FuelConsumptionService {
    private FuelConsumptionRepository fuelConsumptionRepository;
    public FuelConsumptionService(FuelConsumptionRepository fuelConsumptionRepository) {
        this.fuelConsumptionRepository = fuelConsumptionRepository;
    }
    public double CalculateSum(FuelConsumption fuelConsumption) {
        double emEK=0.0;
        double emD=fuelConsumption.getDiesel()*2.7/1000;
        double emG=fuelConsumption.getLpg()*3.45/1000;
        double emE=fuelConsumption.getGasoline()*2.7/1000;
        if (fuelConsumption.getFuelType() != null) {
            switch (fuelConsumption.getFuelType()) {
                case Gpl:
                    emEK = fuelConsumption.getDrivenDistance() * fuelConsumption.getEfficiency() * 3.45 / 1000;
                    break;
                case Diesel:
                    emEK = fuelConsumption.getDrivenDistance() * fuelConsumption.getEfficiency() * 2.7 / 1000;
                    break;
                case Essence:
                    emEK = fuelConsumption.getDrivenDistance() * fuelConsumption.getEfficiency() * 2.7 / 1000;
            }
        }
        this.fuelConsumptionRepository.save(fuelConsumption);
        return emD+emE+emG+emEK;
    }
}
