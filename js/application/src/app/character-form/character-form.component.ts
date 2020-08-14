import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../service/character.service';
import { Character } from '../model/character';
import { PanteonService } from '../service/panteon.service';
import { Panteon } from '../model/panteon';
import { ClassesService } from '../service/classes.service';
import { Classes } from '../model/classes';

@Component({
  selector: 'app-character-form',
  templateUrl: './character-form.component.html',
  styleUrls: ['./character-form.component.css']
})
export class CharacterFormComponent {

  character: Character;
  panteons: Panteon[];
  classes: Classes[];

  constructor(private route: ActivatedRoute, private router: Router, private characterService: CharacterService,
              private panteonService: PanteonService, private classesService: ClassesService) {
    this.character = new Character();
  }

  ngOnInit() {
    this.panteonService.findAll().subscribe(data => {
      this.panteons = data;
    });
    this.classesService.findAll().subscribe(data => {
      this.classes = data;
    });
  }

  onSubmit() {
    console.log(this.character)
    this.characterService.save(this.character).subscribe(result => this.gotoCharacterList());
  }

  gotoCharacterList() {
    this.router.navigate(['/characters']);
  }
}
