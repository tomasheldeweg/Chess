import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Piece } from '../model/piece';

@Injectable({
  providedIn: 'root'
})
export class PieceService {
  urlBase = "http://localhost:8080/api/pieces"
  constructor(private http:HttpClient) { }
  
  listAll(): Observable<Piece[]>{
    return this.http.get<Piece[]>(this.urlBase);
  }



  
}
