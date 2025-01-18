import { Component, OnInit } from '@angular/core';
//import { RoomService } from '../services/room.service';
import { Room } from '../../../models/room.model';
import { RoomService } from '../../../services/room.service';


@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.scss']
})
export class RoomListComponent implements OnInit {
  rooms: Room[] = [];

  constructor(private roomService: RoomService) { }

  ngOnInit(): void {
    this.loadAvailableRooms();
  }

  loadAvailableRooms(): void {
    this.roomService.getAvailableRooms().subscribe({
      next: (data) => this.rooms = data.filter(room => room.availability),
      error: (err) => console.error('Error fetching rooms:', err)
    });
  }
}
