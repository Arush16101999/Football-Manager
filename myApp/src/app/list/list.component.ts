import { Component, OnInit,OnDestroy } from '@angular/core';
import {HttpClient}from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit,OnDestroy {
  private sort:any;
  sortTable:any;


  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.sort=this.http.get('http://localhost:8080/footballclubs').subscribe(response =>{
      console.log('response:',response);
      this.sortTable=response;
    })
  }
  ngOnDestroy():void{
    if(this.sort){
      this.sort.unsubscribe();
    }
  }

}
