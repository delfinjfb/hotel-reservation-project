import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientRoutingModule } from './client-routing.module';
import { RoomListComponent } from './components/room-list/room-list.component';

@NgModule({
  imports: [
    CommonModule,
    ClientRoutingModule,
    RoomListComponent  // ✅ Import the standalone component here
  ]
})
export class ClientModule { }
