package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.OfficeSupplies;
import com.Value.VGREEN.Repository.OfficeSuppliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeSuppliesService {
    @Autowired
    private OfficeSuppliesRepository officeSuppliesRepository;
    @Autowired
    rate_of_change_DT_Service tDT;
    @Autowired
    rate_of_change_DLL_Service tDll;
    public double calculateSum(OfficeSupplies officeSupplies) {
        double emP = 0.0;
        double emF = 0.0;
        if (officeSupplies.getUnit1() != null) {
            switch (officeSupplies.getUnit2()) {
                case DT:
                    emP = officeSupplies.getPaperExpences() * 0.16 / tDT.getRateDt(Integer.toString(officeSupplies.getYear())) / 1000;
                    break;
                case Dollar:
                    emP = officeSupplies.getPaperExpences() * 0.16 * tDll.getRateDollar(Integer.toString(officeSupplies.getYear())) / 1000;
                    break;
                case Euro:
                    emP = officeSupplies.getPaperExpences() * 0.16 / 1000;
                    break;
            }
        }
        if (officeSupplies.getUnit2() != null) {
            switch (officeSupplies.getUnit2()) {
                case DT:
                    emF = (officeSupplies.getFournitureExpences() * 0.367 / tDT.getRateDt(Integer.toString(officeSupplies.getYear()))) / 1000;
                    break;
                case Dollar:
                    emF = officeSupplies.getFournitureExpences() * 0.367 * tDll.getRateDollar(Integer.toString(officeSupplies.getYear())) / 1000;
                    break;
                case Euro:
                    emF = officeSupplies.getFournitureExpences()* 0.367 / 1000;
                    break;
            }
        }
        this.officeSuppliesRepository.save(officeSupplies);
        return emF + emP;
    }
}
