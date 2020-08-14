import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Clan } from '../model/clan';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ClanService {

  private clansUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.clansUrl = '/api/clan';
  }

  public findAll(): Observable<Clan[]> {
    return this.http.get<Clan[]>(this.clansUrl);
  }

  public save(clan: Clan) {
    return this.http.post<Clan>(this.clansUrl, clan);
  }

  public delete(name: string) {
    this.delete_url = this.clansUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
