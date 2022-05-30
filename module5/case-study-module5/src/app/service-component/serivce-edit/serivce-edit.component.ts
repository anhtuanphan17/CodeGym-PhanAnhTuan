import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {gte} from '../../model/gte';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {IFacility} from "../../model/IFacility";
import {FacilityService} from "../../service/facility.service";

@Component({
  selector: 'app-serivce-edit',
  templateUrl: './serivce-edit.component.html',
  styleUrls: ['./serivce-edit.component.css']
})
export class SerivceEditComponent implements OnInit {

  id: Number;
  editServiceForm: FormGroup;
  facility: IFacility;
  check = 0;

  constructor(private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      // @ts-ignore
      this.facility = this.facilityService.findById(this.id).subscribe(data => {
        console.log(this.facility);
        this.facility = data;
        this.check = this.facility.serviceType;
        console.log('haha');
        this.editServiceForm = new FormGroup({
          id: new FormControl(''),
          serviceCode: new FormControl(this.facility.serviceCode, [Validators.required, Validators.pattern('^$|^DV-[\\d]{4}$')]),
          serviceName: new FormControl(this.facility.serviceName, [Validators.required]),
          serviceImage: new FormControl(this.facility.serviceImage, [Validators.required]),
          serviceArea: new FormControl(this.facility.serviceArea, [Validators.required, gte]),
          serviceCost: new FormControl(this.facility.serviceCost, [Validators.required, gte]),
          serviceMaxPeople: new FormControl(this.facility.serviceMaxPeople, [Validators.required, gte]),
          standardRoom: new FormControl(this.facility.standardRoom),
          descriptionOtherConvenience: new FormControl(this.facility.descriptionOtherConvenience, [Validators.required]),
          poolArea: new FormControl(this.facility.poolArea, [gte]),
          numberOfFloors: new FormControl(this.facility.numberOfFloors, [gte]),
          rentType: new FormControl(this.facility.rentType, [Validators.required]),
          serviceType: new FormControl(this.facility.serviceType, [Validators.required]),
        });
      });
    })
  }


  ngOnInit(): void {
  }



  onSubmit() {
    console.log(this.editServiceForm);
    if (this.editServiceForm.invalid) {
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
    }else {
      const facility = this.editServiceForm.value;
      console.log(facility);
      this.facilityService.updateFacility(this.id, facility).subscribe(() => {
        alert('update successfully');
        this.router.navigateByUrl('/service/list');
      }, e => {
        console.log(e);
      });
    }
  }

  get serviceCode() {
    return this.editServiceForm.get('serviceCode');
  }

  get serviceName() {
    return this.editServiceForm.get('serviceName');
  }

  get serviceImage() {
    return this.editServiceForm.get('serviceImage');
  }

  get serviceArea() {
    return this.editServiceForm.get('serviceArea');
  }

  get serviceCost() {
    return this.editServiceForm.get('serviceCost');
  }

  get serviceMaxPeople() {
    return this.editServiceForm.get('serviceMaxPeople');
  }

  get standardRoom() {
    return this.editServiceForm.get('standardRoom');
  }

  get descriptionOtherConvenience() {
    return this.editServiceForm.get('descriptionOtherConvenience');
  }

  get poolArea() {
    return this.editServiceForm.get('poolArea');
  }

  get numberOfFloors() {
    return this.editServiceForm.get('numberOfFloors');
  }

  get freeAttachedService() {
    return this.editServiceForm.get('freeAttachedService');
  }

  get rentType() {
    return this.editServiceForm.get('rentType');
  }

  get serviceType() {
    return this.editServiceForm.get('serviceType');
  }

}
