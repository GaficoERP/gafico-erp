import 'rxjs/add/operator/map';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PlanLine } from 'app/models/planline';
import { Plan } from 'app/models/plan';
import { PlanEntity } from 'app/models/planentity';
import { Exercice } from 'app/models/exercice';
import { CodeEntity } from 'app/models/codeentity';

@Injectable()
export class ConfigurationService {

    constructor(private http: HttpClient) { }
    private urlAddPlan = 'http://localhost:8080/war/rest/common/plan/add';
    private urlAddPlanWithLines = 'http://localhost:8080/war/rest/common/config/addPlanWithLines';
    private urlAddLines = 'http://localhost:8080/war/rest/common/planline/add';
    private urlGetLines = 'http://localhost:8080/war/rest/common/planline/findByPlan/';
    private urlGetCode = 'http://localhost:8080/war/rest/common/planline/rest/common/planline/newCode/';
    private urlLongin = 'http://localhost:8080/war/api/auth/login';
    private urlAllPlan = 'http://localhost:8080/war/rest/common/plan/findAll';


    savePlanWithLines(object) {
        console.log(object);
        return this.http.post<PlanEntity>(this.urlAddPlanWithLines, object);
    }

    savePlan(object) {

        return this.http.post<Plan>(this.urlAddPlan, object);
    }
    getLinesOfPlan(object){
        return this.http.get<PlanLine[]>(this.urlGetLines+object.name);
    }

    saveLines(object) {

        return this.http.post<PlanLine>(this.urlAddLines, object);
    }
    getPlans() {
        return this.http.get<Plan[]>(this.urlAllPlan);
    }

    saveExercice(url, object) {
        return this.http.post<Exercice>(url, object);
    }
    
    getExercices(url) {
        return this.http.get<Exercice[]>(url);
    }
    
    getNextCode(levelName, levelCodeSize, plan, previous) {
        return this.http.get<CodeEntity>(this.urlGetCode+levelName+'/'+levelCodeSize+'/'+plan+'/'+previous);
    }
}