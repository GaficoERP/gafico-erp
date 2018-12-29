import { Component, OnInit } from '@angular/core';
import { BudgetService } from '../budget.service';

import { Plan } from 'app/models/plan';
import { ConfigParam } from 'app/models/configparam';
import { GaficoComponent } from 'app/models/component';


@Component({
  selector: 'app-configuration',
  templateUrl: './configuration.component.html',
  styleUrls: ['./configuration.component.scss']
})
export class ConfigurationComponent implements OnInit {
        
    plans: Plan[] = new Array();
    selectedPlan:ConfigParam;
    selectedMoney:ConfigParam;
    reportMoney:ConfigParam;
    reportMoneyRate:ConfigParam;
    selectedPlanKey: string = 'config.budget.plan';
    selectedMoneyKey: string = 'config.budget.money.ref';
    reportMoneyRateKey: string = 'config.budget.money.report.rate';
    reportMoneyKey: string = 'config.budget.money.report';

    constructor(private budgetService: BudgetService) { }

    ngOnInit() {
        this.getConfigParams();
        this.getBudgetComponent();
        this.getPlans();
    }

    getPlans(){
        this.budgetService.getPlans()
        .subscribe(data => {
            if(data){
                this.plans=data;
            }
        });
    }
    
    getBudgetComponent() {
        this.budgetService.getComponent('Budget')
        .subscribe(data => {
            if(data) {
                this.selectedPlan.component = data;
                this.selectedMoney.component = data;
                this.reportMoney.component = data;
                this.reportMoneyRate.component = data;
            }
        });
    }
    
    getConfigParams() {
        this.budgetService.getConfigParamsByComponentName('Budget')
        .subscribe(data => {
            if(data) {
                for (var i = 0; i < data.length; i++)  {
                    var param = data[i];
                    if(param.name == this.selectedPlanKey) {
                        this.selectedPlan = param;
                        continue;
                    }
                    if(param.name == this.selectedMoneyKey) {
                        this.selectedMoney = param;
                        continue;
                    }
                    if(param.name == this.reportMoneyKey) {
                        this.reportMoney = param;
                        continue;
                    }
                    if(param.name == this.reportMoneyRateKey) {
                        this.reportMoneyRate = param;
                        continue;
                    }
                }
            }
        });
        
        if(this.selectedPlan == undefined) {
            this.selectedPlan={name:this.selectedPlanKey , value:'', component:null, active:true, valueClass:'java.lang.String'};
        }
        if(this.selectedMoney == undefined) {
            this.selectedMoney={name:this.selectedMoneyKey , value:'', component:null, active:true, valueClass:'java.lang.String'};
        }
        if(this.reportMoney == undefined) {
            this.reportMoney={name:this.reportMoneyKey , value:'', component:null, active:true, valueClass:'java.lang.String'};
        }
        if(this.reportMoneyRate == undefined) {
            this.reportMoneyRate={name:this.reportMoneyRateKey , value:'', component:null, active:true, valueClass:'java.lang.Double'};
        }
    }
    
    display() {
//        this.selectedPlan.value = this.plan;
        console.log(this.selectedPlan);
    }
    
    updateSelectedPlan() {
        this.updateConfigParam(this.selectedPlan);
    }
    
    updateSelectedMoney() {
        this.updateConfigParam(this.selectedMoney);
    }
    
    updateReportMoney() {
        this.updateConfigParam(this.reportMoney);
        this.updateConfigParam(this.reportMoneyRate);
    }
    
    updateConfigParam(param) {
        this.budgetService.updateConfigParam(param)
        .subscribe(data => {
            if(data) {
                console.log(data);
            }
        });
    }
}
