import { Component, OnInit } from '@angular/core';

import { ConfigParam } from 'app/models/configparam';
import { Engagement } from 'app/models/engagement';
import { Ordonnancement } from 'app/models/ordonnancement';

import { BudgetService } from '../../budget.service';

//import * as engagements from '../../shared/engagement-data';

@Component({
  selector: 'app-ordonnancement',
  templateUrl: './ordonnancement.component.html',
  styleUrls: ['./ordonnancement.component.scss']
})
export class OrdonnancementComponent implements OnInit {
        
    order: Ordonnancement = new Ordonnancement();
    orders: Ordonnancement[] = new Array();
    engagements: Engagement[] = new Array();
    engagement: Engagement = new Engagement();
    rao:number;
    cumul:number;

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
      this.engagements = [
  {
    code:1,
    montant:24000,
    taxe:3200,
    objet:"Le Lorem Ipsum est simplement du faux texte employé"
  },
  {
    code:2,
    montant:14000,
    taxe:1200,
    objet:"On sait depuis longtemps que travailler avec du texte lisible"
  },
  {
    code:3,
    montant:4000,
    taxe:620,
    objet:"Contrairement à une opinion répandue, le Lorem Ipsum n'est pas"
  },
  {
    code:4,
    montant:11700,
    taxe:1050,
    objet:"Plusieurs variations de Lorem Ipsum peuvent être trouvées ici"
  },
  {
    code:5,
    montant:7650,
    taxe:567,
    objet:"L'extrait standard de Lorem Ipsum utilisé depuis le XVIè siècle"
  }
]
  }
    
    addOrder() {
        this.orders.push(this.order);
        this.order = new Ordonnancement();
    }
    
    
    getOrdonnancements() {
        this.budgetService.getOrdonnancements(this.engagement.code)
        .subscribe(data => {
            if(data){
                this.orders=data;
            }
        });
    }
    
    
    findEngagement(ref) {
        for(var i=0; i< this.engagements.length; i++) {
            var eng = this.engagements[i];
            if(eng.code == ref) {
                return eng;
            }
        } 
    }
    
    calculateCumul() {
         this.cumul = 0;
        for(var i=0; i< this.orders.length; i++) {
            var ord = this.orders[i];
            if(ord.engagement == this.engagement.code) {
                this.cumul += ord.amount;
             }
        }
    }
    
    calculateRao() {
        this.calculateCumul();
        this.rao = this.engagement.montant - this.cumul;
    }
    
    getNextOrdonnancementReference() {
        // TODO calculer la ref ici au lieu d'appeler le back
        this.budgetService.getNextOrdonnancementReference(this.engagement.code)
        .subscribe(data => {
            console.log(data);
            if(data){
                this.order.reference=data.code;
            }
        });
    }
    
    saveOrders() {
        this.budgetService.saveOrders(this.orders)
        .subscribe(data => {
            if(data){
                this.orders=data;
            }
        });
    }
    
    buildEngagementDetail() {
        console.log(this.engagement);
        this.order.engagement = this.engagement.code;
        this.calculateRao();
        this.getNextOrdonnancementReference();
        this.getOrdonnancements();
    }

}
