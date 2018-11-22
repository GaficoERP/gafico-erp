import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";
import { FormsModule } from '@angular/forms';
import { ConfigurationRoutingModule } from "./configuration-routing.module";
import { ChartistModule } from 'ng-chartist';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatchHeightModule } from "../shared/directives/match-height.directive";
import { LevelTypeComponent } from "./leveltype/leveltype.component";
import { ConfigurationService } from "./configuration.service";


@NgModule({
    imports: [
        CommonModule,
        ConfigurationRoutingModule,
        ChartistModule,
        FormsModule,
        NgbModule,
        MatchHeightModule
    ],
    exports: [],
    declarations: [
        LevelTypeComponent
    ],
    providers: [ConfigurationService],
})
export class ConfigurationModule { }
