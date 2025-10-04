import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { SkirtRequest } from '../../model/skirtRequest';
@Component({
  selector: 'app-skirt-form',
imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './skirt-form.html',
  styleUrl: './skirt-form.scss'
})
export class SkirtForm {
@Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  skirtTypes = ['A-line', 'Pencil', 'Circle'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      type: ['A-line', Validators.required],
      waist: [null, [Validators.required, Validators.min(50)]],
      hips: [null, [Validators.required, Validators.min(50)]],
      length: [null, [Validators.required, Validators.min(30)]],
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const request = new SkirtRequest(this.form.value);
      console.log('Submitting Skirt request:', request);
      this.api.evaluateSkirt(request).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}
