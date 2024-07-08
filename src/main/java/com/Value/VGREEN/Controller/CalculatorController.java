package com.Value.VGREEN.Controller;

import com.Value.VGREEN.Entity.*;
import com.Value.VGREEN.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EnergyService energyService;
    @Autowired
    private CountryEmissionService countryEmissionService;
    @Autowired
    private FuelConsumptionService fuelConsumptionService;
    @Autowired
    private AirTravelService airTravelService;
    @Autowired
    private OfficeSuppliesService officeSuppliesService;
    @Autowired
    private FreightService freightService;
    @Autowired
    private FixedAssetsService fixedAssetsService;
    @PostMapping("add/company")
    public String addCompany(@RequestBody Company company) {
        String message = companyService.addCompany(company);
        return message;
    }
    @PostMapping("calculate/energy")
    public double calculateEnergy(@RequestBody Energy energy) {
        return this.energyService.CalculateSum(energy);
    }
    @GetMapping("test")
    public double test(@RequestParam String country) {
        return this.countryEmissionService.getEmissionFactorForCountry(country);
    }
    @PostMapping("calculate/fuelConsumption")
    public double calculateFuelConsumption(@RequestBody FuelConsumption fuelConsumption) {
        return this.fuelConsumptionService.CalculateSum(fuelConsumption);
    }
    @PostMapping("calculate/airTravel")
    public double calculateAirTravel(@RequestBody AirTravel airTravel) {
        return this.airTravelService.CalculateSum(airTravel);
    }
    @PostMapping("calculate/officeSupplies")
    public double calculateOfficeSupplies(@RequestBody OfficeSupplies officeSupplies) {
        return this.officeSuppliesService.calculateSum(officeSupplies);
    }
    @PostMapping("calculate/freight")
    public double calculateFreight(@RequestBody Freight freight) {
        return this.freightService.calculateSum(freight);
    }
    @PostMapping("calculate/fixedAssets")
    public double calculateFixedAssets(@RequestBody FixedAssets fixedAssets) {
        return this.fixedAssetsService.CalculateSum(fixedAssets);
    }
    /*
    @GetMapping("calculate/all")
    public double calculateAll(@RequestParam int companyId) {
        return 0;
    }
     */
}
