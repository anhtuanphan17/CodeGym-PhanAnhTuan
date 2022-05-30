import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerCreateForm: FormGroup;

  constructor(private customerService: CustomerService, private router: Router) {
    this.customerCreateForm = new FormGroup({
      id: new FormControl(),
      customerCode: new FormControl('', [Validators.required, Validators.pattern('^(KH-){1}\\d{4}$')]),
      customerName: new FormControl('', [Validators.required]),
      customerBirthday: new FormControl('', [Validators.required]),
      customerGender: new FormControl('', [Validators.required]),
      customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$')]),
      customerPhone: new FormControl('', [Validators.required, Validators.pattern('^$|^(0|\\(84\\)\\+)9[0|1]\\d{7}$')]),
      customerEmail: new FormControl('', [Validators.required, Validators.email]),
      customerAddress: new FormControl('', [Validators.required]),
      customerTypeId: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
  }

  submitCustomerCreateForm() {
    if (this.customerCreateForm.invalid) {
      if (this.customerCreateForm.controls.customerCode.value == '') {
        this.customerCreateForm.controls.customerCode.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerName.value == '') {
        this.customerCreateForm.controls.customerName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerBirthday.value == '') {
        this.customerCreateForm.controls.customerBirthday.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerGender.value == null) {
        this.customerCreateForm.controls.customerGender.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerIdCard.value == '') {
        this.customerCreateForm.controls.customerIdCard.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerPhone.value == '') {
        this.customerCreateForm.controls.customerPhone.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerEmail.value == '') {
        this.customerCreateForm.controls.customerEmail.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerAddress.value == '') {
        this.customerCreateForm.controls.customerAddress.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.customerCreateForm.controls.customerTypeId.value == '') {
        this.customerCreateForm.controls.customerTypeId.setErrors({empty: 'Empty! Please input!'});
      }
    } else {
      const customer = this.customerCreateForm.value;
      this.customerService.saveCustomer(customer).subscribe(next => {
        this.customerCreateForm.reset();
        alert('added successfully');

      }, e => {
        console.log(e);
      });
    }
  }
}
