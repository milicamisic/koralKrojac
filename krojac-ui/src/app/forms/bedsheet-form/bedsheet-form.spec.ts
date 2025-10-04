import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BedsheetForm } from './bedsheet-form';

describe('BedsheetForm', () => {
  let component: BedsheetForm;
  let fixture: ComponentFixture<BedsheetForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BedsheetForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BedsheetForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
