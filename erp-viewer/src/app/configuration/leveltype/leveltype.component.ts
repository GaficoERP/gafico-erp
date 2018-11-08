import { Component } from '@angular/core';
import { LevelType } from "../../models/levelType"

declare var require: any;

const data: any = require('../../shared/data/chartist.json');


@Component({
    selector: 'app-leveltype',
    templateUrl: './leveltype.component.html',
    styleUrls: ['./leveltype.component.scss']
})

export class LevelTypeComponent {
    levelForm: LevelType=new LevelType();
    view = 'compta';



    type(valeur){
        
    }

  

}
