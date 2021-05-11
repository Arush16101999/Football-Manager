import { PlayedMatchComponent } from './played-match/played-match.component';
import { SortWinComponent } from './sort-win/sort-win.component';
import { MatchComponent } from './match/match.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {HomeComponent} from './home/home.component';
import {ListComponent} from './list/list.component';
import { SortGoalsComponent } from './sort-goals/sort-goals.component';


const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'list',component:ListComponent},
  {path:'match',component:MatchComponent},
  {path:'sort-win',component:SortWinComponent},
  {path:'sort-goals',component:SortGoalsComponent},
  {path:'played-match',component:PlayedMatchComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
