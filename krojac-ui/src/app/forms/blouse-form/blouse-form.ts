import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { RecommendationDTO } from '../../model/recommendationDTO';
import { BlouseRequest } from '../../model/blouseRequest';

@Component({
  selector: 'app-blouse-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './blouse-form.html',
  styleUrl: './blouse-form.scss'
})
export class BlouseForm {
 @Output() result = new EventEmitter<RecommendationDTO[]>();
  form!: FormGroup;

  collarTypes = ['none', 'classic', 'mandarin', 'oversized'];
  sleeveTypes = ['NONE', 'SHORT', 'LONG'];
  fitTypes = ['LOOSE', 'SLIM', 'STANDARD'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      bust: [null, [Validators.required, Validators.min(50)]],
      waist: [null, [Validators.required, Validators.min(50)]],
      torsoLength: [null, [Validators.required, Validators.min(30)]],
      shoulder: [null, [Validators.required, Validators.min(30)]],
      neck: [null, [Validators.required, Validators.min(30)]],
      collarType: ['none', Validators.required],
      sleeveType: ['NONE', Validators.required],
      fit: ['STANDARD', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log('Submitting Blouse request:', this.form.value);
      const request = this.form.value as BlouseRequest;

      this.api.evaluateBlouse(request).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}