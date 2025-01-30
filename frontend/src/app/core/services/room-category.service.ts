import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../../models/category.model';

@Injectable({
  providedIn: 'root',
})
export class RoomCategoryService {
  private apiUrl = '/api/room-categories/without-rooms'; // Update with the actual API endpoint.

  constructor(private http: HttpClient) {}

  getRoomCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.apiUrl);
  }
}
