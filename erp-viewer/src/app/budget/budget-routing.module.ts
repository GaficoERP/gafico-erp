import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BudgetComponent } from "./saisie/budget.component";
import { ConfigurationComponent } from "./configuration/configuration.component";


const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'saisie',
        component: BudgetComponent,
        data: {
          title: 'saisie'
        }
      },
      {
        path: 'config',
        component: ConfigurationComponent,
        data: {
          title: 'Configuration'
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
