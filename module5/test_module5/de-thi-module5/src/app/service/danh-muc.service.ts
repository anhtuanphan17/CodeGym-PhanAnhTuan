import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DanhMucService {
  danhMucApi = 'http://localhost:8080/tin/danhMuc';

  constructor(private http: HttpClient) {
  }

  getAllDanhMuc(): Observable<any> {
    return this.http.get<any>(this.danhMucApi);
  }
}
