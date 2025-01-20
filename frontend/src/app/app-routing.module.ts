import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: () => import('./client/client.module').then((m) => m.ClientModule) },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then((m) => m.AdminModule) },
  { path: 'login', loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule) },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })], // ✅ Enables route debugging
  exports: [RouterModule],
})
export class AppRoutingModule {}
