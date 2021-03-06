import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayedMatchComponent } from './played-match.component';

describe('PlayedMatchComponent', () => {
  let component: PlayedMatchComponent;
  let fixture: ComponentFixture<PlayedMatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayedMatchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayedMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
