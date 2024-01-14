import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, first } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FoodServiceService {
  readonly API_FOOD: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}

  getAllFoods(): Observable<any> {
    return this.http.get<any>(`${this.API_FOOD}/food`).pipe(first());
  }
}
