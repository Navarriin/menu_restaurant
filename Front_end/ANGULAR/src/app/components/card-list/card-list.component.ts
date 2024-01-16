import { Component } from '@angular/core';
import { CardComponent } from '../card/card.component';
import { FoodData } from '../../interface/foodInterface';
import { Observable } from 'rxjs';
import { FoodServiceService } from '../../services/food-service.service';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card-list',
  standalone: true,
  imports: [
    CardComponent,
    MatCardModule,
    MatToolbarModule,
    CommonModule,
    MatButtonModule,
  ],
  templateUrl: './card-list.component.html',
  styleUrl: './card-list.component.scss',
})
export class CardListComponent {
  protected foods = new Observable<FoodData[]>();

  constructor(private api: FoodServiceService, private route: Router) {
    this.getAll();
  }

  createPage(): void {
    this.route.navigate(['create']);
  }

  getAll(): void {
    this.foods = this.api.getAllFoods();
  }

  updateFood(body: FoodData): void {}

  deleteFood(id: number): void {
    this.api.deleteFood(id).subscribe(() => this.getAll());
  }
}
