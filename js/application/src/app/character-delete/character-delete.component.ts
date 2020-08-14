import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../service/character.service';
import { Character } from '../model/character';

@Component({
  selector: 'app-character-delete',
  templateUrl: './character-delete.component.html',
  styleUrls: ['./character-delete.component.css']
})
export class CharacterDeleteComponent{

  name: string;
  characters: Character[];

  constructor(private route: ActivatedRoute, private router: Router, private characterService: CharacterService) {
  		this.name = '';
  }

  ngOnInit() {
    this.characterService.findAllQuick().subscribe(data => {
      this.characters = data;
    });
  }

  onSubmit() {
    this.characterService.delete(this.name).subscribe(result => this.gotoCharacterList());
  }

  gotoCharacterList() {
    this.router.navigate(['/characters']);
  }
}
