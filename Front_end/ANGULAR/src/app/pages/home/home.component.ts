import { Component } from '@angular/core';
import { FoodServiceService } from '../../services/food-service.service';
import { FoodData } from '../../interface/foodInterface';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  foods!: FoodData[];

  constructor(private api: FoodServiceService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.api.getAllFoods().subscribe((data) => (this.foods = data));
  }

  deleteFoodById(id: number): void {
    this.api.deleteFood(id).subscribe(() => this.getAll());
  }
}
