import {Component, OnInit} from '@angular/core';
import {Esg} from "../../Models/esg";
import {EsgServiceService} from "../../Service/esg-service.service";
import {Categorie} from "../../enumerations/Categorie";
import {Partie} from "../../enumerations/Partie";
import {ScoreService} from "../../Service/score.service";
interface Option {
  text: string;
  isSelected: boolean;
  score7: number; // Add the 'score' property to the Option interface
}
@Component({
  selector: 'app-social2',
  templateUrl: './social2.component.html',
  styleUrls: ['./social2.component.css']
})
export class Social2Component implements OnInit{
  esg: Esg = new Esg();
  options: Option[] = [];
  vl!: number;
  choiceSelected = false
  warnUser = false
  constructor(private esgService : EsgServiceService,private scService: ScoreService) {}
  ngOnInit() {
    this.esgService.getEsg(Categorie.Social, Partie.Three).subscribe(
      (data: Esg) => {
        this.esg = data;

        this.options = [
          { text: this.esg.q1, isSelected: false, score7: 0 },
          { text: this.esg.q2, isSelected: false, score7: 1 },
          { text: this.esg.q3, isSelected: false, score7: 2 },
          { text: this.esg.q4, isSelected: false, score7: 3 },
          { text: this.esg.q5, isSelected: false, score7: 4 },
        ];
      },
      (error) => {
        console.error(error);
      }
    );
  }
  onDivClick(selectedOption: Option): void {
    this.options.forEach((option) => {
      option.isSelected = option === selectedOption;
    });
    this.vl=selectedOption.score7;
    this.choiceSelected = true

  }
  addScore(){
    if (!this.vl) {
      this.vl = 0;
    }
    this.scService.addScore(this.vl,1,2023,this.esg.id)
  }
  warning(){
    this.warnUser=true
  }
}
