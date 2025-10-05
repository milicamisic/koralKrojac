import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { RecommendationDTO } from '../../model/recommendationDTO';
import { CurtainRequest } from '../../model/curtainRequest';

@Component({
  selector: 'app-curtain-form',
  imports: [CommonModule, ReactiveFormsModule, ...MATERIAL_IMPORTS],
  templateUrl: './curtain-form.html',
  styleUrl: './curtain-form.scss'
})
export class CurtainForm {
  @Output() result = new EventEmitter<RecommendationDTO[]>();
  form!: FormGroup;

  hangingTypes = ['HOOKS', 'RINGS', 'CHANNEL'];
  pleatFactors = [1.5, 2, 2.5, 3];

  constructor(private fb: FormBuilder, private api: Api) {
    this.form = this.fb.group({
      height: [null, [Validators.required, Validators.min(100)]],
      width: [null, [Validators.required, Validators.min(50)]],
      marginTop: [null, [Validators.required, Validators.min(0)]],
      marginBottom: [null, [Validators.required, Validators.min(0)]],
      pleatFactor: [2, Validators.required],
      hangingType: ['HOOKS', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const req = new CurtainRequest(this.form.value);
      console.log('Submitting Curtain request:', req);

      this.api.evaluateCurtain(req).subscribe({
        next: (res) => {
          console.log('Response from backend:', res);
          this.result.emit(res);
        },
        error: (err) => console.error('Error from backend:', err)
      });
    }
  }
}