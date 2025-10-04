import { Injectable, OnDestroy } from '@angular/core';
import { Client, IMessage } from '@stomp/stompjs';
import { BehaviorSubject, Observable } from 'rxjs';

export interface StockAlert {
  fabric: string;
  type: string;
  message?: string;
}

@Injectable({
  providedIn: 'root',
})
export class AlertService implements OnDestroy {
  private stompClient!: Client;
  private alerts$ = new BehaviorSubject<StockAlert | null>(null);

  constructor() {}

  connect(): void {
    // ako je već povezan, ne povezuj opet
    if (this.stompClient && this.stompClient.active) {
      return;
    }

    this.stompClient = new Client({
      brokerURL: 'ws://localhost:8080/ws', // direktno WebSocket
      reconnectDelay: 5000, // auto reconnect
      debug: (str) => console.log(str),
    });

    this.stompClient.onConnect = () => {
      console.log('✅ Connected to WebSocket');
      this.stompClient.subscribe('/topic/alerts', (message: IMessage) => {
        console.log("📩 [Frontend] Poruka stigla RAW:", message.body);
        try {
          const alert: StockAlert = JSON.parse(message.body);
          console.log('🚨 Novi alert:', alert);
          this.alerts$.next(alert);
        } catch (err) {
          console.error('❌ Error parsing alert', err);
        }
      });
    };

    this.stompClient.onStompError = (frame) => {
      console.error('Broker reported error: ' + frame.headers['message']);
      console.error('Additional details: ' + frame.body);
    };

    this.stompClient.activate();
  }

  disconnect(): void {
    if (this.stompClient && this.stompClient.active) {
      this.stompClient.deactivate();
      console.log('🔌 Disconnected from WebSocket');
    }
  }

  getAlerts(): Observable<StockAlert | null> {
    return this.alerts$.asObservable();
  }

  ngOnDestroy(): void {
    this.disconnect();
  }
}
