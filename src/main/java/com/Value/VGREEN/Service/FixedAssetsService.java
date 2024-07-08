package com.Value.VGREEN.Service;

import com.Value.VGREEN.Entity.FixedAssets;
import com.Value.VGREEN.Repository.FixedAssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FixedAssetsService {
    @Autowired
    private FixedAssetsRepository fixedAssetsRepository;
    public double CalculateSum(FixedAssets fixedAssets) {
        double emEc=(fixedAssets.getNbPanelScreen()/3.0)*205/1000;
        double emPc=(fixedAssets.getNbLaptps()/3.0)*156/1000;
        double emSc=(fixedAssets.getBuiltArea()/20)*650/1000;
        double emImpI=(fixedAssets.getNbIndividualPrinter()/3.0)*88.2/1000;
        double emImpM=(fixedAssets.getNbMultifunctionPrinter()/3.0)*197/1000;
        double emPos=(fixedAssets.getNbDesktop()/3.0)*678/1000;
        double emSer=(fixedAssets.getNbServers()/3.0)*600/1000;
        int emVle=fixedAssets.getLightVehicule()*642/1000;
        int emVlo=fixedAssets.getHeavyVehicule()*4492/1000;
        int emVul=fixedAssets.getCommercialVehicule()*1220/1000;
        this.fixedAssetsRepository.save(fixedAssets);
        return emEc+emPc+emSc+emImpI+emImpM+emPos+emSer+emVle+emVlo+emVul;
    }
}
