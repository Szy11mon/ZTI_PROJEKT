import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassesService } from '../service/classes.service';
import { Classes } from '../model/classes';

@Component({
  selector: 'app-classes-delete',
  templateUrl: './classes-delete.component.html',
  styleUrls: ['./classes-delete.component.css']
})
export class ClassesDeleteComponent{

  name: string;
  classes: Classes[];

  constructor(private route: ActivatedRoute, private router: Router, private classesService: ClassesService) {
  		this.name = '';
  }

  ngOnInit() {
    this.classesService.findAll().subscribe(data => {
      this.classes = data;
    });
  }

  onSubmit() {
    this.classesService.delete(this.name).subscribe(result => this.gotoClassesList());
  }

  gotoClassesList() {
    this.router.navigate(['/classes']);
  }
}
