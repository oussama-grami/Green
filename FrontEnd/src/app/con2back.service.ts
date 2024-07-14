import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Con2backService {

  private baseUrl = 'http://localhost:8080/api/calculator';

  constructor( private http : HttpClient) { }

  // Adding Company Form 1/7
  addCompany(company: any){
    console.log("Company added sussefully");
    return this.http.post(this.baseUrl + "/add/company", company);
  }
  
  // Every post methods returns a float in its response that value should be used in the calculate function 
  // every returned value should be stored in an array Results
  // these values are required in the "resultat-carbone" component

  // Energy 2/7
  calculateEnergy(energy: any){
    return this.http.post(this.baseUrl + "/calculate/energy", energy);
  }  

  // Carburant 3/7
  calculateCarburant(cardata: any){
    return this.http.post(this.baseUrl + "/calculate/fuelConsumption", cardata);
  }

  // Buisness Air Travel 4/7
  addAirTravelInformation(deplacemet: any){
    return this.http.post(this.baseUrl + "/calculate/airTravel", deplacemet);
  }

  // Freight 5/7
  calculateFreightConsumption(fret: any){
    return this.http.post(this.baseUrl + "/calculate/freight", fret);
  }  

  // Cons 6/7
  calcConsumptions(consData: any){
    return this.http.post(this.baseUrl + "/calculate/officeSupplies", consData);
  }

  // Office 7/7
  addFixedAssetsData(immeData: any){
    return this.http.post(this.baseUrl + "calculate/fixedAssets", immeData);
  }
}
