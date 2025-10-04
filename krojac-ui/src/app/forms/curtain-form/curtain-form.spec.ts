import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurtainForm } from './curtain-form';

describe('CurtainForm', () => {
  let component: CurtainForm;
  let fixture: ComponentFixture<CurtainForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CurtainForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CurtainForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
