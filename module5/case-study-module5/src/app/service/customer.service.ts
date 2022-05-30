import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICustomer} from '../model/ICustomer';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {

  customerApi = 'http://localhost:8080/customer';

  constructor(private http: HttpClient) {
  }

  getAllCustomer(): Observable<any> {
    return this.http.get<any>(this.customerApi);
  }

  saveCustomer(customer: ICustomer): Observable<ICustomer> {
    return this.http.post<ICustomer>(`${this.customerApi}/create`, customer);
  }

  findCustomerById(id: number): Observable<ICustomer> {
    return this.http.get<ICustomer>(this.customerApi + '/' + id);
  }

  updateCustomer(id: number, customer: ICustomer): Observable<ICustomer> {
    return this.http.put<ICustomer>(this.customerApi + '/edit/' + id, customer);
  }

  deleteCustomer(deleteCustomer: ICustomer): Observable<ICustomer> {
    return this.http.delete<ICustomer>(this.customerApi + '/delete/' + deleteCustomer.id);
  }
}
