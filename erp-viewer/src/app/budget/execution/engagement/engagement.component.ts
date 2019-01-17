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
    engagementForm: Engagement = new Engagement();
    engagements: Engagement[] = new Array();
    ligneEngagement: LigneEngagement = new LigneEngagement();
    exercice: Exercice = new Exercice();
    choix=false;
    constructor(private budgetService: BudgetService) { }

    ngOnInit() {
        this.getExercice();
        this.getBudget();
        this.getBudgetLines();

    }

    getExercice() {
        this.budgetService.getExercice()
            .subscribe(data => {
                if (data) {
                    this.exercice = data;
                }
            });
    }



    getBudget() {
        this.budgetService.getBudget()
            .subscribe(data => {
                if (data) {
                    this.budget = data;
                    this.exercice = data.exercice;
                    this.getBudgetLines();
                    this.initEngagement();
                } else {
                    this.budget = { name: '', exercice: this.exercice };
                }
            });
    }

    getBudgetLines() {
        this.budgetService.getBudgetLines(this.budget.name)
            .subscribe(data => {
                if (data) {
                    this.budgetLines = data;
                }
            });
    }
    enregistrer() {
        this.budgetService.saveEngagement(this.engagementForm)
            .subscribe(data => {
                if (data) {
                    this.engagements.push(this.engagementForm);

                    this.engagementForm = { reference: this.engagementForm.reference, budget: this.engagementForm.budget, budgetLine: this.engagementForm.budgetLine, amount: 0, tax: 0, objet: "",choice:"" };
                }
            });
    }

    initEngagement() {
        this.ligneEngagement = { budgetLine: "", budget: this.budget.name, libelle: "", prevu: 0, engagee: 0, restant: 0 }
    }
    calculateRao() {
        this.calculateCumul();
        this.ligneEngagement.restant = this.ligneEngagement.prevu - this.ligneEngagement.engagee;
    }
    calculateCumul() {
        this.ligneEngagement.engagee = 0;
        for (var i = 0; i < this.engagements.length; i++) {
            var ord = this.engagements[i];

            this.ligneEngagement.engagee += ord.amount;

        }
    }
    getEngagements() {
        for (var i = 0; i < this.budgetLines.length; i++) {
            var ord = this.budgetLines[i];
            if (ord.code === this.engagementForm.budgetLine) {
                this.ligneEngagement.budget = ord.label;
                this.ligneEngagement.prevu = ord.amount;
            }
        }
        this.budgetService.getEngagements(this.engagementForm.budgetLine)
            .subscribe(data => {
                if (data) {
                    this.engagements = data;
                    this.calculateRao();
                }
            });
    }
    choice(){
        console.log(this.engagementForm.choice);
        if (this.engagementForm.choice==="autre"){
            this.engagementForm.choice="";
            this.choix=true;
        }else{
            this.choix=false;
        }
    }

}
