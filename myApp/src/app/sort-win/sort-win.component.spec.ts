import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortWinComponent } from './sort-win.component';

describe('SortWinComponent', () => {
  let component: SortWinComponent;
  let fixture: ComponentFixture<SortWinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortWinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortWinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
