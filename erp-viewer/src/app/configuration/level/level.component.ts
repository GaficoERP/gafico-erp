import { Component } from '@angular/core';
import * as Chartist from 'chartist';
import { ChartType, ChartEvent } from "ng-chartist/dist/chartist.component";
import { Level } from "../../models/level"

declare var require: any;

const data: any = require('../../shared/data/chartist.json');


@Component({
    selector: 'app-level',
    templateUrl: './level.component.html',
    styleUrls: ['./level.component.scss']
})

export class LevelComponent {
levelForm: Level=new Level();
   
}