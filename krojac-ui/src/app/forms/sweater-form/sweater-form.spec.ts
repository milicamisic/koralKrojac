import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SweaterForm } from './sweater-form';

describe('SweaterForm', () => {
  let component: SweaterForm;
  let fixture: ComponentFixture<SweaterForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SweaterForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SweaterForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
