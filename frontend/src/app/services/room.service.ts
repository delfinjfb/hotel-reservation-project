import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from '../models/room.model';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  private apiUrl = '/api/rooms';  // API endpoint

  constructor(private http: HttpClient) { }

  getAvailableRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(this.apiUrl);
  }
}
