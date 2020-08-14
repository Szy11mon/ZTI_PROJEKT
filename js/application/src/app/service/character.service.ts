import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Character } from '../model/character';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CharacterService {

  private characterUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.characterUrl = '/api/character';
  }

  public findAll(): Observable<Character[]> {
    return this.http.get<Character[]>(this.characterUrl);
  }

  public findAllQuick(): Observable<Character[]> {
    return this.http.get<Character[]>(this.characterUrl + '/standard');
  }

  public save(character: Character) {
    return this.http.post<Character>(this.characterUrl, character);
  }

  public delete(name: string) {
    this.delete_url = this.characterUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
