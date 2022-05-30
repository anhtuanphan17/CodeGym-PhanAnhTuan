import {Component, OnInit} from '@angular/core';
import {Student} from "../../../model/student";
import {StudentService} from "../../../service/student.service";
import {Router} from "@angular/router";
import {Classroom} from "../../../model/classroom";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
 students: Student[] =[];
  studentTemp: Student = new Student(0,"haiTT","02/02/2022",9, new Classroom(2,"C1221G1"));

  constructor(private studentService: StudentService, private router: Router) {
  }

  ngOnInit(): void {
    this.studentService.findAll().subscribe((data: Student[]) => {
      this.students = data;
    });
  }

  detailStudent(student: Student) {
    this.studentTemp = student;
  }

  createStudent(event: any) {
    this.studentService.addStudent(event).subscribe(next => {

    }, error => {

    }, () => {
      this.ngOnInit();
    });

  }

}
