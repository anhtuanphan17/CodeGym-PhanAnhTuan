import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerEditForm: FormGroup;
  id: number;

  constructor(private customerService: CustomerService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      this.getCustomer(this.id);
    });
  }

  ngOnInit(): void {
  }

  getCustomer(id: number) {
    return this.customerService.findCustomerById(id).subscribe(customer => {
      this.customerEditForm = new FormGroup({
        id : new FormControl(customer.id),
        customerCode: new FormControl(customer.customerCode, [Validators.required, Validators.pattern('^(KH-){1}\\d{4}$')]),
        customerName: new FormControl(customer.customerName, [Validators.required]),
        customerBirthday: new FormControl(customer.customerBirthday, [Validators.required]),
        customerGender: new FormControl(customer.customerGender, [Validators.required]),
        customerIdCard: new FormControl(customer.customerIdCard, [Validators.required, Validators.pattern('^\\d{9}$')]),
        // tslint:disable-next-line:max-line-length
        customerPhone: new FormControl(customer.customerPhone, [Validators.required, Validators.pattern('^$|^(0|\\(84\\)\\+)9[0|1]\\d{7}$')]),
        customerEmail: new FormControl(customer.customerEmail, [Validators.required, Validators.email]),
        customerAddress: new FormControl(customer.customerAddress, [Validators.required]),
        customerTypeId: new FormControl(customer.customerTypeId, [Validators.required]),
      });
    });
  }


  submitCustomerEditForm() {
    if (this.customerEditForm.invalid) {
      if (this.customerEditForm.controls.customerCode.value == '') {
        this.customerEditForm.controls.customerCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerName.value == '') {
        this.customerEditForm.controls.customerName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerBirthday.value == '') {
        this.customerEditForm.controls.customerBirthday.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerGender.value == null) {
        this.customerEditForm.controls.customerGender.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerIdCard.value == '') {
        this.customerEditForm.controls.customerIdCard.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerPhone.value == '') {
        this.customerEditForm.controls.customerPhone.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerEmail.value == '') {
        this.customerEditForm.controls.customerEmail.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerAddress.value == '') {
        this.customerEditForm.controls.customerAddress.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerEditForm.controls.customerTypeId.value == '') {
        this.customerEditForm.controls.customerTypeId.setErrors({empty: 'Empty! Please input!'});
      }
    } else {
      const customer = this.customerEditForm.value;
      console.log(customer);
      this.customerService.updateCustomer(this.id, customer).subscribe(() => {
        alert('update successfully');
        this.router.navigateByUrl('/customer/list');
      }, e => {
        console.log(e);
      });
    }

  }
}

