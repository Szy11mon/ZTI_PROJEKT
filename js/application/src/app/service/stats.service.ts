import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Stats } from '../model/stats';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StatsService {

  private statsUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.statsUrl = '/api/stats';
  }

  public findAll(): Observable<Stats[]> {
    return this.http.get<Stats[]>(this.statsUrl);
  }

  public findAllQuick(): Observable<Stats[]> {
    return this.http.get<Stats[]>(this.statsUrl + '/standard');
  }

  public save(stats: Stats) {
    return this.http.post<Stats>(this.statsUrl, stats);
  }

  public delete(statsID: string) {
    this.delete_url = this.statsUrl + '/' + statsID;
    return this.http.delete(this.delete_url);
  }
}
