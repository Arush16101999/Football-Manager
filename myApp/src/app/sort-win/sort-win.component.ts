import { Component, OnDestroy, OnInit } from '@angular/core';
import {HttpClient}from '@angular/common/http';
@Component({
  selector: 'app-sort-win',
  templateUrl: './sort-win.component.html',
  styleUrls: ['./sort-win.component.css']
})
export class SortWinComponent implements OnInit,OnDestroy {
  private win:any;
  winTable:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.win=this.http.get('http://localhost:8080/footballclubs/win').subscribe(response =>{
      console.log('response:',response);
      this.winTable=response;
    })
  }

  ngOnDestroy():void{
    if(this.win){
      this.win.unsubscribe();
    }
  }

}
