import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LevelTypeComponent } from "./leveltype/leveltype.component";

const routes: Routes = [
  {
    path: '',
    children: [

      {
        path: 'leveltype',
        component: LevelTypeComponent,
        data: {
          title: 'Level Type'
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
