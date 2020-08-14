import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModesFormComponent } from './modes-form.component';

describe('ModesFormComponent', () => {
  let component: ModesFormComponent;
  let fixture: ComponentFixture<ModesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
