import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeasonListComponent } from './components/season-list/season-list.component';
import { ClientListComponent } from './components/client-list/client-list.component';
import { BookingListComponent } from './components/booking-list/booking-list.component';
import { AuthGuard } from '../auth/auth.guard';

const routes: Routes = [
  { path: 'season-list', component: SeasonListComponent, canActivate: [AuthGuard] },
  { path: 'client-list', component: ClientListComponent, canActivate: [AuthGuard] },
  { path: 'booking-list', component: BookingListComponent, canActivate: [AuthGuard] }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
