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
    structName: string;
    //    strForm: Structuration = new Structuration();
    lineForm: PlanLine = new PlanLine();
    parent: PlanLine[] = new Array();
    plans: Plan[] = new Array();
    //    strs: Structuration[] = new Array();
    lines: PlanLine[] = new Array();
    levels: Level[] = new Array();
    levelsForm: Level[] = new Array();
    hasParent = true;
    isCreate = true;


    constructor(private cs: ConfigurationService) { }

    ngOnInit() {
        this.getPlans();
    }

    addLevel() {
        //        if (this.levels.length > 1) {
        //            this.levels[this.levels.length - 1].children.push(this.levelForm);
        //            this.levelForm.previous = this.levels[this.levels.length - 1];
        //        }
        if (this.levels.length == 0) {
            this.levelForm.position = 0;
            this.levelForm.structuration = this.structName;
        }
        this.levels.push(this.levelForm);
        this.levelForm = { name: "", codeLength: 0, structuration: this.structName, position: this.levelForm.position + 1 };
    }


    addLine() {
        if (this.lineForm.code.length < this.getCodeLength(this.lineForm.levelName)) {
            var dif = this.getCodeLength(this.lineForm.levelName) - this.lineForm.code.length;
            for (var i = 0; i < dif; i++) {
                this.lineForm.code = "0" + this.lineForm.code;
            }
        }

        if (this.lineForm.previous != null) {
            this.lineForm.code = this.lineForm.previous.code + this.lineForm.code;
        }
        this.lines.push(this.lineForm);
        // TODO pour le code, appeler getNextCode
        this.lineForm = { label: "", code: "0", levelName: "", nature: this.lineForm.nature, previous: this.lineForm, plan: this.planForm.name };
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
                if (i > 0)
                    lev = this.levels[i - 1];
                console.log(lev);
                break;
            }
        }
        console.log(lev);
        if (lev) {

            for (var i = 0; i < this.lines.length; i++) {
                if (lev.name === this.lines[i].levelName) {
                    this.parent.push(this.lines[i]);

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
        //        this.strForm.levels = this.levels;
        //this.planForm.structuration = this.strForm;
        this.planForm.structuration = this.levels;
        this.getLevel();
    }


    fixplan(plans) {
        this.planForm = plans;
        this.levels = this.planForm.structuration;
        this.form = '';

    }


    savePlan() {
        this.plans.push(this.planForm)

        var plEntity = { plan: this.planForm, planLines: this.lines };
        this.cs.savePlanWithLines(plEntity)
            .subscribe(data => {
                console.log(data);
            });
    }


    getPlans() {
        var ps: Plan[];
        this.cs.getPlans()
            .subscribe(data => {
                console.log(data);
                ps = data;
                if (ps) {
                    this.plans = ps;
                    console.log(this.plans);
                }
            });
    }

    getCodeLength(levelName) {
        for (var i = 0; i < this.levels.length; i++) {
            if (this.levels[i].name == levelName) {
                return this.levels[i].codeLength;
            }
        }
        return 0;
    }

    planLink(plan) {
        this.planForm = plan;
        this.levels = plan.structuration;
        this.cs.getLinesOfPlan(plan)
            .subscribe(data => {
                this.lines = data;
            });
    }

    updatePlan() {
        this.isCreate=false;
        this.form='trois'
    }
}

