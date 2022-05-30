import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {NgImageSliderModule} from "ng-image-slider";
import {ImgSliderModule} from "./img-slider/img-slider.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    NgImageSliderModule,
    ImgSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
