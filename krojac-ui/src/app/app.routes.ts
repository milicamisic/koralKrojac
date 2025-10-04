import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { Recommender } from './components/recommender/recommender';
import { AdminDashboard } from './components/admin-dashboard/admin-dashboard';

export const routes: Routes = [
  { path: '', component: Home }, // default
  { path: 'recommender', component: Recommender },
  { path: 'admin', component: AdminDashboard },
  { path: '**', redirectTo: '' }
];
