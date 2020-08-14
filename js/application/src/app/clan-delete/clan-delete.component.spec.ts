import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClanDeleteComponent } from './clan-delete.component';

describe('ClanDeleteComponent', () => {
  let component: ClanDeleteComponent;
  let fixture: ComponentFixture<ClanDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClanDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClanDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
