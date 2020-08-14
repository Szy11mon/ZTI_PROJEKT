import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Classes } from '../model/classes';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ClassesService {

  private classesUrl: string;
  private delete_url: string;

  constructor(private http: HttpClient) {
    this.classesUrl = '/api/classes';
  }

  public findAll(): Observable<Classes[]> {
    return this.http.get<Classes[]>(this.classesUrl);
  }

  public save(classes: Classes) {
    return this.http.post<Classes>(this.classesUrl, classes);
  }

  public delete(name: string) {
    this.delete_url = this.classesUrl + '/name/' + name;
    return this.http.delete(this.delete_url);
  }
}
