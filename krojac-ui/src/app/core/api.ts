import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fabric } from '../model/fabric';
import { ShirtRequest } from '../model/shirtRequest';
import { Evaluation } from '../model/evaluation';
import { StockAlert } from './alert';
import { DressRequest } from '../model/dressRequest';
import { PantsRequest } from '../model/pantsRequest';
import { SkirtRequest } from '../model/skirtRequest';
import { SweaterRequest } from '../model/sweaterRequest';
import { TableclothRequest } from '../model/tableclothRequest';
import { BedsheetRequest } from '../model/bedsheetRequest';
import { PillowcaseRequest } from '../model/pillowcaseRequest';
import { CurtainRequest } from '../model/curtainRequest';

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
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/shirt`, { shirtRequest: shirt });
  }

  evaluateDress(dress: DressRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/dress`, { dressRequest: dress });
  }

  evaluatePants(pants: PantsRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/pants`, { pantsRequest: pants });
  }

  evaluateSkirt(skirt: SkirtRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/skirt`, { skirtRequest: skirt });
  }

  evaluateSweater(sweater: SweaterRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/sweater`, { sweaterRequest: sweater });
  }

  evaluateTablecloth(tablecloth: TableclothRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/tablecloth`, { tableclothRequest: tablecloth });
  }

  evaluateBedsheet(bedsheet: BedsheetRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/bedsheet`, { bedsheetRequest: bedsheet });
  }

  evaluatePillowcase(pillowcase: PillowcaseRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/pillowcase`, { pillowcaseRequest: pillowcase });
  }

  evaluateCurtain(curtain: CurtainRequest): Observable<Evaluation> {
    return this.http.post<Evaluation>(`${this.baseUrl}/recommendations/curtain`, { curtainRequest: curtain });
  }

  getAlertHistory(): Observable<StockAlert[]> {
    return this.http.get<StockAlert[]>(`${this.baseUrl}/alerts`);
  }
}
