import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PanteonFormComponent } from './panteon-form.component';

describe('PanteonFormComponent', () => {
  let component: PanteonFormComponent;
  let fixture: ComponentFixture<PanteonFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PanteonFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PanteonFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
