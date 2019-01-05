import { Component, OnInit } from '@angular/core';

import { ConfigParam } from 'app/models/configparam';
import { Engagement } from 'app/models/engagement';
import { Ordonnancement } from 'app/models/ordonnancement';
import { OrderLine } from 'app/models/ligne-ordonnancement';

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
    orderLines: OrderLine[] = new Array();
    engagements: Engagement[] = new Array();
    rao:number;

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
      this.getOrdonnancements();
        this.buildOrderLines();
  }
    
    addOrder() {
        this.orders.push(this.order);
        this.order = new Ordonnancement();
        this.buildOrderLines();
        this.rao = 0;
    }
    
    getOrdonnancements() {
        this.budgetService.getOrdonnancements()
        .subscribe(data => {
            if(data){
                this.orders=data;
                this.buildOrderLines();
            }
        });
    }
    
    buildOrderLines() {
        this.orderLines = new Array();
        for(var i=0; i< this.engagements.length; i++) {
            var eng = this.engagements[i];
            let ordLine = new OrderLine();
            ordLine.engagement = eng.code;
            ordLine.objet = eng.objet;
            ordLine.engamount=eng.montant+eng.taxe;
            ordLine.cumul = this.calculateCumul(ordLine.engagement);
            ordLine.rest = ordLine.engamount - ordLine.cumul;
            this.orderLines.push(ordLine);
        }
    }
    
    findEngagement(ref) {
        for(var i=0; i< this.engagements.length; i++) {
            var eng = this.engagements[i];
            if(eng.code == ref) {
                return eng;
            }
        } 
    }
    
    calculateCumul(engagement) {
        let cumul = 0;
        for(var i=0; i< this.orders.length; i++) {
            var ord = this.orders[i];
            if(ord.engagement == engagement) {
                cumul += ord.amount;
             }
        }
        return cumul;
    }
    
    calculateRao(engagement) {
        let eng = this.findEngagement(engagement);
        this.rao = (eng.montant+eng.taxe) - this.calculateCumul(engagement);
    }
    
    getNextOrdonnancementReference(engagement) {
        this.budgetService.getNextOrdonnancementReference(engagement)
        .subscribe(data => {
            console.log(data);
            if(data){
                this.order.reference=data.code;
            }
        });
        
        this.calculateRao(engagement);
    }
    
    saveOrders() {
        this.budgetService.saveOrders(this.orders)
        .subscribe(data => {
            if(data){
                this.orders=data;
            }
        });
    }

}
