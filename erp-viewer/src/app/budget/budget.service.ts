import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Plan } from 'app/models/plan';
import { ConfigParam } from 'app/models/configparam';
import { GaficoComponent } from 'app/models/component';
import { Budget } from 'app/models/budget';
import { BudgetLine } from 'app/models/budgetline';
import { PlanLine } from 'app/models/planline';
import { Exercice } from 'app/models/exercice';
import { Engagement } from 'app/models/engagement';
import { Ordonnancement } from 'app/models/ordonnancement';
import { CodeEntity } from 'app/models/codeentity';

@Injectable()
export class BudgetService {
        
    constructor(private http: HttpClient) { }
    private urlWS = 'http://localhost:8080/war/rest';
    private urlPlan = this.urlWS + '/common/plan';
    private urlGetComponent = this.urlWS + '/common/component/findByName/';
    private configWs = '/common/config';
    private budgetWs = '/budget';
    private orderWs = this.budgetWs + '/order';
    
    
    ngOnInit() {
    }
    
    getPlans() {
        return this.http.get<Plan[]>(this.urlPlan + '/findAll');
    }
    
    getCurrentPlan() {
        return this.http.get<Plan>(this.urlPlan + '/find');
    }
    
    getComponent(name) {
        return this.http.get<GaficoComponent>(this.urlGetComponent + name);
    }
    
    getConfigParamsByComponentName(compName) {
        return this.http.get<ConfigParam[]>(this.urlWS + this.configWs + '/findByComponent/' + compName);
    }
    
    getConfigParamByName(name) {
        return this.http.get<ConfigParam>(this.urlWS + this.configWs + '/find/' + name);
    }
    
    updateConfigParam(param) {
        return this.http.post<ConfigParam>(this.urlWS + this.configWs + '/add', param);
    }
    
    getBudget() {
        return this.http.get<Budget>(this.urlWS + this.budgetWs + '/find');
    }
    
    getBudgetLines(budgetName) {
        return this.http.get<BudgetLine[]>(this.urlWS + '/budgetline/findByBudget/' + budgetName);
    }
    
    getPlanLines(planName) {
        return this.http.get<PlanLine[]>(this.urlWS + '/common/planline/findDeepersByPlan/' + planName);
    }
    
    getCurrentPlanLines() {
        return this.http.get<PlanLine[]>(this.urlWS + '/common/planline/find');
    }
    
    getExercice() {
        return this.http.get<Exercice>(this.urlWS + '/common/exercice/findCurrent');
    }
    
    saveBudget(budget, lines) {
        return this.http.post<Budget>(this.urlWS + this.budgetWs + '/save', {budget:budget, budgetLines:lines});
    }
    saveEngagement(object) {
        return this.http.post<Engagement>(this.urlWS + this.budgetWs + '/engagement/save',object);
    }
    getEngagements(object) {
        return this.http.get<Engagement[]>(this.urlWS + this.budgetWs + '/engagement/engamentsbybugetline?budgetLine='+object);
    }
    getAllEngagements() {
        return this.http.get<Engagement[]>(this.urlWS + this.budgetWs + '/engagement/findAll');
    }
    
    getOrdonnancements(reference) {
        return this.http.get<Ordonnancement[]>(this.urlWS + this.orderWs + '/find/' + reference);
    }
    
    getNextOrdonnancementReference(engagement) {
        return this.http.get<CodeEntity>(this.urlWS + this.orderWs + '/newref/' + engagement);
    }
    
    saveOrders(orders) {
        return this.http.post<Ordonnancement[]>(this.urlWS + this.orderWs + '/saveAll', orders);
    }
}