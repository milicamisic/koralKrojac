import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
@Component({
  selector: 'app-shirt-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './shirt-form.html',
  styleUrl: './shirt-form.scss'
})
export class ShirtForm {
@Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  fitOptions = ['STANDARD', 'SLIM', 'OVERSIZED'];
  sleeveTypes = ['NONE', 'SHORT', 'LONG'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      chestCircumference: [null, [Validators.required, Validators.min(50)]],
      torsoLength: [null, [Validators.required, Validators.min(40)]],
      shoulderWidth: [null, [Validators.required, Validators.min(30)]],
      sleeveLength: [null],
      sleeveType: ['NONE', Validators.required],
      fit: ['STANDARD', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      console.log('Submitting Shirt request:', this.form.value);
      this.api.evaluateShirt(this.form.value).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}
