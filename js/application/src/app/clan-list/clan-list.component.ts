import { Component, OnInit } from '@angular/core';
import { Clan } from '../model/clan';
import { ClanService } from '../service/clan.service';

@Component({
  selector: 'app-clan-list',
  templateUrl: './clan-list.component.html',
  styleUrls: ['./clan-list.component.css']
})
export class ClanListComponent implements OnInit {

  clans: Clan[];

  constructor(private clanService: ClanService) {

  }

  ngOnInit() {
    this.clanService.findAll().subscribe(data => {
      this.clans = data;
    });
  }
}
