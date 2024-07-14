import { Component } from '@angular/core';
import {Unite} from "../../enumerations/unite";
import {TypeCarburant} from "../../enumerations/typeCarburant";
import { Con2backService } from 'src/app/con2back.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carburant',
  templateUrl: './carburant.component.html',
  styleUrls: ['./carburant.component.css']
})
export class CarburantComponent {
  ngOnInit() {
    window.scrollTo(0, 0);
    
  }
  
  carData = {
    essence : "Gasoline (Litres)",
    diesel : "Diesel (Litres)",
    gpl : "LPG (Litres)",
    kilometrage :"Driven distance (Km)" ,
    efficacite : "Vehicule fuel efficiency (L/100Km)",
    typeCarburant : "GPL", 
  };
  
  constructor(private energy: Con2backService , private router: Router) {}
  calculateCarConsumption() {
    this.router.navigate(["/aer"]); // comment this in case you are running BackEnd
    this.energy.calculateCarburant(this.carData).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }

  protected readonly Unite = Unite;
  protected readonly TypeCarburant = TypeCarburant;
}
