import {Classroom} from "./classroom";

export class Student {
  id: number;
  name: string;
  dateOfBirth: string;
  point: number;
  classroom: Classroom;


  constructor(id: number, name: string, dateOfBirth: string, point: number, classroom: Classroom) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.point = point;
    this.classroom = classroom;
  }
}
