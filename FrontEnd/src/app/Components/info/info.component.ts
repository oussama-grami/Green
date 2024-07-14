import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Con2backService } from 'src/app/con2back.service';
@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent {
  ngOnInit() {
    window.scrollTo(0, 0);
  }

  // Fix the company Model !
  company = {
    name : "Company name",
    beginDate : "jj/mm/aaaa",
    endDate: "jj/mm/aaaa",
    country: "Tunisia",
    sector: "Bank / Insurance"
  }

  countries: string[] = ['Algeria', 'Canada', 'France', 'Marroco', 'Saudi Arabia', 'Tunisia', 'UAE', 'UK', 'USA'];
  sectors: string[] = ['Bank / Insurance', 'Trade / Trading / Distribution', 'Electronics / Electrical', 'Publishing/ Communication/ Multimedia'];


  constructor(private companyService: Con2backService , private router: Router) {}
  companyadd() {
    this.router.navigate(["/energie"]); // comment this in case you are running BackEnd
    this.companyService.addCompany(this.company).subscribe(
      res=>{
        // this.router.navigate(["/energie"]); uncomment this in case you are running the BackEnd !!
      },
      err=>{
        console.log(err);
      })
  }


}


