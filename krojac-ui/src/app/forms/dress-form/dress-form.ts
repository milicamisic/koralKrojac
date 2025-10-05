import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { DressRequest } from '../../model/dressRequest';
import { RecommendationDTO } from '../../model/recommendationDTO';

@Component({
  selector: 'app-dress-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './dress-form.html',
  styleUrl: './dress-form.scss'
})
export class DressForm {
  @Output() result = new EventEmitter<RecommendationDTO[]>();
  form!: FormGroup; // samo deklaracija, bez inicijalizacije

  dressTypes = ['A-line', 'Circle', 'Bodycon', 'Shift'];
  sleeveTypes = ['NONE', 'SHORT', 'LONG'];

  constructor(private fb: FormBuilder, private api: Api) {
    // ✅ Inicijalizacija forme ide ovde
    this.form = this.fb.group({
      type: ['A-line', Validators.required],
      bust: [null, [Validators.required, Validators.min(50)]],
      waist: [null, [Validators.required, Validators.min(50)]],
      hips: [null, [Validators.required, Validators.min(50)]],
      shoulder: [null, [Validators.required, Validators.min(30)]],
      height: [null, [Validators.required, Validators.min(100)]],
      length: [null, [Validators.required, Validators.min(50)]],
      wrap: [false],
      sleeveType: ['NONE', Validators.required]
    });
  }

  onSubmit() {
  if (this.form.valid) {
    console.log('Submitting Dress request:', this.form.value);
    const request = new DressRequest(this.form.value); // ✅ koristi klasu, ne plain object
    console.log('Submitting Dress request:', request);

    this.api.evaluateDress(request).subscribe({
      next: (res) => {
        console.log('Response from backend:', res);
        this.result.emit(res);
      },
      error: (err) => console.error('Error from backend:', err)
    });
  }
}
}