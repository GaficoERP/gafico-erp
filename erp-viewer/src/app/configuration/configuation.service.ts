import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PlanLine } from 'app/models/planline';
import { Plan } from 'app/models/plan';

@Injectable()
export class ConfigurationService {

    constructor(private http: HttpClient) { }
    private urlAddPlan = 'http://localhost:8080/war/rest/common/planline/add';
    private urlAddLines = 'http://localhost:8080/war/rest/common/plan/add';
    private urlLongin = 'http://localhost:8080/war/api/auth/login';
    private urlAllPlan = 'http://localhost:8080/war/rest/common/plan/findAll';





    savePlan(object) {

        return this.http.post<Plan>(this.urlAddPlan, object);
    }
    saveLines(object) {

        return this.http.post<PlanLine>(this.urlAddLines, object);
    }
    getPlans() {
        return this.http.get<Plan[]>(this.urlAllPlan);
    }

}