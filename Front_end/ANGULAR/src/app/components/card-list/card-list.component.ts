import { Component } from '@angular/core';
import { CardComponent } from '../card/card.component';
import { FoodData } from '../../interface/foodInterface';
import { Observable } from 'rxjs';
import { FoodServiceService } from '../../services/food-service.service';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-list',
  standalone: true,
  imports: [CardComponent, MatCardModule, MatToolbarModule, CommonModule],
  templateUrl: './card-list.component.html',
  styleUrl: './card-list.component.scss',
})
export class CardListComponent {
  protected foods = new Observable<FoodData[]>();

  constructor(private api: FoodServiceService) {
    this.getAll();
  }

  getAll(): void {
    this.foods = this.api.getAllFoods();
  }

  deleteFood(id: number): void {
    this.api.deleteFood(id).subscribe(() => this.getAll());
  }

  updateFood(body: FoodData): void {}
}
