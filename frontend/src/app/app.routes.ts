import { Routes } from '@angular/router';

// Import Admin and Auth modules for lazy loading
export const routes: Routes = [
    // ✅ Client Module Routes
    {
        path: '',  // Default path for the client interface
        loadChildren: () => import('./client/client.module').then(m => m.ClientModule)
    },

    // ✅ Admin Module Routes (Protected routes for admin access)
    {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule)
    },

    // ✅ Auth Module for Login
    {
        path: 'login',
        loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
    },

    // ✅ Wildcard Route for 404 - Redirect to Home
    {
        path: '**',
        redirectTo: '',
        pathMatch: 'full'
    }
];
