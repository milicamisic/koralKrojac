import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PantsForm } from './pants-form';

describe('PantsForm', () => {
  let component: PantsForm;
  let fixture: ComponentFixture<PantsForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PantsForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PantsForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
