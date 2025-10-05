import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { RecommendationDTO } from '../../model/recommendationDTO';
import { SweaterRequest } from '../../model/sweaterRequest';

@Component({
  selector: 'app-sweater-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './sweater-form.html',
  styleUrl: './sweater-form.scss'
})
export class SweaterForm {
 @Output() result = new EventEmitter<RecommendationDTO[]>();
  form!: FormGroup;

  fitOptions = ['STANDARD', 'SLIM', 'LOOSE'];
  yarnOptions = ['THIN', 'MEDIUM', 'THICK'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      bust: [null, [Validators.required, Validators.min(50)]],
      torsoLength: [null, [Validators.required, Validators.min(40)]],
      sleeveLength: [null, [Validators.required, Validators.min(20)]],
      shoulderWidth: [null, [Validators.required, Validators.min(30)]],
      fit: ['STANDARD', Validators.required],
      yarnThickness: ['MEDIUM', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const request = new SweaterRequest(this.form.value);
      console.log('Submitting Sweater request:', request);

      this.api.evaluateSweater(request).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}