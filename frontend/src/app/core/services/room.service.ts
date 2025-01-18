import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from '../../models/room.model';

@Injectable({
  providedIn: 'root'  // ✅ Provides the service globally
})
export class RoomService {
  //private apiUrl = 'https://hotel-reservation-project.onrender.com/api/rooms';
  //private apiUrl = 'http://localhost:8080/api/rooms';

  private apiUrl = '/api/rooms';  // ✅ Now using the proxy
  constructor(private http: HttpClient) { }

  getRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(this.apiUrl);
  }
}
