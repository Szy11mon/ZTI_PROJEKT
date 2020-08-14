import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PanteonService } from '../service/panteon.service';
import { Panteon } from '../model/panteon';

@Component({
  selector: 'app-panteon-form',
  templateUrl: './panteon-form.component.html',
  styleUrls: ['./panteon-form.component.css']
})
export class PanteonFormComponent {

  panteon: Panteon;

  constructor(private route: ActivatedRoute, private router: Router, private panteonService: PanteonService) {
    this.panteon = new Panteon();
  }

  onSubmit() {
    this.panteonService.save(this.panteon).subscribe(result => this.gotoPanteonList());
  }

  gotoPanteonList() {
    this.router.navigate(['/panteons']);
  }
}
