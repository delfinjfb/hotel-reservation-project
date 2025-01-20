import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './client/components/header/header.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [RouterOutlet, HeaderComponent], // ✅ Use RouterOutlet for routing
  // ✅ Use RouterOutlet for routing
})
export class AppComponent {
  title = 'hotel-reservation-project';
}
