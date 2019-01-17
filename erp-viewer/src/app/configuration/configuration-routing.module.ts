import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanComponent } from "./plan/plan.component";
import { ExerciceComponent } from "./exercice/exercice.component";
import { ProviderComponent } from "./provider/provider.component";


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
      {
        path: 'exercice',
        component: ExerciceComponent,
        data: {
          title: 'Exercice'
        }
      },
      {
        path: 'provider',
        component: ProviderComponent,
        data: {
          title: 'Fournisseur'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConfigurationRoutingModule { }
