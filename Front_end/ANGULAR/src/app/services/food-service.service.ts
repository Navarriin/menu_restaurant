import { FoodData } from '../interface/foodInterface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FoodServiceService {
  private readonly API_FOOD: string = 'http://localhost:8080/food';
  constructor(private http: HttpClient) {}

  getAllFoods(): Observable<FoodData[]> {
    return this.http.get<FoodData[]>(this.API_FOOD).pipe(first());
  }

  getFoodById(id: string): Observable<FoodData> {
    return this.http.get<FoodData>(`${this.API_FOOD}/${id}`).pipe(first());
  }

  postFood(body: FoodData): Observable<FoodData> {
    return this.http.post<FoodData>(this.API_FOOD, body).pipe(first());
  }

  updateFood(id: string, body: FoodData): Observable<FoodData> {
    return this.http
      .put<FoodData>(`${this.API_FOOD}/${id}`, body)
      .pipe(first());
  }

  deleteFood(id: string): Observable<void> {
    return this.http.delete<void>(`${this.API_FOOD}/${id}`).pipe(first());
  }
}
