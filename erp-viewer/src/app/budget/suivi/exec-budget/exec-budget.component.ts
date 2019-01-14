import { Component, OnInit, ViewChild } from '@angular/core';
import { DatatableComponent } from "@swimlane/ngx-datatable/release";

import { Budget } from 'app/models/budget';
import { BudgetLine } from 'app/models/budgetline';
import { Plan } from 'app/models/plan';
import { PlanLine } from 'app/models/planline';

import { BudgetService } from '../../budget.service';

@Component({
  selector: 'app-exec-budget',
  templateUrl: './exec-budget.component.html',
  styleUrls: ['./exec-budget.component.scss']
})
export class ExecBudgetComponent implements OnInit {
   
    budget: Budget = new Budget();
    planLines: PlanLine[] = new Array();
    plan: Plan = new Plan();
    budgetLines: BudgetLine[] = new Array();
    
    rec_fonc: BudgetLine[] = new Array();
    dep_fonc: BudgetLine[] = new Array();
    rec_inv: BudgetLine[] = new Array();
    dep_inv: BudgetLine[] = new Array();
    
    rec_fonc_rows: BudgetLine[] = new Array();
    dep_fonc_rows: BudgetLine[] = new Array();
    rec_inv_rows: BudgetLine[] = new Array();
    dep_inv_rows: BudgetLine[] = new Array();
    
    total_recettes:number;
    total_depenses:number;
    
    @ViewChild(DatatableComponent) table_dep_inv: DatatableComponent;
    @ViewChild(DatatableComponent) table_rec_inv: DatatableComponent;
    @ViewChild(DatatableComponent) table_dep_fonc: DatatableComponent;
    @ViewChild(DatatableComponent) table_rec_fonc: DatatableComponent;

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
      this.total_recettes = 0;
      this.total_depenses = 0;
      this.getBudget();
  }
    
    getBudget() {
        this.budgetService.getBudget()
        .subscribe(data => {
            if(data){
                this.budget=data;
                this.getBudgetLines();
            }
        });
    }
    
    getBudgetLines() {
        this.budgetService.getBudgetLines(this.budget.name)
        .subscribe(data => {
            if(data){
                this.budgetLines=data;
                this.getPlan();
            }
        });
    }
    
    getPlan() {
        this.budgetService.getCurrentPlan()
        .subscribe(data => {
            if(data){
                this.plan=data;
                this.getPlanLines();
            }
        });
    }
    
    getPlanLines() {
        this.budgetService.getCurrentPlanLines()
        .subscribe(data => {
            if(data){
                this.planLines=data;
                this.buildLines();
            }
        });
    }

    buildLines() {
        for(let line of this.budgetLines) {
            switch(line.nature) {
                case "RECETTE_INVESTISSEMENT": {
                    this.total_recettes += line.amount;
                    this.rec_inv_rows.push(line);
                    this.updatePrevious(this.rec_inv_rows, line, line.amount);
                    break;
                }
                case "RECETTE_FONCTIONNEMENT": {
                    this.total_recettes += line.amount;
                    this.rec_fonc_rows.push(line);
                    this.updatePrevious(this.rec_fonc_rows, line, line.amount);
                    break;
                }
                case "DEPENSE_INVESTISSEMENT": {
                    this.total_depenses += line.amount;
                    this.dep_inv_rows.push(line);
                    this.updatePrevious(this.dep_inv_rows, line, line.amount);
                    break;
                }
                case "DEPENSE_FONCTIONNEMENT": {
                    this.total_depenses += line.amount;
                    this.dep_fonc_rows.push(line);
                    this.updatePrevious(this.dep_fonc_rows, line, line.amount);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        
        this.rec_inv_rows.sort((a,b)=>a.code.localeCompare(b.code));
        this.rec_fonc_rows.sort((a,b)=>a.code.localeCompare(b.code));
        this.dep_inv_rows.sort((a,b)=>a.code.localeCompare(b.code));
        this.dep_fonc_rows.sort((a,b)=>a.code.localeCompare(b.code));
        
        this.rec_inv = this.rec_inv_rows.slice(0, this.rec_inv_rows.length);
        this.rec_fonc = this.rec_fonc_rows.slice(0, this.rec_fonc_rows.length);
        this.dep_inv = this.dep_inv_rows.slice(0, this.dep_inv_rows.length);
        this.dep_fonc = this.dep_fonc_rows.slice(0, this.dep_fonc_rows.length);
    }
    
    updatePrevious(array:BudgetLine[], bline:BudgetLine, amount:number) {
        if(bline == null) {
            return;
        }
        
        let pl:PlanLine = this.findPlanLineByCode(bline.code);
        
        if(pl == null) {
            // should never happen
            return null
        }
        
        let lev = this.findLevelByName(pl.levelName);
        let prevLev = this.findLevelByPosition(lev.position - 1);
        
        if(prevLev == null) {
            // current bline is root
            return;
        }
        
        let code:string = bline.code.substring(0, prevLev.codeLength);
        let updatedLine:BudgetLine;
        for(let line of array) {
            if(line.code == code) {
                line.amount += amount;
                updatedLine = line;
                break;
            }
        }
        
        if(updatedLine == undefined) {
            pl = this.planLines.filter(line => line.code == code)[0];
            updatedLine = {code:code, label:pl.label, nature:pl.nature, budgetName:this.budget.name, amount:amount};
            array.push(updatedLine);
        } else {
        }
        this.updatePrevious(array, updatedLine, amount);
    }
    
    findPlanLineByCode(code) {
        return this.planLines.filter(line => line.code == code)[0];
    }
    
    findLevelByName(level) {
        return this.plan.structuration.filter(lev => lev.name == level)[0];
    }
    
    findLevelByPosition(position) {
        return this.plan.structuration.filter(lev => lev.position == position)[0];
    }
    
    updateAllPrevious(array:BudgetLine[], code:string, position:number, amount:number) {
        if(position < 0) {
            return;
        }
            
        let lev = this.findLevelByPosition(position);
        let newcode:string = code.substring(0, lev.codeLength);
        
        let bl = this.findBudgetLine(array, newcode);
        if(bl != null) {
            bl.amount += amount;
            return;
        }
        
        let pl:PlanLine = this.findPlanLineByCode(newcode);
        let prev = {code:newcode, label:pl.label, nature:pl.nature, budgetName:this.budget.name, amount:0};
        array.push(prev);
        
        if(position > 0) {
            this.updateAllPrevious(array, newcode, position-1, amount);
        }
    }
    
    findBudgetLine(array:BudgetLine[], code:string) {
        return array.filter(line => line.code == code)[0];
    }
    
    updateFilter(event) {
        const level = this.findLevelByName(event.target.value);
        if(level == undefined) {
            this.rec_fonc_rows = this.rec_fonc;
            this.rec_inv_rows = this.rec_inv;
            this.dep_fonc_rows = this.dep_fonc;
            this.dep_inv_rows = this.dep_inv;
            return;
        }

        // filter our data
        this.rec_fonc_rows = this.rec_fonc.filter(function (d) {
            return d.code.length <= level.codeLength;
        });
        this.rec_inv_rows = this.rec_inv.filter(function (d) {
            return d.code.length <= level.codeLength;
        });
        this.dep_fonc_rows = this.dep_fonc.filter(function (d) {
            return d.code.length <= level.codeLength;
        });
        this.dep_inv_rows = this.dep_inv.filter(function (d) {
            return d.code.length <= level.codeLength;
        });

        // Whenever the filter changes, always go back to the first page
        this.table_rec_fonc.offset = 0;
        this.table_rec_inv.offset = 0;
        this.table_dep_inv.offset = 0;
        this.table_dep_fonc.offset = 0;
    }
}
