import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClassesService } from '../service/classes.service';
import { Classes } from '../model/classes';

@Component({
  selector: 'app-classes-form',
  templateUrl: './classes-form.component.html',
  styleUrls: ['./classes-form.component.css']
})
export class ClassesFormComponent {

  classes: Classes;

  constructor(private route: ActivatedRoute, private router: Router, private classesService: ClassesService) {
    this.classes = new Classes();
  }

  onSubmit() {
    this.classesService.save(this.classes).subscribe(result => this.gotoClassesList());
  }

  gotoClassesList() {
    this.router.navigate(['/classes']);
  }
}
