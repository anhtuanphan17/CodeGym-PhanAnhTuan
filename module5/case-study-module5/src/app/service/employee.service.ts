import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {IEmployee} from '../model/IEmployee';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  employeeApi = 'http://localhost:3000/employee';

  constructor(private http: HttpClient) {
  }

  getAllEmployee():Observable<any> {
    return this.http.get<any>(this.employeeApi);
  }
}
