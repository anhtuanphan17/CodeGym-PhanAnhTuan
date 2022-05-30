import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent} from "./component/student/student-list/student-list.component";
import {StudentInfoComponent} from "./component/student/student-info/student-info.component";

const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
