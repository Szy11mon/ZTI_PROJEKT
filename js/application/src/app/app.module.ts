import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PanteonListComponent } from './panteon-list/panteon-list.component';
import { PanteonFormComponent } from './panteon-form/panteon-form.component';
import { PanteonService } from './service/panteon.service';
import { ClassesFormComponent } from './classes-form/classes-form.component';
import { ClassesListComponent } from './classes-list/classes-list.component';
import { ClassesService } from './service/classes.service';
import { ModeFormComponent } from './mode-form/mode-form.component';
import { ModeListComponent } from './mode-list/mode-list.component';
import { ModeService } from './service/mode.service';
import { CharacterFormComponent } from './character-form/character-form.component';
import { CharacterListComponent } from './character-list/character-list.component';
import { CharacterService } from './service/character.service';
import { PlayerFormComponent } from './player-form/player-form.component';
import { PlayerListComponent } from './player-list/player-list.component';
import { PlayerService } from './service/player.service';
import { ClanListComponent } from './clan-list/clan-list.component';
import { ClanFormComponent } from './clan-form/clan-form.component';
import { ClanService } from './service/clan.service';
import { StatsFormComponent } from './stats-form/stats-form.component';
import { StatsListComponent } from './stats-list/stats-list.component';
import { StatsService } from './service/stats.service';
import { PanteonDeleteComponent } from './panteon-delete/panteon-delete.component';
import { CharacterDeleteComponent } from './character-delete/character-delete.component';
import { ClanDeleteComponent } from './clan-delete/clan-delete.component';
import { ClassesDeleteComponent } from './classes-delete/classes-delete.component';
import { ModeDeleteComponent } from './mode-delete/mode-delete.component';
import { PlayerDeleteComponent } from './player-delete/player-delete.component';
import { StatsDeleteComponent } from './stats-delete/stats-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    PanteonListComponent,
    PanteonFormComponent,
    ClassesFormComponent,
    ClassesListComponent,
    ModeFormComponent,
    ModeListComponent,
    CharacterFormComponent,
    CharacterListComponent,
    PlayerFormComponent,
    PlayerListComponent,
    ClanListComponent,
    ClanFormComponent,
    StatsFormComponent,
    StatsListComponent,
    PanteonDeleteComponent,
    CharacterDeleteComponent,
    ClanDeleteComponent,
    ClassesDeleteComponent,
    ModeDeleteComponent,
    PlayerDeleteComponent,
    StatsDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PanteonService, ClassesService, ModeService, CharacterService, PlayerService, ClanService, StatsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
