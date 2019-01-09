import { Component, OnInit } from '@angular/core';
import { Budget } from 'app/models/budget';
import { BudgetLine } from 'app/models/budgetline';
import { Exercice } from 'app/models/exercice';
import { BudgetService } from '../../budget.service';
import { Engagement } from 'app/models/engagement';
import { LigneEngagement } from 'app/models/ligne-engagement';

@Component({
  selector: 'app-engagement',
  templateUrl: './engagement.component.html',
  styleUrls: ['./engagement.component.scss']
})
export class EngagementComponent implements OnInit {
  
  budget: Budget = new Budget();
  budgetLines: BudgetLine[] = new Array();
  budgetLine: BudgetLine = new BudgetLine();
  engagementForm:Engagement=new Engagement();
  ligneEngagement:LigneEngagement=new LigneEngagement();
  exercice: Exercice = new Exercice();
  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
      this.getExercice();
      this.getBudget();   
     this.getBudgetLines();

  }
    
    getExercice() {
        this.budgetService.getExercice()
        .subscribe(data => {
            if(data){
                this.exercice=data;
            }
        });
    }
    
  
    
    getBudget() {
        this.budgetService.getBudget()
        .subscribe(data => {
            if(data){
                this.budget=data;
                this.exercice=data.exercice;
                this.getBudgetLines();
                this.initEngagement();
            } else {
                this.budget = {name:'', exercice:this.exercice};   
            }
        });
    }
    
    getBudgetLines() {
        this.budgetService.getBudgetLines(this.budget.name)
        .subscribe(data => {
            if(data){
                this.budgetLines=data;
            }
        });
    }
    enregistrer(){
        this.budgetService.saveEngagement(this.engagementForm)
        .subscribe(data => {
            if(data){
                this.ligneEngagement=data;
            }
        });
    } 

    initEngagement(){
        this.ligneEngagement={budgetLine:0,budget:this.budget.name,libelle:",",prevu:0,engagee:0,restant:0}
    }
    
   
    

}
