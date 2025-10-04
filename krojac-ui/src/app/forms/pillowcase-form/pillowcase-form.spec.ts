import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PillowcaseForm } from './pillowcase-form';

describe('PillowcaseForm', () => {
  let component: PillowcaseForm;
  let fixture: ComponentFixture<PillowcaseForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PillowcaseForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PillowcaseForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
