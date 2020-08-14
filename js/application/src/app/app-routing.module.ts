import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PanteonListComponent } from './panteon-list/panteon-list.component';
import { PanteonFormComponent } from './panteon-form/panteon-form.component';
import { PanteonDeleteComponent } from './panteon-delete/panteon-delete.component';
import { ClassesListComponent } from './classes-list/classes-list.component';
import { ClassesFormComponent } from './classes-form/classes-form.component';
import { ClassesDeleteComponent } from './classes-delete/classes-delete.component';
import { ModeListComponent } from './mode-list/mode-list.component';
import { ModeFormComponent } from './mode-form/mode-form.component';
import { ModeDeleteComponent } from './mode-delete/mode-delete.component';
import { CharacterListComponent } from './character-list/character-list.component';
import { CharacterFormComponent } from './character-form/character-form.component';
import { CharacterDeleteComponent } from './character-delete/character-delete.component';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerFormComponent } from './player-form/player-form.component';
import { PlayerDeleteComponent } from './player-delete/player-delete.component';
import { ClanListComponent } from './clan-list/clan-list.component';
import { ClanFormComponent } from './clan-form/clan-form.component';
import { ClanDeleteComponent } from './clan-delete/clan-delete.component';
import { StatsListComponent } from './stats-list/stats-list.component';
import { StatsFormComponent } from './stats-form/stats-form.component';
import { StatsDeleteComponent } from './stats-delete/stats-delete.component';

const routes: Routes = [
  { path: 'panteons', component: PanteonListComponent },
  { path: 'addpanteon', component: PanteonFormComponent },
  { path: 'deletepanteon', component: PanteonDeleteComponent },
  { path: 'classes', component: ClassesListComponent },
  { path: 'addclasses', component: ClassesFormComponent },
  { path: 'deleteclasses', component: ClassesDeleteComponent },
  { path: 'modes', component: ModeListComponent },
  { path: 'addmode', component: ModeFormComponent },
  { path: 'deletemode', component: ModeDeleteComponent },
  { path: 'characters', component: CharacterListComponent },
  { path: 'addcharacter', component: CharacterFormComponent },
  { path: 'deletecharacter', component: CharacterDeleteComponent },
  { path: 'players', component: PlayerListComponent },
  { path: 'addplayer', component: PlayerFormComponent },
  { path: 'deleteplayer', component: PlayerDeleteComponent },
  { path: 'clans', component: ClanListComponent },
  { path: 'addclan', component: ClanFormComponent },
  { path: 'deleteclan', component: ClanDeleteComponent },
  { path: 'stats', component: StatsListComponent },
  { path: 'addstats', component: StatsFormComponent },
  { path: 'deletestats', component: StatsDeleteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
