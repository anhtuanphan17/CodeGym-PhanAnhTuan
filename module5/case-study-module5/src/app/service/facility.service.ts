import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IFacility} from '../model/IFacility';
import {ICustomer} from "../model/ICustomer";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  facilityApi = 'http://localhost:3000/service';

  constructor(private http: HttpClient) {
  }

  getAllService(): Observable<IFacility[]> {
    return this.http.get<IFacility[]>(this.facilityApi);
  }

  addNewService(facility: IFacility): Observable<IFacility> {
    return this.http.post<IFacility>(this.facilityApi,facility);
  }

  findById(id: Number): Observable<IFacility> {
    return this.http.get<IFacility>(this.facilityApi + '/' + id);
  }

  updateFacility(id: Number, facility: any): Observable<IFacility> {
    return this.http.put<IFacility>(this.facilityApi + '/' + id, facility);
  }

  deleteFacility(deletedFacility: IFacility): Observable<any> {
    return this.http.delete<any>(this.facilityApi + '/' + deletedFacility.id);
  }


}
