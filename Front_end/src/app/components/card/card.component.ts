import { FoodData } from '../../interface/foodInterface';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',
})
export class CardComponent {
  @Input() body!: FoodData;

  @Output() delete = new EventEmitter();
  @Output() update = new EventEmitter();

  deleteFood(id: string): void {
    this.delete.emit(id);
  }

  updateFood(body: FoodData): void {
    this.update.emit(body);
  }
}
