import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MATERIAL_IMPORTS } from '../../material';
import { DressForm } from "../../forms/dress-form/dress-form";
import { ShirtForm } from "../../forms/shirt-form/shirt-form";
import { PantsForm } from "../../forms/pants-form/pants-form";
import { SkirtForm } from "../../forms/skirt-form/skirt-form";
import { SweaterForm } from "../../forms/sweater-form/sweater-form";
import { CurtainForm } from "../../forms/curtain-form/curtain-form";
import { TableclothForm } from "../../forms/tablecloth-form/tablecloth-form";
import { BedsheetForm } from "../../forms/bedsheet-form/bedsheet-form";
import { PillowcaseForm } from "../../forms/pillowcase-form/pillowcase-form";
import { BlouseForm } from "../../forms/blouse-form/blouse-form";
import { RecommendationDTO } from '../../model/recommendationDTO';


@Component({
  selector: 'app-recommender',
  imports: [
    CommonModule,
    ...MATERIAL_IMPORTS,
    DressForm,
    ShirtForm,
    PantsForm,
    SkirtForm,
    SweaterForm,
    CurtainForm,
    TableclothForm,
    BedsheetForm,
    PillowcaseForm,
    BlouseForm
],
  templateUrl: './recommender.html',
  styleUrl: './recommender.scss'
})
export class Recommender {
    category: string | null = null;
    selectedItem: string | null = null;
    result: RecommendationDTO[] = [];
    categories = ['Clothing', 'Decoration'];

    clothingItems = ['Shirt', 'Dress', 'Skirt', 'Pants', 'Blouse']; // todo sweater
    decorationItems = ['Tablecloth', 'Bedsheet', 'Pillowcase', 'Curtain'];

    selectCategory(cat: string) {
    this.category = cat;
    this.selectedItem = null;
  }

    selectItem(item: string) {
      this.selectedItem = item;
    }

}
