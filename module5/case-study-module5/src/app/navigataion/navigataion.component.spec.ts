import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigataionComponent } from './navigataion.component';

describe('NavigataionComponent', () => {
  let component: NavigataionComponent;
  let fixture: ComponentFixture<NavigataionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavigataionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigataionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
