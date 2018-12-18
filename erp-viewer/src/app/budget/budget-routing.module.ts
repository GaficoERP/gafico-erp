import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BudgetComponent } from "./saisie/budget.component";


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
    
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BudgetRoutingModule { }
