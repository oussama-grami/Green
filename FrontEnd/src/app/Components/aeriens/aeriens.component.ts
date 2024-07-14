import { Component } from '@angular/core';
import { Con2backService } from 'src/app/con2back.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-aeriens',
  templateUrl: './aeriens.component.html',
  styleUrls: ['./aeriens.component.css']
})
export class AeriensComponent {

  depData = {
    nbrArretRetourC: 0,
    nbrArretRetourM :0,
    nbrArretRetourL:0
  }


  result = 0;

  calculer(){
    //this is just for testing purpose !! we have to return the server response
    this.result = (this.depData.nbrArretRetourC + this.depData.nbrArretRetourL + this.depData.nbrArretRetourM)/3;
    return this.result;
  }

  
  constructor(private energy: Con2backService , private router: Router) {}
  evaluateAirTravel() {
    this.router.navigate(["/fret"]); // comment this in case you are running BackEnd
    this.energy.addAirTravelInformation(this.depData).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }
}
