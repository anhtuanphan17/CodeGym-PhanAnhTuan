import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  deletedProduct: Product;
  check: boolean = false;
  p = 1;
  name: string = '';
  price: any ='';


  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.findAllProduct(this.name,this.price).subscribe(data => {
      this.products = data;
      console.log(this.products);
    }, err => {
      console.log(err);
    });
  }


  onDeleteProduct(a: Product): void {
    console.log('haha');
    console.log(a);
    this.deletedProduct = a;
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
    this.productService.deleteProduct(this.deletedProduct).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, (error: HttpErrorResponse) => {
      alert('error');
    });
  }

}
