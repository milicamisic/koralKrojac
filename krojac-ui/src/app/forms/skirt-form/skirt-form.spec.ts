import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkirtForm } from './skirt-form';

describe('SkirtForm', () => {
  let component: SkirtForm;
  let fixture: ComponentFixture<SkirtForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SkirtForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SkirtForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
