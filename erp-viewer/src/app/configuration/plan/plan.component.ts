import { Component, OnInit } from '@angular/core';
import { Structuration } from 'app/models/structuration';
import { Level } from 'app/models/level';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PlanLine } from 'app/models/planline';
import { Plan } from 'app/models/plan';
import { ConfigurationService } from '../configuation.service';





@Component({
    selector: 'app-plan',
    templateUrl: './plan.component.html',
    styleUrls: ['./plan.component.scss']
})

export class PlanComponent implements OnInit {

    form = '';
    planForm: Plan = new Plan();
    levelForm: Level = new Level();
    //for input level in the form
    lev: Level = new Level();
    strForm: Structuration = new Structuration();
    lineForm: PlanLine = new PlanLine();
    parent: PlanLine[] = new Array();
    plans: Plan[] = new Array();
    strs: Structuration[] = new Array();
    lines: PlanLine[] = new Array();
    levels: Level[] = new Array();
    levelsForm: Level[] = new Array();
    hasParent = true;


    constructor(private cs: ConfigurationService) { }

    ngOnInit() {
         this.getPlans();
     

    }

    addLevel() {

        if (this.levels.length > 1) {
            this.levelForm.previous = this.levels[this.levels.length - 1];
        }
        this.levels.push(this.levelForm)
        this.levelForm = { name: "", codeLength: 0, previous: this.levelForm }



    }
    addLine() {
        this.lines.push(this.lineForm)
        this.lineForm = { label: "", code: 0, levelName: "", previous: this.lineForm, plan: this.planForm }
        console.log(this.lines);
        this.getLevel();
        this.getParent();
    }
    addPlan() {
        this.form = 'un';
        this.getLevel();
    }

    getLevel() {
        this.levelsForm = new Array();
        this.levelsForm.push(this.levels[0]);
        for (var i = 0; i < this.levels.length; i++) {
            for (var j = 0; j < this.lines.length; j++) {
                if (this.lines[j].levelName === this.levels[i].name) {
                    if (this.levels[i + 1]) {
                        this.levelsForm.push(this.levels[i + 1]);
                    }
                    break;
                }
            }

        }
        console.log(this.levelsForm);
    }
    getParent() {
        var lev;
        this.parent = new Array();
        console.log(this.lineForm.levelName);
        for (var i = 0; i < this.levels.length; i++) {
            if (this.lineForm.levelName === this.levels[i].name) {
                console.log(this.lineForm.levelName);
                lev = this.levels[i];
                console.log(lev);
                break;
            }
        }
        console.log(lev);
        if (lev) {
            if (lev.previous) {
                for (var i = 0; i < this.lines.length; i++) {
                    if (lev.previous.name === this.lines[i].levelName) {
                        this.parent.push(this.lines[i]);

                    }
                }
            }
            console.log(this.parent);
        }
        if (this.parent.length > 0) {
            this.hasParent = false;
        } else {
            this.hasParent = true;
        }

    }

    page2() {
        this.form = 'trois';
        this.strForm.levels = this.levels;
        this.planForm.structuration = this.strForm;
        this.getLevel();
    }

   


    fixplan(plans) {
        this.planForm = plans;
        this.levels = this.planForm.structuration.levels;
        this.form = '';

    }
     
    savePlan() {
        this.plans.push(this.planForm)

        this.cs.savePlan(this.planForm)
            .subscribe(data => {

                console.log(data);

            });


    }
    
    getPlans(){
        var ps:Plan[];
        this.cs.getPlans()
        .subscribe(data => {
            console.log(data);
                ps=data;
                if(ps){
                    this.plans=ps;
                    console.log(this.plans);
                }
           

        });

    }






}
