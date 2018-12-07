import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BudgetComponent } from "./main/budget.component";


const routes: Routes = [
  {
    path: 'budget',
    component: BudgetComponent,
    data: {
      title: 'Budget'
    },
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BudgetRoutingModule { }
