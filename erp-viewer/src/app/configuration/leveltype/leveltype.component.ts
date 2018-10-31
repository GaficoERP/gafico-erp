import { Component } from '@angular/core';
import * as Chartist from 'chartist';
import { ChartType, ChartEvent } from "ng-chartist/dist/chartist.component";

declare var require: any;

const data: any = require('../../shared/data/chartist.json');


@Component({
    selector: 'app-leveltype',
    templateUrl: './leveltype.component.html',
    styleUrls: ['./leveltype.component.scss']
})

export class LevelTypeComponent {

  

}
