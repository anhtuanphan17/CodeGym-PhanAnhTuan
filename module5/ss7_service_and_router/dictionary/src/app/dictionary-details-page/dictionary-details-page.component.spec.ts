import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryDetailsPageComponent } from './dictionary-details-page.component';

describe('DictionaryDetailsPageComponent', () => {
  let component: DictionaryDetailsPageComponent;
  let fixture: ComponentFixture<DictionaryDetailsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryDetailsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
