import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
  imports: [RouterModule], // ✅ Required for routerLink and routerLinkActive
})
export class HeaderComponent {}
