import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClanService } from '../service/clan.service';
import { Clan } from '../model/clan';

@Component({
  selector: 'app-clan-delete',
  templateUrl: './clan-delete.component.html',
  styleUrls: ['./clan-delete.component.css']
})
export class ClanDeleteComponent{

  name: string;
  clans: Clan[];

  constructor(private route: ActivatedRoute, private router: Router, private clanService: ClanService) {
  		this.name = '';
  }

  ngOnInit() {
    this.clanService.findAll().subscribe(data => {
      this.clans = data;
    });
  }

  onSubmit() {
    this.clanService.delete(this.name).subscribe(result => this.gotoClanList());
  }

  gotoClanList() {
    this.router.navigate(['/clans']);
  }
}
