import { Component, OnInit,OnDestroy } from '@angular/core';
import {HttpClient}from '@angular/common/http';
@Component({
  selector: 'app-sort-goals',
  templateUrl: './sort-goals.component.html',
  styleUrls: ['./sort-goals.component.css']
})
export class SortGoalsComponent implements OnInit,OnDestroy {

  private goal:any;
  goalTable:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.goal=this.http.get('http://localhost:8080/footballclubs/goal').subscribe(response =>{
      console.log('response:',response);
      this.goalTable=response;
    })
  }

  ngOnDestroy():void{
    if(this.goal){
      this.goal.unsubscribe();
    }
  }

}
