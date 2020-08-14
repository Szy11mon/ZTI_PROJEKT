import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player } from '../model/player';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PlayerService {

  private playersUrl: string;

  constructor(private http: HttpClient) {
    this.playersUrl = 'http://localhost:8080/api/players';
  }

  public findAll(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playersUrl);
  }

  public save(player: Player) {
    return this.http.post<Player>(this.playersUrl, player);
  }
}
