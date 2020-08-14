import { Component, OnInit } from '@angular/core';
import { Mode } from '../model/mode';
import { ModeService } from '../service/mode.service';

@Component({
  selector: 'app-mode-list',
  templateUrl: './mode-list.component.html',
  styleUrls: ['./mode-list.component.css']
})
export class ModeListComponent implements OnInit {

  modes: Mode[];
  panteon_names: string[];

  constructor(private modeService: ModeService) {

  }

  ngOnInit() {
    this.modeService.findAll().subscribe(data => {
      this.modes = data;
    });
  }
}
