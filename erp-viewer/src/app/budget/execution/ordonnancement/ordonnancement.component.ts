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
    newOrders: Ordonnancement[] = new Array();
    engagements: Engagement[] = new Array();
    engagement: Engagement = new Engagement();
    rao:number;
    cumul:number;

  constructor(private budgetService: BudgetService) { }

  ngOnInit() {
//       this.engagements = [
//   {
//     reference:1,
//     amount:24000,
//     tax:3200,
//     objet:"Le Lorem Ipsum est simplement du faux texte employé",
//     budget:"Budget 2017",
//     budgetLine:111000
//   },
//   {
//     reference:2,
//     amount:14000,
//     tax:1200,
//     objet:"On sait depuis longtemps que travailler avec du texte lisible",
//     budget:"Budget 2017",
//     budgetLine:111000
//   },
//   {
//     reference:3,
//     amount:4000,
//     tax:620,
//     objet:"Contrairement à une opinion répandue, le Lorem Ipsum n'est pas",
//     budget:"Budget 2017",
//     budgetLine:111000
//   },
//   {
//     reference:4,
//     amount:11700,
//     tax:1050,
//     objet:"Plusieurs variations de Lorem Ipsum peuvent être trouvées ici",
//     budget:"Budget 2017",
//     budgetLine:111000
//   },
//   {
//     reference:5,
//     amount:7650,
//     tax:567,
//     objet:"L'extrait standard de Lorem Ipsum utilisé depuis le XVIè siècle",
//     budget:"Budget 2017",
//     budgetLine:111000
//   }
// ]
  }
    
    addOrder() {
        this.orders.push(this.order);
        this.newOrders.push(this.order);
        this.cumul += this.order.amount;
        this.order = new Ordonnancement();
        this.getNextOrdonnancementReference();
    }
    
    
    getOrdonnancements() {
        this.budgetService.getOrdonnancements(this.engagement.reference)
        .subscribe(data => {
            if(data){
                this.orders=data;
                this.calculateRao();
                this.getNextOrdonnancementReference();
            }
        });
    }
    
    
    findEngagement(ref) {
        for(var i=0; i< this.engagements.length; i++) {
            var eng = this.engagements[i];
            if(eng.reference == ref) {
                return eng;
            }
        } 
    }
    
    calculateCumul() {
         this.cumul = 0;
        for(var i=0; i< this.orders.length; i++) {
            var ord = this.orders[i];
            if(ord.engagement == this.engagement.reference) {
                this.cumul += ord.amount;
             }
        }
    }
    
    calculateRao() {
        this.calculateCumul();
        this.rao = this.engagement.amount - this.cumul;
    }
    
    getNextOrdonnancementReference() {
        if(this.orders.length == 0) {
            this.order.reference = this.engagement.reference + '-' + 1;
        } else {
            this.orders.sort((a,b)=>b.reference.localeCompare(a.reference));
            
            var lastCode = this.orders[0].reference;
            var code = +lastCode.substring(lastCode.indexOf('-') + 1);
            
            this.order.reference = this.engagement.reference + '-' + (code + 1);
        }
//        this.budgetService.getNextOrdonnancementReference(this.engagement.reference)
//        .subscribe(data => {
//            console.log(data);
//            if(data){
//                this.order.reference=data.code;
//            }
//        });
    }
    
    saveOrders() {
        this.budgetService.saveOrders(this.newOrders)
        .subscribe(data => {
            if(data){
                this.newOrders = new Array();
            }
        });
    }
    
    buildEngagementDetail() {
        this.order.engagement = this.engagement.reference;
        this.getOrdonnancements();
    }

}
