import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StatsService } from '../service/stats.service';
import { Stats } from '../model/stats';
import { PlayerService } from '../service/player.service';
import { Player } from '../model/player';
import { ModeService } from '../service/mode.service';
import { Mode } from '../model/mode';
import { CharacterService } from '../service/character.service';
import { Character } from '../model/character';
import { ClanService } from '../service/clan.service';
import { Clan } from '../model/clan';

@Component({
  selector: 'app-stats-form',
  templateUrl: './stats-form.component.html',
  styleUrls: ['./stats-form.component.css']
})
export class StatsFormComponent {

  stats: Stats;
  clans: Clan[];
  players: Player[];
  modes: Mode[];
  characters: Character[];

  constructor(private route: ActivatedRoute, private router: Router, private statsService: StatsService,
              private playerService: PlayerService, private modeService: ModeService, 
              private characterService: CharacterService, private clanService: ClanService) {
    this.stats = new Stats();
  }

  ngOnInit() {
    this.clanService.findAll().subscribe(data => {
      this.clans = data;
    });
    this.playerService.findAllQuick().subscribe(data => {
      this.players = data;
    });
    this.modeService.findAllQuick().subscribe(data => {
      this.modes = data;
    });
    this.characterService.findAllQuick().subscribe(data => {
      this.characters = data;
    });
  }

  onSubmit() {
    this.statsService.save(this.stats).subscribe(result => this.gotoStatsList());
  }

  gotoStatsList() {
    this.router.navigate(['/stats']);
  }
}
