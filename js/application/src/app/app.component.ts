import { Component } from '@angular/core';
import { Router } from '@angular/router';

export interface INavLink {
  id : number; 
  pathLink : string;
  label : string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title: string;

  selectedNavLink : INavLink;
  navLinks : Array<INavLink> = [
    { pathLink : '/panteons', label : 'List', id: 1 },
    { pathLink : '/addpanteon', label : 'Add', id: 2 }
  ];

  constructor(private router : Router) {
    this.title = 'Spring Boot - SMITE Database';
  }

    routeToLink = (event : Event) => {
     this.router.navigate([this.selectedNavLink.pathLink]);

  }
}
export class NgbdDropdownManual {
}
