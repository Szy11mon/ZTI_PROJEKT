import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from '../service/player.service';
import { Player } from '../model/player';

@Component({
  selector: 'app-player-delete',
  templateUrl: './player-delete.component.html',
  styleUrls: ['./player-delete.component.css']
})
export class PlayerDeleteComponent{

  name: string;
  players: Player[];

  constructor(private route: ActivatedRoute, private router: Router, private playerService: PlayerService) {
  		this.name = '';
  }

  ngOnInit() {
    this.playerService.findAllQuick().subscribe(data => {
      this.players = data;
    });
  }

  onSubmit() {
    this.playerService.delete(this.name).subscribe(result => this.gotoPlayerList());
  }

  gotoPlayerList() {
    this.router.navigate(['/players']);
  }
}
