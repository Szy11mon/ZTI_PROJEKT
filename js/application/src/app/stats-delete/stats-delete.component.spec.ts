import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatsDeleteComponent } from './stats-delete.component';

describe('StatsDeleteComponent', () => {
  let component: StatsDeleteComponent;
  let fixture: ComponentFixture<StatsDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatsDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatsDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
