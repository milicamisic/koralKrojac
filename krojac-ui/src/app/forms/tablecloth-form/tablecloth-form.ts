import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { TableclothRequest } from '../../model/tableclothRequest';

@Component({
  selector: 'app-tablecloth-form',
 imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './tablecloth-form.html',
  styleUrl: './tablecloth-form.scss'
})
export class TableclothForm {
@Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  shapes = ['RECTANGULAR', 'SQUARE', 'ROUND'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      shape: ['RECTANGULAR', Validators.required],
      length: [null, [Validators.required, Validators.min(50)]],
      width: [null, [Validators.required, Validators.min(50)]],
      overhang: [20, [Validators.required, Validators.min(0)]]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const req = new TableclothRequest(this.form.value);
      this.api.evaluateTablecloth(req).subscribe({
        next: (res) => this.result.emit(res),
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}
