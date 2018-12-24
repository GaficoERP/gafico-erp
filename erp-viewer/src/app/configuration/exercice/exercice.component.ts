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
    private urlExerciceWs = 'http://localhost:8080/war/rest/common/exercice';

  constructor(private confService: ConfigurationService) { }

  ngOnInit() {
      this.getExercices();
  }
    
    addExercice(){
        this.confService.saveExercice(this.urlExerciceWs+'/add', JSON.stringify(this.exercice))
            .subscribe(data => {
                this.exercices.push(data);
                this.exercice = new Exercice();
            });
    }
    
    getExercices() {
        this.confService.getExercices(this.urlExerciceWs+'/findAll')
            .subscribe(data => {
                this.exercices=data;
            });
    }

}
