import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlouseForm } from './blouse-form';

describe('BlouseForm', () => {
  let component: BlouseForm;
  let fixture: ComponentFixture<BlouseForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BlouseForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BlouseForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
