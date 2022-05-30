import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentInfoComponent} from "./student-info/student-info.component";
import {StudentComponent} from "./student.component";

const routes: Routes = [
  {path:"student", component: StudentComponent,canActivate:[], children: [
      {path:"", component: StudentListComponent},
      {path:"detail/:id", component: StudentInfoComponent}
    ]}


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
