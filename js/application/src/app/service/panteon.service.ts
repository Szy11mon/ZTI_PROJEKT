import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Panteon } from '../model/panteon';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PanteonService {

  private panteonsUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.panteonsUrl = '/api/panteons';
  }

  public findAll(): Observable<Panteon[]> {
    return this.http.get<Panteon[]>(this.panteonsUrl);
  }

  public save(panteon: Panteon) {
    return this.http.post<Panteon>(this.panteonsUrl, panteon);
  }

  public delete(name: string) {
    this.delete_url = this.panteonsUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
