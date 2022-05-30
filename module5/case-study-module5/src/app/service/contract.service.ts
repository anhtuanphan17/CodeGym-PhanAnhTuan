import {Injectable} from '@angular/core';
import {Observable} from 'rxjs' ;
import {IContract} from '../model/IContract';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ContractService {
  contractApi = 'http://localhost:3000/contract';

  constructor(private http: HttpClient) {
  }

  getAllContract(): Observable<any> {
    return this.http.get<any>(`${this.contractApi}`);
  }

  createContract(contract: any): Observable<any> {
    return this.http.post<any>(this.contractApi, contract);
  }
}
