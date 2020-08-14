import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Mode } from '../model/mode';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ModeService {

  private modesUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.modesUrl = '/api/mode';
  }

  public findAll(): Observable<Mode[]> {
    return this.http.get<Mode[]>(this.modesUrl);
  }

  public findAllQuick(): Observable<Mode[]> {
    return this.http.get<Mode[]>(this.modesUrl + '/standard');
  }

  public save(mode: Mode) {
    return this.http.post<Mode>(this.modesUrl, mode);
  }

  public delete(name: string) {
    this.delete_url = this.modesUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
