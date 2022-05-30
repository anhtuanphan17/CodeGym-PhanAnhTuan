import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IFacility} from '../../model/IFacility';
import {gte} from '../../model/gte';
import {FacilityService} from "../../service/facility.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-service-create',
  templateUrl: './service-create.component.html',
  styleUrls: ['./service-create.component.css']
})
export class ServiceCreateComponent implements OnInit {
  facility: IFacility;
  check = 0;
  createServiceForm: FormGroup;
  img: string = 'https://furamavietnam.com/wp-content/uploads/2020/04/04-Facilities-Maintenance.jpg';

  constructor(private facilityService: FacilityService, private router: Router) {
    this.createServiceForm = new FormGroup({
      serviceCode: new FormControl('', [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
      serviceName: new FormControl('', [Validators.required, Validators.pattern('^([a-zA-Z]+[ ]?){1,250}$')]),
      serviceImage: new FormControl(this.img, [Validators.required]),
      serviceArea: new FormControl('', [Validators.required, gte]),
      serviceCost: new FormControl('', [Validators.required, gte]),
      serviceMaxPeople: new FormControl('', [Validators.required, gte]),
      standardRoom: new FormControl(''),
      descriptionOtherConvenience: new FormControl('', [Validators.required]),
      poolArea: new FormControl(''),
      numberOfFloors: new FormControl(''),
      rentType: new FormControl('1', [Validators.required]),
      serviceType: new FormControl(this.check, [Validators.required]),
    });
  }

  ngOnInit(): void {
  }

  showFormCreate(event) {
    this.check = event.target.value;
  }


  onSubmit() {
    console.log(this.createServiceForm);

    if (this.createServiceForm.invalid) {
      if (this.serviceCode.value == '') {
        this.serviceCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceName.value == '') {
        this.serviceName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceArea.value == '') {
        this.serviceArea.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceCost.value == '') {
        this.serviceCost.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceMaxPeople.value == '') {
        this.serviceMaxPeople.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.standardRoom.value == '') {
        this.standardRoom.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.descriptionOtherConvenience.value == '') {
        this.descriptionOtherConvenience.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.poolArea.value == '') {
        this.poolArea.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.numberOfFloors.value == '') {
        this.numberOfFloors.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.rentType.value == '') {
        this.rentType.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.serviceType.value == '') {
        this.serviceType.setErrors({empty: 'Empty! Please input!'});
      }
    } else {
      const facility = this.createServiceForm.value;
      console.log(facility);
      this.facilityService.addNewService(facility).subscribe(() => {
        this.createServiceForm.reset();
        alert('added successfully');
        this.router.navigateByUrl('/service/list');
      }, error => {
        console.log(error);
      });
    }

  }

  get serviceCode() {
    return this.createServiceForm.get('serviceCode');
  }

  get serviceName() {
    return this.createServiceForm.get('serviceName');
  }

  get serviceImage() {
    return this.createServiceForm.get('serviceImage');
  }

  get serviceArea() {
    return this.createServiceForm.get('serviceArea');
  }

  get serviceCost() {
    return this.createServiceForm.get('serviceCost');
  }

  get serviceMaxPeople() {
    return this.createServiceForm.get('serviceMaxPeople');
  }

  get standardRoom() {
    return this.createServiceForm.get('standardRoom');
  }

  get descriptionOtherConvenience() {
    return this.createServiceForm.get('descriptionOtherConvenience');
  }

  get poolArea() {
    return this.createServiceForm.get('poolArea');
  }

  get numberOfFloors() {
    return this.createServiceForm.get('numberOfFloors');
  }

  get freeAttachedService() {
    return this.createServiceForm.get('freeAttachedService');
  }

  get rentType() {
    return this.createServiceForm.get('rentType');
  }

  get serviceType() {
    return this.createServiceForm.get('serviceType');
  }

}
