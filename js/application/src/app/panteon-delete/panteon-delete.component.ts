import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PanteonService } from '../service/panteon.service';
import { Panteon } from '../model/panteon';

@Component({
  selector: 'app-panteon-delete',
  templateUrl: './panteon-delete.component.html',
  styleUrls: ['./panteon-delete.component.css']
})
export class PanteonDeleteComponent{

  name: string;
  panteons: Panteon[];

  constructor(private route: ActivatedRoute, private router: Router, private panteonService: PanteonService) {
  		this.name = '';
  }

  ngOnInit() {
    this.panteonService.findAll().subscribe(data => {
      this.panteons = data;
    });
  }

  onSubmit() {
    this.panteonService.delete(this.name).subscribe(result => this.gotoPanteonList());
  }

  gotoPanteonList() {
    this.router.navigate(['/panteons']);
  }
}
