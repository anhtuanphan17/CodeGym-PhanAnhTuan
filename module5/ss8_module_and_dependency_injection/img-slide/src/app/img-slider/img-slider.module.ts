import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImgSliderComponent } from './img-slider.component';
import { ImgSlideComponent } from './img-slide/img-slide.component';
import {NgImageSliderModule} from "ng-image-slider";



@NgModule({
  declarations: [ImgSliderComponent, ImgSlideComponent],
  exports: [
    ImgSliderComponent,
    ImgSlideComponent
  ],
  imports: [
    CommonModule,
    NgImageSliderModule,

  ]
})
export class ImgSliderModule { }
