import { Component } from '@angular/core';
import {EnergieService} from "../../Service/energie.service";
import * as sweetalert2 from "sweetalert2";
import Swal from "sweetalert2";
import {Energie} from "../../Models/energie";
import { Con2backService } from 'src/app/con2back.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-energie',
  templateUrl: './energie.component.html',
  styleUrls: ['./energie.component.css']
})
export class EnergieComponent {
  ngOnInit() {
    window.scrollTo(0, 0);
  }

  energieData = {
    nbEmployee: "number of employees",
    pourcentageTeleTravail: "% Telework",
    electricite: "Electricity (KWh)",
    gaz: "Natural gas (KWh)",
    propane: "Propane (Litres)",
    fioul: "Fuel (Litres)",
    charbon: "Coal (Tons)",
    fluideFrig: "Refrigerant (Kg)",
    gpl: "GPL (Litres)",
  }


  constructor(private energy: Con2backService , private router: Router) {}
  calculateEnergy() {
    this.router.navigate(["/car"]); // comment this in case you are running BackEnd
    this.energy.calculateEnergy(this.energieData).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }
}
