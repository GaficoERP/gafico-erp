import 'rxjs/add/operator/map';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PlanLine } from 'app/models/planline';
import { Plan } from 'app/models/plan';
import { PlanEntity } from 'app/models/planentity';
import { Exercice } from 'app/models/exercice';
import { CodeEntity } from 'app/models/codeentity';
import { Provider } from 'app/models/provider';

@Injectable()
export class ConfigurationService {

    constructor(private http: HttpClient) { }
    
    private urlCommon = 'http://localhost:8080/war/rest/common';
    private urlExerciceWs = '/exercice';
    private urlAddPlan = '/plan/add';
    private urlAddPlanWithLines = '/config/addPlanWithLines';
    private urlAddLines = '/planline/add';
    private urlGetLines = '/planline/findByPlan/';
    private urlGetCode = '/planline/newCode/';
    private urlLongin = 'http://localhost:8080/war/api/auth/login';
    private urlAllPlan = '/plan/findAll';
    private urlProvider = '/provider';


    savePlanWithLines(object) {
        return this.http.post<PlanEntity>(this.urlCommon + this.urlAddPlanWithLines, object);
    }

    savePlan(object) {
        return this.http.post<Plan>(this.urlCommon + this.urlAddPlan, object);
    }
    
    getLinesOfPlan(object){
        return this.http.get<PlanLine[]>(this.urlCommon + this.urlGetLines+object.name);
    }

    saveLines(object) {
        return this.http.post<PlanLine>(this.urlCommon + this.urlAddLines, object);
    }
    
    getPlans() {
        return this.http.get<Plan[]>(this.urlCommon + this.urlAllPlan);
    }

    saveExercice(object) {
        return this.http.post<Exercice>(this.urlCommon + this.urlExerciceWs+'/add', object);
    }
    
    getExercices() {
        return this.http.get<Exercice[]>(this.urlCommon + this.urlExerciceWs+'/findAll');
    }
    
    getNextCode(levelName, levelCodeSize, plan, previous) {
        return this.http.get<CodeEntity>(this.urlCommon + this.urlGetCode+levelName+'/'+levelCodeSize+'/'+plan+'/'+previous);
    }
    
    saveProvider(provider) {
        return this.http.post<Provider>(this.urlCommon + this.urlProvider + '/save', provider);
    }
    
    getProviders() {
        return this.http.get<Provider[]>(this.urlCommon + this.urlProvider + '/findAll');
    }
}