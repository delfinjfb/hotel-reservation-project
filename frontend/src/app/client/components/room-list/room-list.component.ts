import { Component, OnInit } from '@angular/core';
import { RoomCategoryService } from '../../../core/services/room-category.service';
import { Category } from '../../../models/category.model';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.scss']
})
export class RoomListComponent implements OnInit {
  roomCategories: Category[] = [];

  constructor(private roomCategoryService: RoomCategoryService) {}

  ngOnInit(): void {
    this.fetchRoomCategories();
  }

  fetchRoomCategories(): void {
    this.roomCategoryService.getRoomCategories().subscribe({
      next: (categories) => {
        this.roomCategories = categories;
      },
      error: (err) => {
        console.error('Error fetching room categories:', err);
      }
    });
  }
}
