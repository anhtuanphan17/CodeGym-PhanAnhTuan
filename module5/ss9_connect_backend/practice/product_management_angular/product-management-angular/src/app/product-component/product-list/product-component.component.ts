import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../serivce/product.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-product-component',
  templateUrl: './product-component.component.html',
  styleUrls: ['./product-component.component.css']
})
export class ProductComponentComponent implements OnInit {
  products: Product[] = [];
  deletedProduct: Product;
  check = false;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAllProduct().subscribe(products => {
      this.products = products;
      console.log(this.products);
    });
  }

  onOpenDeleteModal(a: Product): void {
    console.log('haha');
    this.deletedProduct = a;
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#deleteModal');
    container.appendChild(button);
    button.click();
    this.check = true;
  }

  delete(event) {
    console.log(this.deletedProduct.id);
    this.productService.deleteProduct(this.deletedProduct).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, (error: HttpErrorResponse) => {
      alert('error');
    });
  }

}
