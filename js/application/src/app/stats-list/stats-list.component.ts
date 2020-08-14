import { Component, OnInit } from '@angular/core';
import { Stats } from '../model/stats';
import { StatsService } from '../service/stats.service';

@Component({
  selector: 'app-stats-list',
  templateUrl: './stats-list.component.html',
  styleUrls: ['./stats-list.component.css']
})
export class StatsListComponent implements OnInit {

  stats: Stats[];

  constructor(private statsService: StatsService) {

  }

  ngOnInit() {
    this.statsService.findAll().subscribe(data => {
      this.stats = data;
    });
  }
}
