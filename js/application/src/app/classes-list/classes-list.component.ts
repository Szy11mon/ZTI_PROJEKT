import { Component, OnInit } from '@angular/core';
import { Classes } from '../model/classes';
import { ClassesService } from '../service/classes.service';

@Component({
  selector: 'app-classes-list',
  templateUrl: './classes-list.component.html',
  styleUrls: ['./classes-list.component.css']
})
export class ClassesListComponent implements OnInit {

  classes: Classes[];

  constructor(private classesService: ClassesService) {

  }

  ngOnInit() {
    this.classesService.findAll().subscribe(data => {
      this.classes = data;
    });
  }
}
