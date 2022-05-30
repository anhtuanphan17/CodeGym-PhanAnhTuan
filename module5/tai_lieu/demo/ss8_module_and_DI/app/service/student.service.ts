import { Injectable } from '@angular/core';
import {Student} from "../model/student";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StudentListComponent} from "../component/student/student-list/student-list.component";
import {StudentModule} from "../component/student/student.module";

@Injectable({
  providedIn: "root"
})
export class StudentService {
  students : Array<Student> = [];
  constructor(private httpClient: HttpClient) {
    // this.students.push(new Student(1,"HaiTT", "04-30-1998",7));
    // this.students.push(new Student(2,"HaiTT1", "01/22/1998",6));
    // this.students.push(new Student(3,"HaiTT2", "01/20/1998",7));
  }

  addStudent(student: any) {
    return this.httpClient.post("http://localhost:3000/student",student)
  }

  findAll() :Observable<any>{
    return this.httpClient.get("http://localhost:3000/student");
  }

  findById(id: number) {
    for(let student of this.students) {
      if(student.id == id) {
        return student
      }
    }
    return null;
  }
}
