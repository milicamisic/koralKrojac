import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
@Component({
  selector: 'app-pants-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './pants-form.html',
  styleUrl: './pants-form.scss'
})
export class PantsForm {
@Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  fitOptions = ['STANDARD', 'SLIM', 'LOOSE'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      waist: [null, [Validators.required, Validators.min(50)]],
      hips: [null, [Validators.required, Validators.min(50)]],
      inseam: [null, [Validators.required, Validators.min(50)]],  // unutrašnja dužina
      outseam: [null, [Validators.required, Validators.min(50)]],  // spoljašnja dužina
      fit: ['STANDARD', Validators.required],
      stretchPercent: [null] // dodatno polje ako backend podržava rastegljivost
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log('Submitting Pants request:', this.form.value);
      this.api.evaluatePants(this.form.value).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}
