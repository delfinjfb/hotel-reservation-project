import { Component, OnInit } from '@angular/core';
import { RoomCategoryService } from '../../../core/services/room-category.service';
import { Category } from '../../../models/category.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-room-category',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './room-category.component.html',
  styleUrls: ['./room-category.component.scss']
})
export class RoomCategoryComponent implements OnInit {
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
