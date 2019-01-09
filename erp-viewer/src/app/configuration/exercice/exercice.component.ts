import { Component, OnInit } from '@angular/core';
import { Exercice } from 'app/models/exercice';
import { ConfigurationService } from '../configuation.service';

@Component({
  selector: 'app-exercice',
  templateUrl: './exercice.component.html',
  styleUrls: ['./exercice.component.scss']
})
export class ExerciceComponent implements OnInit {
        
    exercice: Exercice = new Exercice();
    exercices: Exercice[] = new Array();

  constructor(private confService: ConfigurationService) { }

  ngOnInit() {
      this.getExercices();
  }
    
    addExercice(){
        this.confService.saveExercice(JSON.stringify(this.exercice))
            .subscribe(data => {
                this.exercices.push(data);
                this.exercice = new Exercice();
            });
    }
    
    getExercices() {
        this.confService.getExercices()
            .subscribe(data => {
                this.exercices=data;
            });
    }

}
