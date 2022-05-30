import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  productApi = "http://localhost:8080/api/product";

  createProduct(value: any): Observable<any> {
    return this.http.post<any>(this.productApi + '/create', value);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.productApi + '/' + id);
  }

  updateProduct(id: number, value: any): Observable<any> {
    return this.http.patch<any>(this.productApi + '/' + id, value);
  }

  getAllProduct(): Observable<any> {
    return this.http.get<any>(this.productApi + '/list');
  }
}
