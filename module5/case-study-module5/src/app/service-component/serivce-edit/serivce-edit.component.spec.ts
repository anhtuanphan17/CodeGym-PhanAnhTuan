import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SerivceEditComponent } from './serivce-edit.component';

describe('SerivceEditComponent', () => {
  let component: SerivceEditComponent;
  let fixture: ComponentFixture<SerivceEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SerivceEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SerivceEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
