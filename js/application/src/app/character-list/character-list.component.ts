import { Component, OnInit } from '@angular/core';
import { Character } from '../model/character';
import { CharacterService } from '../service/character.service';

@Component({
  selector: 'app-character-list',
  templateUrl: './character-list.component.html',
  styleUrls: ['./character-list.component.css']
})
export class CharacterListComponent implements OnInit {

  characters: Character[];

  constructor(private characterService: CharacterService) {

  }

  ngOnInit() {
    this.characterService.findAll().subscribe(data => {
      this.characters = data;
    });
  }
}
