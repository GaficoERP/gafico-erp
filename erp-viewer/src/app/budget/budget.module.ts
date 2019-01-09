import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { BudgetRoutingModule } from "./budget-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../shared/directives/match-height.directive";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BudgetComponent } from './saisie/budget.component';
import { ConfigurationComponent } from './configuration/configuration.component';
import { BudgetService } from './budget.service';
import { ConfigurationService } from '../configuration/configuation.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { OrdonnancementComponent } from './execution/ordonnancement/ordonnancement.component';
import { EngagementComponent } from './execution/engagement/engagement.component';
import { SuiviEngagementComponent } from './suivi/engagement/suivi-engagement.component';
import { SuiviOrdonnancementComponent } from './suivi/ordonnancement/suivi-ordonnancement.component';
import { ExecBudgetComponent } from './suivi/exec-budget/exec-budget.component';


@NgModule({
    imports: [
        CommonModule,
        BudgetRoutingModule,
        ChartistModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        MatchHeightModule,
        NgxDatatableModule
    ],
    exports: [],
    declarations: [
        BudgetComponent,
        ConfigurationComponent,
        OrdonnancementComponent,
        EngagementComponent,
        SuiviOrdonnancementComponent,
        SuiviEngagementComponent,
        ExecBudgetComponent
    ],
    providers: [ BudgetService, ConfigurationService ]
})
export class BudgetModule { }
