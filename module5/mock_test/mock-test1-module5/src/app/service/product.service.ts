import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productApi = 'http://localhost:3000/product';

  constructor(private http: HttpClient) {
  }

  findAllProduct(name: string, price: any): Observable<Product[]> {
    return this.http.get<Product[]>(this.productApi + '?productName_like=' + name + '&price_like=' + price);
  }

  // findAllProduct(name:string): Observable<Product[]> {
  //   return this.http.get<Product[]>(this.productApi +'?q='+ name);
  // }
  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.productApi, product);
  }

  updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>(this.productApi + '/' + product.id, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.productApi + '/' + id);
  }

  deleteProduct(deletedProduct: Product) {
    return this.http.delete<Product>(this.productApi + '/' + deletedProduct.id);
  }


}
