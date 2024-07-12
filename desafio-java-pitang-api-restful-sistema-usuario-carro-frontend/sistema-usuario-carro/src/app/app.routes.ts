import { Routes } from '@angular/router';

export const APP_ROUTES: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'login' },
    {
        path: 'login', 
        loadChildren: () => import('./cars/users.route').then(m => m.USERS_ROUTES)
    }
];
