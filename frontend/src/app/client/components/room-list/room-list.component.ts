import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';  // ✅ Import CommonModule for *ngIf and *ngFor
import { RoomService } from '../../../core/services/room.service';
import { Room } from '../../../models/room.model';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.scss'],
  standalone: true,  // ✅ Ensure the component is standalone
  imports: [CommonModule]  // ✅ Import CommonModule here
})
export class RoomListComponent implements OnInit {
  rooms: Room[] = [];
  loading: boolean = true;
  error: string = '';

  constructor(private roomService: RoomService) { }

  ngOnInit(): void {
    this.fetchRooms();
  }

  fetchRooms(): void {
    this.roomService.getRooms().subscribe({
      next: (data) => {
        this.rooms = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching rooms:', err);
        this.error = 'Could not load rooms. Please try again later.';
        this.loading = false;
      }
    });
  }
}
