import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from '../service/player.service';
import { Player } from '../model/player';
import { ClanService } from '../service/clan.service';
import { Clan } from '../model/clan';

@Component({
  selector: 'app-player-form',
  templateUrl: './player-form.component.html',
  styleUrls: ['./player-form.component.css']
})
export class PlayerFormComponent {

  player: Player;
  clans: Clan[];

  constructor(private route: ActivatedRoute, private router: Router, private playerService: PlayerService,
              private clanService: ClanService) {
    this.player = new Player();
  }

  ngOnInit() {
    this.clanService.findAll().subscribe(data => {
      this.clans = data;
    });
  }

  onSubmit() {
    this.playerService.save(this.player).subscribe(result => this.gotoPlayerList());
  }

  gotoPlayerList() {
    this.router.navigate(['/players']);
  }
}
