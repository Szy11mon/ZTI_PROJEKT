import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModeService } from '../service/mode.service';
import { Mode } from '../model/mode';
import { PanteonService } from '../service/panteon.service';
import { Panteon } from '../model/panteon';

@Component({
  selector: 'app-mode-form',
  templateUrl: './mode-form.component.html',
  styleUrls: ['./mode-form.component.css']
})
export class ModeFormComponent {

  mode: Mode;
  panteons: Panteon[];

  constructor(private route: ActivatedRoute, private router: Router, private modeService: ModeService,
              private panteonService: PanteonService) {
    this.mode = new Mode();
  }

  ngOnInit() {
    this.panteonService.findAll().subscribe(data => {
      this.panteons = data;
    });
  }

  onSubmit() {
    this.modeService.save(this.mode).subscribe(result => this.gotoModeList());
  }

  gotoModeList() {
    this.router.navigate(['/modes']);
  }
}
