import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Api } from '../../core/api';
import { Fabric } from '../../model/fabric';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home implements OnInit {
  fabrics: Fabric[] = [];
  loading = true;

  constructor(private api: Api) {}

  ngOnInit(): void {
    this.api.getFabrics().subscribe({
      next: (data) => {
        this.fabrics = data;
        console.log(this.fabrics);
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }
}