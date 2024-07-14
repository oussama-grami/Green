import { Component } from '@angular/core';

@Component({
  selector: 'app-marketplace',
  templateUrl: './marketplace.component.html',
  styleUrls: ['./marketplace.component.css']
})
export class MarketplaceComponent {
  ngOnInit() {
    window.scrollTo(0, 0);
  }
  countryFilters = ["South Africa","Algeria","Angola","Tunisia"]
  typeFilters = ["Trees & Forests","Biodiversity","Renewable energies","Waste management", "Soil management", "Tree planting"]


  countryFiltersCopy: string[] = []
  typeFiltersCopy: string[] = []

  selectedFilter : string[]= []
  countryDisplay = false;
  typeDisplay = false;
  priceDisplay = false;
  certificationDisplay = false;
  mecanismDisplay = false;
  searchTextForCountry: string = ''
  searchTextForType: string = ''
  priceFilter=99
  
  
  projects = [
    { routing: '/details', url: '/assets/img/projet1.png', cost: '2.48', category: 'Trees & Forests', name: 'Tree planting in Testour', flag: '/assets/img/tunisiaFlag.svg' },
    { routing: '/details', url: '/assets/img/projet2.png', cost: '5.52', category: 'Renewable energies', name: 'Solar panels in Casablanca', flag: '/assets/img/marrocoFlag.svg' },
    { routing: '/details', url: '/assets/img/projet3.png', cost: '2.24', category: 'Biodiversity', name: 'Mangrove protection in Senegal', flag: '/assets/img/senegalFlag.svg' },
    { routing: '/details', url: '/assets/img/projet4.png', cost: '3.5', category: 'Biodiversity', name: 'Protection of Posidonia meadows in the Sahel', flag: '/assets/img/tunisiaFlag.svg' },
    { routing: '/details', url: '/assets/img/projet5.png', cost: '7.5', category: 'Trees & Forests', name: 'Forestry project in Madagascar', flag: '/assets/img/southAfricaFlag.svg' },
    { routing: '/details', url: '/assets/img/projet6.png', cost: '2.25', category: 'Renewable energies', name: 'Wind farm in Tunisia', flag: '/assets/img/tunisiaFlag.svg' },
    { routing: '/details', url: '/assets/img/projet7.png', cost: '2.48', category: 'Tree planting', name: 'Tree planting in Testour', flag: '/assets/img/tunisiaFlag.svg' },
    { routing: '/details', url: '/assets/img/projet8.png', cost: '5.52', category: 'Renewable energies', name: 'Solar panels in Casablanca', flag: '/assets/img/marrocoFlag.svg' },
    { routing: '/details', url: '/assets/img/projet9.png', cost: '2.24', category: 'Biodiversity', name: 'Mangrove protection in Senegal', flag: '/assets/img/senegalFlag.svg' }
  ];



  displayCountryFilter(){
    this.countryFiltersCopy= this.countryFilters;
    this.countryDisplay = ! this.countryDisplay;
    if(this.countryDisplay == false){
      this.searchTextForCountry=""
      
    }
  }
  displayTypeFilter(){
    this.typeFiltersCopy= this.typeFilters;
    this.typeDisplay = ! this.typeDisplay;
    if(this.typeDisplay == false){
      this.searchTextForType=""
      
    }
  }
  displayPriceFilter(){
    this.priceDisplay = ! this.priceDisplay;
  }
  displayCertificationFilter(){
    this.certificationDisplay = ! this.certificationDisplay;
  }
  displayMecanismFilter(){
    this.mecanismDisplay = ! this.mecanismDisplay;
  }
  selectFilter(filter: string){
    let index = this.selectedFilter.indexOf(filter)
    if(index == -1){
      this.selectedFilter.push(filter);
    }
    else{
      this.selectedFilter.splice(index,1);
    }
    
    
  }
  clearFilters(){
    this.selectedFilter = []
    this.countryDisplay = false;
    this.typeDisplay = false;
    this.priceDisplay = false;
    this.certificationDisplay = false;
    this.mecanismDisplay = false;   
  }

  removeFilter(filter : string){
    let index = this.selectedFilter.indexOf(filter);
    if(index !== -1){
      this.selectedFilter.splice(index,1);
    }
  }

  filterPerCountry() {
    if (this.searchTextForCountry != '') {
      this.countryFiltersCopy  = []
      this.countryFilters.forEach(filter => {
        if(filter.toLowerCase().includes(this.searchTextForCountry.toLowerCase())){
          this.countryFiltersCopy.push(filter)
        }
      })}
  
    else
      this.countryFiltersCopy = this.countryFilters
  }
  filterPerType() {
    if (this.searchTextForType != '') {
      this.typeFiltersCopy  = []
      this.typeFilters.forEach(filter => {
        if(filter.toLowerCase().includes(this.searchTextForType.toLowerCase())){
          this.typeFiltersCopy.push(filter)
        }
      })}
  
    else
      this.typeFiltersCopy = this.typeFilters
  }

}
