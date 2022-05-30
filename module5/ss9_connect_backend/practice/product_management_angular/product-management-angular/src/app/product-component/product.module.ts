import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import {ProductComponentComponent} from "./product-list/product-component.component";
import {ProductCreateComponent} from "./product-create/product-create.component";
import {ProductEditComponent} from "./product-edit/product-edit.component";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    ProductComponentComponent,
    ProductCreateComponent,
    ProductEditComponent,
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class ProductModule { }
