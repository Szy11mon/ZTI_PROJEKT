import { Component, OnInit } from '@angular/core';
import { Panteon } from '../model/panteon';
import { PanteonService } from '../service/panteon.service';

@Component({
  selector: 'app-panteon-list',
  templateUrl: './panteon-list.component.html',
  styleUrls: ['./panteon-list.component.css']
})
export class PanteonListComponent implements OnInit {

  panteons: Panteon[];

  constructor(private panteonService: PanteonService) {

  }

  ngOnInit() {
    this.panteonService.findAll().subscribe(data => {
      this.panteons = data;
    });
  }
}
