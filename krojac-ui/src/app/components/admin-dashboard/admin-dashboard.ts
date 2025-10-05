import { Component } from '@angular/core';
import { AlertService, StockAlert } from '../../core/alert';
import { Subscription } from 'rxjs';
import { Api } from '../../core/api';
import { FormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-admin-dashboard',
  imports: [FormsModule, MatSnackBarModule, ...MATERIAL_IMPORTS],
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.scss'
})
export class AdminDashboard {
  alerts: StockAlert[] = [];
  private sub!: Subscription;

  purchase = { fabricName: '', quantity: null as number | null };

  constructor(private alertService: AlertService, private api: Api, private snack: MatSnackBar) {}

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

  submitPurchase() {
    if (!this.purchase.fabricName || !this.purchase.quantity) {
      this.snack.open('Popunite sva polja!', 'OK', { duration: 2500 });
      return;
    }

    this.api
      .makePurchase(this.purchase.fabricName, this.purchase.quantity)
      .subscribe({
        next: () => {
          this.snack.open(
            `✅ Nabavka uspešno dodata (${this.purchase.fabricName}, ${this.purchase.quantity}m)`,
            'Zatvori',
            { duration: 3000 }
          );
          this.purchase = { fabricName: '', quantity: null };
        },
        error: () => {
          this.snack.open('❌ Greška pri unosu nabavke!', 'Zatvori', { duration: 3000 });
        }
      });
  }
}
