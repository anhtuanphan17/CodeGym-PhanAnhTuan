import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product/product-list/product-list.component';
import { ProductCreateComponent } from './component/product/product-create/product-create.component';
import { ProductEditComponent } from './component/product/product-edit/product-edit.component';
import { CategoryListComponent } from './component/category/category-list/category-list.component';
import { CategoryCreateComponent } from './component/category/category-create/category-create.component';
import { CategoryEditComponent } from './component/category/category-edit/category-edit.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NavigationComponent } from './component/navigation/navigation.component';
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
    CategoryListComponent,
    CategoryCreateComponent,
    CategoryEditComponent,
    NavigationComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
