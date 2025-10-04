import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { BedsheetRequest } from '../../model/bedsheetRequest';

@Component({
  selector: 'app-bedsheet-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './bedsheet-form.html',
  styleUrl: './bedsheet-form.scss'
})
export class BedsheetForm {
 @Output() result = new EventEmitter<Evaluation>();
  form!: FormGroup;

  sheetTypes = ['FITTED', 'FLAT'];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      type: ['FITTED', Validators.required],
      length: [null, [Validators.required, Validators.min(100)]],
      width: [null, [Validators.required, Validators.min(50)]],
      height: [null, [Validators.required, Validators.min(10)]],
      overhang: [0]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const req = new BedsheetRequest(this.form.value);
      this.api.evaluateBedsheet(req).subscribe({
        next: (res) => this.result.emit(res),
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}