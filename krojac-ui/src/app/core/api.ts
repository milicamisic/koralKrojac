import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fabric } from '../model/fabric';
import { ShirtRequest } from '../model/shirtRequest';
import { RecommendationDTO } from '../model/recommendationDTO';
import { StockAlert } from './alert';
import { DressRequest } from '../model/dressRequest';
import { PantsRequest } from '../model/pantsRequest';
import { SkirtRequest } from '../model/skirtRequest';
import { SweaterRequest } from '../model/sweaterRequest';
import { TableclothRequest } from '../model/tableclothRequest';
import { BedsheetRequest } from '../model/bedsheetRequest';
import { PillowcaseRequest } from '../model/pillowcaseRequest';
import { CurtainRequest } from '../model/curtainRequest';
import { BlouseRequest } from '../model/blouseRequest';

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

  evaluateShirt(shirt: ShirtRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/shirt`, shirt);
  }

  evaluateDress(dress: DressRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/dress`, dress);
  }

  evaluatePants(pants: PantsRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/pants`, pants);
  }

  evaluateSkirt(skirt: SkirtRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/skirt`, skirt);
  }

  evaluateSweater(sweater: SweaterRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/sweater`, sweater);
  }

  evaluateTablecloth(tablecloth: TableclothRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/tablecloth`, tablecloth);
  }

  evaluateBedsheet(bedsheet: BedsheetRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/bedsheet`, bedsheet);
  }

  evaluatePillowcase(pillowcase: PillowcaseRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/pillowcase`, pillowcase);
  }

  evaluateCurtain(curtain: CurtainRequest): Observable<RecommendationDTO[]> {
    return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/curtain`, curtain);
  }

  evaluateBlouse(request: BlouseRequest): Observable<RecommendationDTO[]> {
  return this.http.post<RecommendationDTO[]>(`${this.baseUrl}/recommendations/blouse`, request);
}

  getAlertHistory(): Observable<StockAlert[]> {
    return this.http.get<StockAlert[]>(`${this.baseUrl}/alerts`);
  }
}
