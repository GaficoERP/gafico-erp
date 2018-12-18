import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { ConfigurationRoutingModule } from "./configuration-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../shared/directives/match-height.directive";
import { PlanComponent } from "./plan/plan.component";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfigurationService } from './configuation.service';



@NgModule({
    imports: [
        CommonModule,
        ConfigurationRoutingModule,
        ChartistModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        MatchHeightModule
    ],
    exports: [],
    declarations: [
        PlanComponent,
     
    ],
    providers: [ConfigurationService],
})
export class ConfigurationModule { }
