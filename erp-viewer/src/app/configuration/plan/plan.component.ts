import { Component , OnInit } from '@angular/core';
import { Structuration } from 'app/models/structuration';
import { Level } from 'app/models/level';

import { PlanLine } from 'app/models/planline';
import { Plan } from 'app/models/plan';





@Component({
    selector: 'app-plan',
    templateUrl: './plan.component.html',
    styleUrls: ['./plan.component.scss']
})

export class PlanComponent implements OnInit{
    form='';
    planForm:Plan=new Plan();
    levelForm:Level=new Level();
    //for input level in the form
    lev:Level=new Level();
    strForm:Structuration=new Structuration();
    lineForm:PlanLine=new PlanLine();
    plans:Plan[]=new Array();
    strs:Structuration[]=new Array();
    lines:PlanLine[]=new Array();
    levels:Level[]=new Array();


    constructor() { }

    ngOnInit() {

        this.strForm.name="nkqs";
    
      }

      addLevel(){
          
          if(this.levels.length>0){
          this.levelForm.previous=this.levels[this.levels.length-1];
        }
        this.levels.push(this.levelForm)
        this.levelForm={name:"",codeLength: 0,previous:this.levelForm}

          console.log(this.levelForm);
        
      }

  
  
       
   
}
