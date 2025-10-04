import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { MATERIAL_IMPORTS } from './material';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    RouterLink,
    ...MATERIAL_IMPORTS
  ],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('krojac-ui');
}
