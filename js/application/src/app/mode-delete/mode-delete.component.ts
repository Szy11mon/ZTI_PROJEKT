import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModeService } from '../service/mode.service';
import { Mode } from '../model/mode';

@Component({
  selector: 'app-mode-delete',
  templateUrl: './mode-delete.component.html',
  styleUrls: ['./mode-delete.component.css']
})
export class ModeDeleteComponent{

  name: string;
  modes: Mode[];

  constructor(private route: ActivatedRoute, private router: Router, private modeService: ModeService) {
  		this.name = '';
  }

  ngOnInit() {
    this.modeService.findAllQuick().subscribe(data => {
      this.modes = data;
    });
  }

  onSubmit() {
    this.modeService.delete(this.name).subscribe(result => this.gotoModeList());
  }

  gotoModeList() {
    this.router.navigate(['/modes']);
  }
}
