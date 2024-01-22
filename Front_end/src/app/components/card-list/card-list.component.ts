import { Router } from '@angular/router';
import { FoodData } from '../../interface/foodInterface';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { CardComponent } from '../card/card.component';
import { MatDialog } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FoodServiceService } from '../../services/food-service.service';
import { DialogAnimationsExampleDialog } from '../dialog-animations-example-dialog/dialog-animations-example-dialog.component';

@Component({
  selector: 'app-card-list',
  standalone: true,
  imports: [
    CommonModule,
    CardComponent,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
  ],
  templateUrl: './card-list.component.html',
  styleUrl: './card-list.component.scss',
})
export class CardListComponent {
  protected foods = new Observable<FoodData[]>();

  constructor(
    private api: FoodServiceService,
    private route: Router,
    public dialog: MatDialog
  ) {
    this.getAll();
  }

  createPage(): void {
    this.route.navigate(['create']);
  }

  getAll(): void {
    this.foods = this.api.getAllFoods();
  }

  updateFood(body: FoodData): void {
    this.route.navigate(['edit', body.id]);
  }

  openDialog(id: string): void {
    const dialogRef = this.dialog.open(DialogAnimationsExampleDialog);

    dialogRef.afterClosed().subscribe((result) => {
      if (result) this.deleteFood(id);
    });
  }

  deleteFood(id: string): void {
    this.api.deleteFood(id).subscribe(() => this.getAll());
  }
}
