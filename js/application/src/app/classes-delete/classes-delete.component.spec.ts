import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassesDeleteComponent } from './classes-delete.component';

describe('ClassesDeleteComponent', () => {
  let component: ClassesDeleteComponent;
  let fixture: ComponentFixture<ClassesDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClassesDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassesDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
