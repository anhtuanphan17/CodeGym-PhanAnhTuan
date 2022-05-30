import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServiceRoutingModule } from './service-routing.module';
import {ServiceListComponent} from "./service-list/service-list.component";
import {SerivceEditComponent} from "./serivce-edit/serivce-edit.component";
import {ServiceCreateComponent} from "./service-create/service-create.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "../shared/shared.module";


@NgModule({
    declarations: [
        ServiceListComponent,
        SerivceEditComponent,
        ServiceCreateComponent,
    ],
    exports: [
        ServiceListComponent
    ],
    imports: [
        CommonModule,
        ServiceRoutingModule,
        ReactiveFormsModule,
        SharedModule,
        FormsModule,
    ]
})
export class ServiceModule { }
