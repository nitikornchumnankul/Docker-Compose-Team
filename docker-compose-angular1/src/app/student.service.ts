import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getList(): Observable<any> {
    return this.http.get('http://192.168.99.100:8080/student');
    console.log("hello")
  }
}
