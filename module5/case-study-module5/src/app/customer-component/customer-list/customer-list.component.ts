import {Component, OnInit} from '@angular/core';
import {ICustomer} from '../../model/ICustomer';
import {CustomerService} from '../../service/customer.service';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from "rxjs";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  check = false;
  deleteCustomer: ICustomer;
  customers: ICustomer[] = [];
  p = 1;
  name: string;

  constructor(private customerService: CustomerService, private http: HttpClient) {
  }

  ngOnInit(): void {
    this.findAllCustomer();

    // @ts-ignore
    // this.response = this.http.get('http://localhost:8080/customer');
    // this.response.subscribe((data) => {
    //   this.customers = data;
    // })

  }

  findAllCustomer() {
    this.customerService.getAllCustomer().subscribe((customers) => {
      this.customers = customers.content;
      console.log(this.customers);
    });
  }

  onOpenEditModal(a: ICustomer): void {
    console.log('haha');
    console.log(a);
    this.deleteCustomer = a;
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
    this.customerService.deleteCustomer(this.deleteCustomer).subscribe(() => {
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
      this.customers = this.customers.filter(res => {
        return res.customerName.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    }
  }
}
