import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanteonListComponent } from './panteon-list.component';

describe('PanteonListComponent', () => {
  let component: PanteonListComponent;
  let fixture: ComponentFixture<PanteonListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanteonListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanteonListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
