import { Component } from '@angular/core';
import { AlertService, StockAlert } from '../../core/alert';
import { Subscription } from 'rxjs';
import { Api } from '../../core/api';

@Component({
  selector: 'app-admin-dashboard',
  imports: [],
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.scss'
})
export class AdminDashboard {
  alerts: StockAlert[] = [];
  private sub!: Subscription;

  constructor(private alertService: AlertService, private api: Api) {}

  ngOnInit(): void {
    // prvo pokupi istoriju
    // this.api.getAlertHistory().subscribe(alerts => {
    //   for (const alert of alerts) {
    //     this.alerts.push(alert);
    //   }
    // });
    
    this.alertService.connect();
    this.sub = this.alertService.getAlerts().subscribe(alert => {
      if (alert) {
        this.alerts.push(alert);
      }
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
    this.alertService.disconnect();
  }
}
