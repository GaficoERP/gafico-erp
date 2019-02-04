import { Component, OnInit } from '@angular/core';
import { BudgetService } from '../../budget.service';
import { Engagement } from 'app/models/engagement';

@Component({
  selector: 'app-suivi-engagement',
  templateUrl: './suivi-engagement.component.html',
  styleUrls: ['./suivi-engagement.component.scss']
})
export class SuiviEngagementComponent implements OnInit {
  engagements: Engagement[] = new Array();

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
    this.getEngagement();
  }

  getEngagement(){
    this.budgetService.getAllEngagements()
    .subscribe(data => {
        if (data) {
            this.engagements = data;
            this.getLigne();
         
        }
    });
  }
  getLigne(){
     //calculer le cumule pour chaque ligne budgetaire
  }

}
