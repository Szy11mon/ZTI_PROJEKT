import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModeDeleteComponent } from './mode-delete.component';

describe('ModeDeleteComponent', () => {
  let component: ModeDeleteComponent;
  let fixture: ComponentFixture<ModeDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModeDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModeDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
