import { Component, OnInit,OnDestroy } from '@angular/core';
import {HttpClient}from '@angular/common/http';
@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit,OnDestroy {
  private match:any;
  matchTable:any;


  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.match=this.http.get('http://localhost:8080/footballclubs/random').subscribe(response =>{
      console.log('response:',response);
      this.matchTable=response;
    })
  }
  ngOnDestroy():void{
    if(this.match){
      this.match.unsubscribe();
    }
  }

}
