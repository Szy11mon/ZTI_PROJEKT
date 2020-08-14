import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player } from '../model/player';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PlayerService {

  private playersUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.playersUrl = '/api/player';
  }

  public findAll(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playersUrl);
  }

  public findAllQuick(): Observable<Player[]> {
    return this.http.get<Player[]>(this.playersUrl + '/standard');
  }


  public save(player: Player) {
    return this.http.post<Player>(this.playersUrl, player);
  }

  public delete(name: string) {
    this.delete_url = this.playersUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
