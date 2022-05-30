import {Component, OnInit} from '@angular/core';
import {ToDoList} from '../model/to-do-list';
import {FormControl, FormGroup} from '@angular/forms';
import {ToDoListService} from '../service/to-do-list.service';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent implements OnInit {

  todos: ToDoList[] = [];

  todoForm: FormGroup = new FormGroup({
    id: new FormControl(),
    content: new FormControl(),
    complete: new FormControl(false)
  });

  // @ts-ignore
  todo: Todo;

  content = new FormControl();

  constructor(private todoService: ToDoListService) {
  }

  getAll() {
    this.todoService.getAll().subscribe(res => {
      this.todos = res;
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  delete(id: number) {
    this.todoService.getById(id).subscribe(res => {
      this.todo = res;
      this.todo.complete = !this.todo.complete;
      console.log(this.todo);
      this.todoService.update(this.todo.id, this.todo).subscribe(() => {
        this.getAll();
        console.log('Complete!');
      });
      this.getAll();
    });
  }

  submit() {
    this.todo = this.todoForm.value;
    this.todoService.save(this.todo).subscribe(() => {
      this.todoForm.reset();
      this.getAll();
      console.log('Add success!');
    });
  }
}
