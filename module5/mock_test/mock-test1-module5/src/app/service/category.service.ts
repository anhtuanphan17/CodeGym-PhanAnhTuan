import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categoryApi = 'http://localhost:3000/category';

  constructor(private http: HttpClient) {
  }

  getAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.categoryApi);
  }
}
