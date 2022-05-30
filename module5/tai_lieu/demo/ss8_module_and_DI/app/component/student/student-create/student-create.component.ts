import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../../../model/student";
import {AbstractControl, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {Classroom} from "../../../model/classroom";
import {ClassroomService} from "../../../service/classroom.service";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  student: Student = new Student(0, "", "", 0, new Classroom(1, "C1021G1"));
  @Output() submitCreateStudent = new EventEmitter();
  listClass: Classroom[] = [];

  studentForm: FormGroup;

  constructor(private classroomService: ClassroomService) {
    this.studentForm = new FormGroup({
      id: new FormControl(5),
      name: new FormControl("HaiTT"),
      dateOfBirth: new FormControl("2022-01-02"),
      point: new FormControl(8),
      classroom: new FormControl()
    })
    this.classroomService.findAll().subscribe((next: Classroom[]) => {
      this.listClass = next;
      this.studentForm.controls["classroom"].setValue(this.listClass[0]);
    })
  }

  compareFn(t1: Classroom, t2: Classroom): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }

  ngOnInit(): void {
    console.log("Hello")
  }

  // submitStudent(registerForm: NgForm) {
  //   console.log(registerForm)
  //   this.submitCreateStudent.emit(registerForm.value);
  // }

  ValidationCustomPoint(point: AbstractControl) {
    let value = point.value;
    if (value < 0) {
      return {'invalid0': true};
    } else {
      return null;
    }
  }

  submitStudent() {
    console.log(this.studentForm)
    if (this.studentForm.valid) {
      this.submitCreateStudent.emit(this.studentForm.value);
    }
  }
}
