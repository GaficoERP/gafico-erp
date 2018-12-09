import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { BudgetRoutingModule } from "./budget-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../shared/directives/match-height.directive";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BudgetComponent } from './main/budget.component';


@NgModule({
    imports: [
        CommonModule,
        BudgetRoutingModule,
        ChartistModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        MatchHeightModule
    ],
    exports: [],
    declarations: [
        BudgetComponent
    ],
    providers: []
})
export class BudgetModule { }