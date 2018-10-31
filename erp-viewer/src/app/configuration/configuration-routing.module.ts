import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LevelComponent } from "./level/level.component";
import { LevelTypeComponent } from "./leveltype/leveltype.component";

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'level',
        component: LevelComponent,
        data: {
          title: 'Level'
        }
      },
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
