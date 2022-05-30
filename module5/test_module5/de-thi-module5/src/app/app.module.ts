import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import { NavigationComponent } from './component/navigation/navigation.component';
import { TinListComponent } from './component/tin/tin-list/tin-list.component';
import { TinCreateComponent } from './component/tin/tin-create/tin-create.component';
import { TinEditComponent } from './component/tin/tin-edit/tin-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    TinListComponent,
    TinCreateComponent,
    TinEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
