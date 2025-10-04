import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fabric } from '../model/fabric';
import { ShirtRequest } from '../model/shirtRequest';
import { Evaluation } from '../model/evaluation';
import { StockAlert } from './alert';

@Injectable({
  providedIn: 'root'
})
export class Api {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getFabrics(): Observable<Fabric[]> {
    return this.http.get<Fabric[]>(`${this.baseUrl}/fabrics`);
  }

  getRecommendation(payload: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/recommendations/test-rules`);
  }

  evaluateShirt(shirt: ShirtRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/tshirt`, { shirtRequest: shirt });
  }

  getAlertHistory(): Observable<StockAlert[]> {
    return this.http.get<StockAlert[]>(`${this.baseUrl}/alerts`);
  }
}
