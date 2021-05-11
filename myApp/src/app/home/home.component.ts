import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  List(){
    this.router.navigate(['list'])
  }

  Match(){
    this.router.navigate(['match'])
  }

  Goals(){
    this.router.navigate(['sort-goals']);
  }

  Win(){
    this.router.navigate(['sort-win']);
  }
}
