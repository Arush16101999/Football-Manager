import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ListComponent } from './list/list.component';
import { MatchComponent } from './match/match.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MDBBootstrapModule,StickyHeaderModule, NavbarModule } from 'angular-bootstrap-md';
import { HttpClientModule } from '@angular/common/http';
import { SortWinComponent } from './sort-win/sort-win.component';
import { SortGoalsComponent } from './sort-goals/sort-goals.component';
import { PlayedMatchComponent } from './played-match/played-match.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListComponent,
    MatchComponent,
    SortWinComponent,
    SortGoalsComponent,
    PlayedMatchComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    StickyHeaderModule, NavbarModule,
    HttpClientModule  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
