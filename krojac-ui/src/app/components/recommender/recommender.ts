import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { ShirtRequest } from '../../model/shirtRequest';

@Component({
  selector: 'app-recommender',
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ...MATERIAL_IMPORTS
  ],
  templateUrl: './recommender.html',
  styleUrl: './recommender.scss'
})
export class Recommender {
    category: string | null = null;
    selectedItem: string | null = null;
    form: FormGroup;
    result: Evaluation = {
                            baseLength: 0,
                            totalLength: 0,
                            recommendedFabrics: [],
                            messages: [],
                            warnings: []
                          };

    categories = ['Clothing', 'Decoration'];

    clothingItems = ['T-shirt', 'Shirt', 'Dress', 'Skirt', 'Pants', 'Sweater'];
    decorationItems = ['Tablecloth', 'Bedsheet', 'Pillowcase', 'Curtain'];

    itemTypes = ['Shirt', 'Pants', 'Dress'];

    constructor(private fb: FormBuilder, private api: Api) {
      this.form = this.fb.group({
        itemType: ['', Validators.required],
        chestCircumference: [null, Validators.required],
        torsoLength: [null, Validators.required],
        hasSleeves: [true],
        sleeveLength: [null],
        shoulderWidth: [null],
        fit: ['STANDARD', Validators.required]
      });
    }

    // onSubmit() {
    //   if (this.form.valid) {
    //     this.api.getRecommendation(this.form.value).subscribe({
    //       next: (res) => this.result = res,
    //       error: (err) => console.error(err)
    //     });
    //   }
    // }

    onSubmit() {
      const values = this.form.value;

      const shirtRequest: ShirtRequest = {
        chestCircumference: values.chestCircumference,
        torsoLength: values.torsoLength,
        hasSleeves: values.sleeveLength > 0,
        sleeveLength: values.sleeveLength,
        shoulderWidth: values.shoulderWidth,
        fit: values.fit
      };
      this.api.evaluateShirt(shirtRequest)
          .subscribe({
            next: (res) => {
              this.result = res
              console.log('Response from backend', res)},
            error: (err) => console.error('Error from backend', err)
          });
    }

    selectCategory(cat: string) {
        this.category = cat;
        this.selectedItem = null; // reset when switching category
    }

    selectItem(item: string) {
        this.selectedItem = item;
    }

}
