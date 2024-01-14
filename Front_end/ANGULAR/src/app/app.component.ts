import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FoodServiceService } from './services/food-service.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'ANGULAR';

  constructor(private apiFood: FoodServiceService) {
    this.apiFood.getAllFoods().subscribe((data) => console.log(data));
  }
}
