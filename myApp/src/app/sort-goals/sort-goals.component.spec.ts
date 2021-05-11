import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortGoalsComponent } from './sort-goals.component';

describe('SortGoalsComponent', () => {
  let component: SortGoalsComponent;
  let fixture: ComponentFixture<SortGoalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortGoalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortGoalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
