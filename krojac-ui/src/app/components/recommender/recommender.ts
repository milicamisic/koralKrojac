import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MATERIAL_IMPORTS } from '../../material';
import { Api } from '../../core/api';
import { Evaluation } from '../../model/evaluation';
import { ShirtRequest } from '../../model/shirtRequest';
import { DressForm } from "../../forms/dress-form/dress-form";
import { ShirtForm } from "../../forms/shirt-form/shirt-form";
import { PantsForm } from "../../forms/pants-form/pants-form";
import { SkirtForm } from "../../forms/skirt-form/skirt-form";
import { SweaterForm } from "../../forms/sweater-form/sweater-form";
import { CurtainForm } from "../../forms/curtain-form/curtain-form";
import { TableclothForm } from "../../forms/tablecloth-form/tablecloth-form";
import { BedsheetForm } from "../../forms/bedsheet-form/bedsheet-form";
import { PillowcaseForm } from "../../forms/pillowcase-form/pillowcase-form";


@Component({
  selector: 'app-recommender',
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ...MATERIAL_IMPORTS,
    DressForm,
    ShirtForm,
    PantsForm,
    SkirtForm,
    SweaterForm,
    CurtainForm,
    TableclothForm,
    BedsheetForm,
    PillowcaseForm
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

    clothingItems = ['Shirt', 'Dress', 'Skirt', 'Pants', 'Sweater'];
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
        bust: values.chestCircumference,
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
      this.form.reset(); // očisti prethodne vrednosti forme
    }

    selectItem(item: string) {
      this.selectedItem = item;
      this.form.reset();
    }

}
