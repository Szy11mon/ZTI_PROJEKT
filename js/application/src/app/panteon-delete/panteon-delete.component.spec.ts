import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanteonDeleteComponent } from './panteon-delete.component';

describe('PanteonDeleteComponent', () => {
  let component: PanteonDeleteComponent;
  let fixture: ComponentFixture<PanteonDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanteonDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanteonDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
