import {Component, Input, OnInit} from "@angular/core";
import {Student} from "../../../model/student";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {StudentService} from "../../../service/student.service";
import {Classroom} from "../../../model/classroom";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  //ts-ignore
  @Input("studentX") student: Student = new Student(0,"haiTT","02/02/2022",9, new Classroom(1,"C1021G1"));

  constructor(private activatedRoute: ActivatedRoute, private studentService: StudentService) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get("id");
      if(id != null) {
        const temp = this.studentService.findById(parseInt(id));
        if(temp !=null) {
          this.student = temp;
        }
      }
    })
  }

  ngOnInit(): void {
  }

  changeNameStudent(target: any) {
    this.student.name = target.value;
  }
}
