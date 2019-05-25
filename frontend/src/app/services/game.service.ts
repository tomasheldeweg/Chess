import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http:HttpClient) {}

  urlBase: "http://localhost:8080/api/games"
  
  createGame(){
    this.http.post(this.urlBase + "/new-Game", null)
  }


}
