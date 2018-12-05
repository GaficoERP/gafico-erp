import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanComponent } from "./plan/plan.component";


const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'plan',
        component: PlanComponent,
        data: {
          title: 'Plan'
        }
      },
    
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigurationRoutingModule { }
