import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";

import { ConfigurationRoutingModule } from "./configuration-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../shared/directives/match-height.directive";

import { LevelComponent } from "./level/level.component";
import { LevelTypeComponent } from "./leveltype/leveltype.component";


@NgModule({
    imports: [
        CommonModule,
        ConfigurationRoutingModule,
        ChartistModule,
        NgbModule,
        MatchHeightModule
    ],
    exports: [],
    declarations: [
        LevelComponent,
        LevelTypeComponent
    ],
    providers: [],
})
export class ConfigurationModule { }
