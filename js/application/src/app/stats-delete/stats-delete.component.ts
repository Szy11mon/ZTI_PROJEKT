import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StatsService } from '../service/stats.service';
import { Stats } from '../model/stats';

@Component({
  selector: 'app-stats-delete',
  templateUrl: './stats-delete.component.html',
  styleUrls: ['./stats-delete.component.css']
})
export class StatsDeleteComponent{

  statsID: string;
  stats: Stats[];

  constructor(private route: ActivatedRoute, private router: Router, private statsService: StatsService) {
  		this.statsID = '';
  }

  ngOnInit() {
    this.statsService.findAllQuick().subscribe(data => {
      this.stats = data;
    });
  }

  onSubmit() {
    this.statsService.delete(this.statsID).subscribe(result => this.gotoStatsList());
  }

  gotoStatsList() {
    this.router.navigate(['/stats']);
  }
}
