package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.Energy;
import com.Value.VGREEN.Repository.EnergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemEventListener;

@Service
public class EnergyService {
    @Autowired
    private CountryEmissionService countryEmissionService;
    @Autowired
    private EnergyRepository energyRepository;
    public EnergyService() {

    }
    public double CalculateSum(Energy energy) {
        double EF = countryEmissionService.getEmissionFactorForCountry(energy.getCampany().getCountry());
        double emTele = energy.getTeleworkPourcentage() / 100 * EF / 1000 * 223 * 1.4 * energy.getNbEmployee();
        double emE = energy.getElectricity() * EF / 1000;
        double emG = energy.getGaz() * 0.243 / 1000;
        double emP = energy.getPropane() * 0.263 / 1000;
        double emF = energy.getFuel() * 3.332 / 1000;
        double emC = energy.getCoal() * 0.284 / 1000;
        double emFl = energy.getRefregerant() * 26 / 1000;
        double emGpl = energy.getLpg() * 3.45 / 1000;
        this.energyRepository.save(energy);
        return emTele + emC + emE + emFl + emGpl + emG + emF + emP;
    }
}
