import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BudgetComponent } from "./saisie/budget.component";
import { ConfigurationComponent } from "./configuration/configuration.component";
import { EngagementComponent } from "./execution/engagement/engagement.component";
import { OrdonnancementComponent } from "./execution/ordonnancement/ordonnancement.component";
import { SuiviEngagementComponent } from "./suivi/engagement/suivi-engagement.component";
import { SuiviOrdonnancementComponent } from "./suivi/ordonnancement/suivi-ordonnancement.component";
import { ExecBudgetComponent } from "./suivi/exec-budget/exec-budget.component";


const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'saisie',
        component: BudgetComponent,
        data: {
          title: 'Saisie'
        }
      },
      {
        path: 'config',
        component: ConfigurationComponent,
        data: {
          title: 'Configuration'
        }
      },
      {
        path: 'saisie/engagement',
        component: EngagementComponent,
        data: {
          title: 'Saisie Engagement'
        }
      },
      {
        path: 'saisie/ordonnancement',
        component: OrdonnancementComponent,
        data: {
          title: 'Saisie Ordonnancement'
        }
      },
      {
        path: 'suivi/engagement',
        component: SuiviEngagementComponent,
        data: {
          title: 'Situation Engagements'
        }
      },
      {
        path: 'suivi/ordonnancement',
        component: SuiviOrdonnancementComponent,
        data: {
          title: 'Situation Ordonnancements'
        }
      },
      {
        path: 'suivi/exec-budget',
        component: ExecBudgetComponent,
        data: {
          title: 'Situation Exécution Budget'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BudgetRoutingModule { }
