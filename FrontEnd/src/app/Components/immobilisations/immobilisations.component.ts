import { Component } from '@angular/core';
import {Energie} from "../../Models/energie";
import {EnergieService} from "../../Service/energie.service";
import Swal from "sweetalert2";
import {Immobilisation} from "../../Models/immobilisation";
import {ImmobilisationService} from "../../Service/immobilisation.service";
import { Router } from '@angular/router';
import { Con2backService } from 'src/app/con2back.service';

@Component({
  selector: 'app-immobilisations',
  templateUrl: './immobilisations.component.html',
  styleUrls: ['./immobilisations.component.css']
})
export class ImmobilisationsComponent {
  immeData = {
    surface :"Built area (m²)",
    nbVoituresLegers:"Light Duty Vehicles (vehicles)", 
    nbVoituresUtilitaires :"Commercial Vehicles (vehicles)",
    nbVoituresLourds :"Heavy Vehicles (Vehicle)",
    nbPostes :"Desktop computers (Unit)",
    nbPc :"Laptops (Unit)",
    nbImprimantesIndiv :"Individual Printers (Unit)", 
    nbImprimantesMilti :"Multifunction Printers (Unit)",
    nbServeurs :"Servers (Unit)",
    nbEcran: "Flat Panel Screens (Unit)"
  }

  ngOnInit() {
    window.scrollTo(0, 0);
  }
  constructor(private immobilisationData: Con2backService , private router: Router) {}
  calcimmob() {
    this.router.navigate(["/resultat"]); // comment this in case you are running BackEnd
    this.immobilisationData.addFixedAssetsData(this.immeData).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }
}
