import { Component, OnInit } from '@angular/core';

import { Budget } from 'app/models/budget';
import { BudgetLine } from 'app/models/budgetline';
import { PlanLine } from 'app/models/planline';
import { ConfigParam } from 'app/models/configparam';
import { Exercice } from 'app/models/exercice';

import { BudgetService } from '../budget.service';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.scss']
})
export class BudgetComponent implements OnInit {
  
  budget: Budget = new Budget();
  budgetLines: BudgetLine[] = new Array();
  budgetLine: BudgetLine = new BudgetLine();
  planLines: PlanLine[] = new Array();
  selectedLine: PlanLine = new PlanLine();
  exercice: Exercice = new Exercice();
  plan: ConfigParam = new ConfigParam();
  money: ConfigParam = new ConfigParam();
  planKey: string = 'config.budget.plan.plan';
  moneyKey: string = 'config.budget.money.ref.ref';

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
      this.getExercice();
      this.getPlan();
      this.getBudget();
      this.getMoneyRef();
//      this.getBudgetLines();
//      this.getPlanLines();
  }
    
    getExercice() {
        this.budgetService.getExercice()
        .subscribe(data => {
            if(data){
                this.exercice=data;
            }
        });
    }
    
    getPlan() {
        this.budgetService.getConfigParamByName(this.planKey)
        .subscribe(data => {
            if(data){
                this.plan=data;
                this.getPlanLines();
            }
        });
    }
    
    getMoneyRef() {
        this.budgetService.getConfigParamByName(this.moneyKey)
        .subscribe(data => {
            if(data){
                this.money=data;
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
    
    getPlanLines() {
        this.budgetService.getPlanLines(this.plan.value)
        .subscribe(data => {
            if(data){
                this.planLines=data;
            }
        });
    }
    
    updateLineData() {
        this.budgetLine.code = this.selectedLine.code;
        this.budgetLine.label = this.selectedLine.label;
        this.budgetLine.nature = this.selectedLine.nature;
    }
    
    addBugetLine() {
        this.budgetLines.push(this.budgetLine);
        this.budgetLine = new BudgetLine();
        this.budgetLine.budgetName = this.budget.name;
    }
    
    saveBudget() {
        this.budgetService.saveBudget(this.budget, this.budgetLines)
        .subscribe(data => {
            if(data){
                console.log(data);
            }
        });
    }

}
