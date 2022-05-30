import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DictionaryPageComponent } from './dictionary-page/dictionary-page.component';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {DictionaryDetailsPageComponent} from './dictionary-details-page/dictionary-details-page.component';

@NgModule({
  declarations: [
    AppComponent,
    DictionaryPageComponent,
    DictionaryDetailsPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
