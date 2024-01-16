import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first, tap } from 'rxjs';
import { FoodData } from '../interface/foodInterface';

@Injectable({
  providedIn: 'root',
})
export class FoodServiceService {
  private readonly API_FOOD: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  getAllFoods(): Observable<FoodData[]> {
    return this.http.get<FoodData[]>(`${this.API_FOOD}/food`).pipe(first());
  }

  getFoodById(id: number): Observable<FoodData> {
    return this.http.get<FoodData>(`${this.API_FOOD}/food/${id}`).pipe(first());
  }

  postFood(body: FoodData): Observable<FoodData> {
    return this.http
      .post<FoodData>(`${this.API_FOOD}/food`, body)
      .pipe(first());
  }

  updateFood(body: FoodData): Observable<FoodData> {
    return this.http
      .put<FoodData>(`${this.API_FOOD}/food/${body.id}`, body)
      .pipe(first());
  }

  deleteFood(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API_FOOD}/food/${id}`).pipe(first());
  }
}
