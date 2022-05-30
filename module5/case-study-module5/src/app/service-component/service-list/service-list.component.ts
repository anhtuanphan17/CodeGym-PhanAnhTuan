import {Component, OnInit} from '@angular/core';
import {IFacility} from '../../model/IFacility';
import {FacilityService} from "../../service/facility.service";
import {ICustomer} from "../../model/ICustomer";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  facilities: IFacility[] = [];
  deletedFacility: IFacility;
  check: boolean = false;
  name: any;

  constructor(private facilityService: FacilityService) {

  }

  ngOnInit(): void {
    this.getAllFacility();
  }

  getAllFacility() {
    this.facilityService.getAllService().subscribe(data => {
      this.facilities = data;
    }, error => {
      console.log(error);
    });
  }

  onOpenDeleteModal(facility: IFacility) {
    console.log('haha');
    console.log(facility);
    this.deletedFacility = facility;
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#deleteModal');
    container.appendChild(button);
    this.check = true;
    button.click();
  }

  delete(event) {
    this.facilityService.deleteFacility(this.deletedFacility).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, (error: HttpErrorResponse) => {
      alert('error');
    });
  }

  search() {
    if (this.name === '') {
      this.ngOnInit();
    } else {
      this.facilities = this.facilities.filter(res => {
        return res.serviceName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
  }


}
