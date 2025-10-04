import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DressForm } from './dress-form';

describe('DressForm', () => {
  let component: DressForm;
  let fixture: ComponentFixture<DressForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DressForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DressForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
