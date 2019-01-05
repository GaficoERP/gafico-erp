import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { DatatableComponent } from "@swimlane/ngx-datatable/release";

import { Budget } from 'app/models/budget';
import { BudgetLine } from 'app/models/budgetline';
import { PlanLine } from 'app/models/planline';
import { ConfigParam } from 'app/models/configparam';
import { Exercice } from 'app/models/exercice';
import { Balancing } from 'app/models/balancing';

import { BudgetService } from '../budget.service';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class BudgetComponent implements OnInit {
  
  budget: Budget = new Budget();
  budgetLines: BudgetLine[] = new Array();
  temp: BudgetLine[] = new Array();
  budgetLine: BudgetLine = new BudgetLine();
  planLines: PlanLine[] = new Array();
  selectedLine: PlanLine = new PlanLine();
  exercice: Exercice = new Exercice();
  plan: ConfigParam = new ConfigParam();
  money: ConfigParam = new ConfigParam();
  balance: Balancing = new Balancing();
  planKey: string = 'config.budget.plan.plan';
  moneyKey: string = 'config.budget.money.ref.ref';
  disableName:boolean = false;
    
    rows = [];
    @ViewChild(DatatableComponent) table: DatatableComponent;

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
      this.getExercice();
      this.getPlan();
      this.getBudget();
      this.getMoneyRef();
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
                this.disableName = true;
            } else {
                this.budget = {name:'', exercice:this.exercice};   
                this.disableName = false;
            }
        });
    }
    
    getBudgetLines() {
        this.budgetService.getBudgetLines(this.budget.name)
        .subscribe(data => {
            if(data){
                this.budgetLines=data;
                this.temp = [...data];
                this.rows = data;
                this.calculateBudgetBalancing();
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
    
    calculateBudgetBalancing() {
        this.balance.rec_inv = 0;
        this.balance.rec_fonc = 0;
        this.balance.dep_inv = 0;
        this.balance.dep_fonc = 0;
        
        for(let line of this.budgetLines) {
            switch(line.nature) {
                case "RECETTE_INVESTISSEMENT": {
                    this.balance.rec_inv += line.amount;
                    break;
                }
                case "RECETTE_FONCTIONNEMENT": {
                    this.balance.rec_fonc += line.amount;
                    break;
                }
                case "DEPENSE_INVESTISSEMENT": {
                    this.balance.dep_inv += line.amount;
                    break;
                }
                case "DEPENSE_FONCTIONNEMENT": {
                    this.balance.dep_fonc += line.amount;
                    break;
                }
                default: {
                    break;
                }
            }
        }
        
        this.balance.rec_color = this.balance.rec_inv == this.balance.rec_fonc ? 'green' : 'red';
        this.balance.dep_color = this.balance.dep_inv == this.balance.dep_fonc ? 'green' : 'red';
        this.balance.bal_color = (this.balance.rec_inv + this.balance.rec_fonc) == (this.balance.dep_inv + this.balance.dep_fonc) ? 'green' : 'red';
        this.balance.total = this.balance.rec_inv + this.balance.rec_fonc;
    }
    
    updateFilter(event) {
        const val = event.target.value.toLowerCase();

        // filter our data
        const temp = this.temp.filter(function (d) {
            return d.code.toLowerCase().indexOf(val) !== -1 || !val;
        });

        // update the rows
        this.rows = temp;
        // Whenever the filter changes, always go back to the first page
        this.table.offset = 0;
    }
    
    delete(row) {
        console.log(row);
    }

}
