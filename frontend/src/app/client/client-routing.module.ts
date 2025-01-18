import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { RoomListComponent } from './components/room-list/room-list.component';
import { BookingComponent } from './components/booking/booking.component';
import { ServiceRequestComponent } from './components/service-request/service-request.component';

const routes: Routes = [
  { path: '', component: HeaderComponent },
  { path: 'rooms', component: RoomListComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'service-request', component: ServiceRequestComponent },
  { path: '**', redirectTo: 'rooms' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
