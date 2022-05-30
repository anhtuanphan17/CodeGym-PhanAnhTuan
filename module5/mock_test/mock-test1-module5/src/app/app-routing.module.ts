import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ProductListComponent} from "./component/product/product-list/product-list.component";
import {CategoryListComponent} from "./component/category/category-list/category-list.component";
import {ProductCreateComponent} from "./component/product/product-create/product-create.component";
import {ProductEditComponent} from "./component/product/product-edit/product-edit.component";
import {CategoryCreateComponent} from "./component/category/category-create/category-create.component";
import {CategoryEditComponent} from "./component/category/category-edit/category-edit.component";

const routes: Routes = [
  {path: 'product/list', component:ProductListComponent},
  {path: 'product/create', component:ProductCreateComponent},
  {path: 'product/edit/:id', component:ProductEditComponent},
  {path: 'category/list', component:CategoryListComponent},
  {path: 'category/create', component:CategoryCreateComponent},
  {path: 'category/edit/:id', component:CategoryEditComponent}
];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
