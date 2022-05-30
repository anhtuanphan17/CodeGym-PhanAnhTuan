import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryComponent } from './category-component/category-list/category.component';
import { HttpClientModule} from '@angular/common/http';
import { CategoryCreateComponent } from './category-component/category-create/category-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CategoryEditComponent } from './category-component/category-edit/category-edit.component';
import {SharedModule} from "./shared/shared.module";
import {ProductModule} from "./product-component/product.module";
import {CategoryModule} from "./category-component/category.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    ProductModule,
    CategoryModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
