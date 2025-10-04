import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableclothForm } from './tablecloth-form';

describe('TableclothForm', () => {
  let component: TableclothForm;
  let fixture: ComponentFixture<TableclothForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableclothForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableclothForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
