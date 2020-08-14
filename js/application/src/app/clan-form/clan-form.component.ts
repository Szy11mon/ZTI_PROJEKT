import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClanService } from '../service/clan.service';
import { Clan } from '../model/clan';

@Component({
  selector: 'app-clan-form',
  templateUrl: './clan-form.component.html',
  styleUrls: ['./clan-form.component.css']
})
export class ClanFormComponent {

  clan: Clan;

  constructor(private route: ActivatedRoute, private router: Router, private clanService: ClanService) {
    this.clan = new Clan();
  }

  onSubmit() {
    this.clanService.save(this.clan).subscribe(result => this.gotoClanList());
  }

  gotoClanList() {
    this.router.navigate(['/clans']);
  }
}
