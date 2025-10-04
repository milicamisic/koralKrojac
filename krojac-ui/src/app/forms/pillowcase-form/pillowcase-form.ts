import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { PillowcaseRequest } from '../../model/pillowcaseRequest';


@Component({
  selector: 'app-pillowcase-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './pillowcase-form.html',
  styleUrl: './pillowcase-form.scss'
})
export class PillowcaseForm {
@Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      length: [null, [Validators.required, Validators.min(30)]],
      width: [null, [Validators.required, Validators.min(30)]]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const req = new PillowcaseRequest(this.form.value);
      this.api.evaluatePillowcase(req).subscribe({
        next: (res) => this.result.emit(res),
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}
