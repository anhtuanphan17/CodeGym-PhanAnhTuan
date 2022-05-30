import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import {CategoryComponent} from "./category-list/category.component";
import {CategoryCreateComponent} from "./category-create/category-create.component";
import {CategoryEditComponent} from "./category-edit/category-edit.component";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    CategoryComponent,
    CategoryCreateComponent,
    CategoryEditComponent,

  ],
  imports: [
    CommonModule,
    CategoryRoutingModule,
    HttpClientModule
  ]
})
export class CategoryModule { }
