import { Component, OnDestroy, OnInit } from '@angular/core';
import {HttpClient}from '@angular/common/http';
@Component({
  selector: 'app-played-match',
  templateUrl: './played-match.component.html',
  styleUrls: ['./played-match.component.css']
})
export class PlayedMatchComponent implements OnInit,OnDestroy {
  private playedMathes:any;
  playedMatchTable:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.playedMathes=this.http.get('http://localhost:8080/footballclubs/matches').subscribe(response =>{
      console.log('response:',response);
      this.playedMatchTable=response;
    })
  }

  ngOnDestroy():void{
    if(this.playedMathes){
      this.playedMathes.unsubscribe();
    }
  }

}
