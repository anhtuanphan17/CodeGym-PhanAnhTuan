import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productApi = 'http://localhost:3000/productList';

  constructor(private http: HttpClient) {
  }

  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(this.productApi);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.productApi, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.productApi + '/' + id);
  }

  updateProduct(id: number, product: any): Observable<Product> {
    return this.http.put<Product>(this.productApi + '/' + id, product);
  }

  deleteProduct(a: Product): Observable<Product> {
    return this.http.delete<Product>(this.productApi + '/' + a.id);
  }
}
