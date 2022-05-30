import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerCreateComponent} from "./customer-create/customer-create.component";
import {CustomerEditComponent} from "./customer-edit/customer-edit.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "../shared/shared.module";
import {NgxPaginationModule} from "ngx-pagination";


@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    SharedModule,
    NgxPaginationModule,
    FormsModule,
  ]
})
export class CustomerModule { }
