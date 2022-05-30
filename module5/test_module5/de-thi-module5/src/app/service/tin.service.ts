import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Tin} from '../model/tin';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TinService {
  tinApi = 'http://localhost:8080/tin';

  constructor(private http: HttpClient) {
  }

  findAllTin(): Observable<any> {
    return this.http.get<any>(this.tinApi);
  }


  createTin(tin: Tin): Observable<Tin> {
    return this.http.post<Tin>(this.tinApi + '/create', tin);
  }

  UpdateTin(tin: Tin): Observable<Tin> {
    return this.http.put<Tin>(this.tinApi + '/edit/' + tin.id, tin);
  }

  findAllTinTatCa(tatCa: any): Observable<any> {
    return this.http.get<Tin>(this.tinApi + '?q=' + tatCa);
  }


  findAlltinDienTich(dienTich: any): Observable<Tin[]> {
    return this.http.get<Tin[]>(this.tinApi + '?dienTich_like=' + dienTich);
  }


  findAllTinGia(gia: any): Observable<Tin[]> {
    return this.http.get<Tin[]>(this.tinApi + '?gia_like=' + gia);
  }

  findAllTinHuong(huong: string): Observable<Tin[]> {
    return this.http.get<Tin[]>(this.tinApi + '?huong_like=' + huong);
  }

  findTinById(id: number): Observable<Tin> {
    return this.http.get<Tin>(this.tinApi + '/' + id);
  }

  deleteTin(deletedTin: Tin): Observable<Tin> {
    return this.http.delete<Tin>(this.tinApi + '/delete/' + deletedTin.id);
  }

  getAllTins(dienTich: string, gia: string, huong: string, page: number, sortSelect: string): Observable<any> {
    return this.http.get<any>(`${this.tinApi}?page=${page}&huong=${huong}`);
  }

}
