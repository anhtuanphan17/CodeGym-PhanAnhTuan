import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {StudentInfoComponent} from "./student-info/student-info.component";
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentCreateComponent} from "./student-create/student-create.component";
import {StudentComponent} from "./student.component";
import {RouterModule} from "@angular/router";
import {StudentRoutingModule} from "./student-routing.module";
import {ShareModule} from "../shared/share.module";



@NgModule({
  declarations: [
    StudentInfoComponent,
    StudentListComponent,
    StudentCreateComponent,
    StudentComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ShareModule,
    StudentRoutingModule
  ]
})
export class StudentModule { }
