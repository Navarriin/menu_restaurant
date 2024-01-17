import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { FormFoodComponent } from './pages/form-food/form-food.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'create',
    component: FormFoodComponent,
  },
  {
    path: 'edit/:id',
    component: FormFoodComponent,
  },
  {
    path: '**',
    redirectTo: 'home',
  },
];
