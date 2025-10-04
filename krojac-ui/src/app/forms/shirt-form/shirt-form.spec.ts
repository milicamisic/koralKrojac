import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShirtForm } from './shirt-form';

describe('ShirtForm', () => {
  let component: ShirtForm;
  let fixture: ComponentFixture<ShirtForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShirtForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShirtForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
