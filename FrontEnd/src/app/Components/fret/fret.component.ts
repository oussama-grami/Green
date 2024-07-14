import { Component } from '@angular/core';
import {Immobilisation} from "../../Models/immobilisation";
import {ImmobilisationService} from "../../Service/immobilisation.service";
import Swal from "sweetalert2";
import {Fret} from "../../Models/fret";
import {FretService} from "../../Service/fret.service";
import { Con2backService } from 'src/app/con2back.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fret',
  templateUrl: './fret.component.html',
  styleUrls: ['./fret.component.css']
})
export class FretComponent {
  fData = {
    fretAerien:"",
    fretAerien1:"",
    fretMaritme:"",
    fretMaritme1:""
  }

  constructor(private energy: Con2backService , private router: Router) {}
  calculateEnergy() {
    this.router.navigate(["/cons"]); // comment this in case you are running BackEnd
    this.energy.calculateFreightConsumption(this.fData).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }
}
