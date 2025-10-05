import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Api } from '../../core/api';
import { Fabric } from '../../model/fabric';
import { MATERIAL_IMPORTS } from '../../material';
import { MatSnackBar } from '@angular/material/snack-bar'; 
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home implements OnInit {
  fabrics: Fabric[] = [];
  loading = true;

  constructor(private api: Api, private snackBar: MatSnackBar) {} // ✅ dodaj snackbar

  ngOnInit(): void {
    this.api.getFabrics().subscribe({
      next: (data) => {
        this.fabrics = data.map(f => ({ ...f, qty: 1 }));
        this.loading = false;
      },
      error: () => {
        this.loading = false;
        this.showToast('❌ Greška pri učitavanju materijala.', true);
      }
    });
  }

  buyFabric(fabric: Fabric) {
    const qty = fabric.qty || 1;

    this.api.createSaleEvent(fabric.name, qty).subscribe({
      next: () => this.showToast(`✅ Kupljeno ${qty}m materijala: ${fabric.name}`),
      error: (err) => this.showToast(`❌ Greška pri kupovini: ${err.message}`, true)
    });
  }

  private showToast(message: string, isError = false) {
    this.snackBar.open(message, 'Zatvori', {
      duration: 2500,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      panelClass: isError ? ['toast-error'] : ['toast-success']
    });
  }
}