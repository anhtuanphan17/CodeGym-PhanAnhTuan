import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ToDoList} from '../model/to-do-list';

@Injectable({
  providedIn: 'root'
})
export class ToDoListService {
  todoApi = 'http://localhost:3000/todo';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<ToDoList[]> {
    return this.http.get<ToDoList[]>(`${this.todoApi}`);
  }

  getById(id: number): Observable<ToDoList> {
    return this.http.get<ToDoList>(`${this.todoApi}/${id}`);
  }

  save(todo: ToDoList): Observable<ToDoList> {
    return this.http.post<ToDoList>(`${this.todoApi}`, todo);
  }

  update(id: number, todo: ToDoList): Observable<ToDoList> {
    return this.http.put<ToDoList>(`${this.todoApi}/${id}`, todo);
  }
}
