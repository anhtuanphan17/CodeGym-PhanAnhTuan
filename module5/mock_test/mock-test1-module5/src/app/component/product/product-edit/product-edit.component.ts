import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../../service/product.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";
import {Product} from "../../../model/product";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  categories: Category[] = [];
  product: Product;

  constructor(private categoryService: CategoryService, private productService: ProductService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      console.log(this.id);
      // @ts-ignore
      this.product = this.getProduct();
    });
  }

  ngOnInit(): void {
    this.getAllCategory();
  }


  private getProduct() {
    this.productService.findById(this.id).subscribe(product => {
      console.log(product);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        productName: new FormControl(product.productName),
        price: new FormControl(product.price),
        quantity: new FormControl(product.quantity),
        color: new FormControl(product.color),
        category: new FormControl(product.category)
      });
    });
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(data => {
      this.categories = data;
    }, err => {
      console.log(err);
    });
  };

  compare(a: Category, b: Category): boolean {
    return a && b ? a.id === b.id : a === b;
  }

  submit() {
    if (this.productForm.invalid) {
      if (this.productForm.controls.productName.value == '') {
        this.productForm.controls.productName.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.productForm.controls.price.value == '') {
        this.productForm.controls.price.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.productForm.controls.quantity.value == '') {
        this.productForm.controls.quantity.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.productForm.controls.color.value == '') {
        this.productForm.controls.color.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.productForm.controls.category.value == '') {
        this.productForm.controls.category.setErrors({empty: 'Empty! Please input!'});
      }
    } else {
      const product = this.productForm.value;
      this.productService.updateProduct(product).subscribe(next => {
        this.productForm.reset();
        alert('updated successfully');
      }, e => {
        console.log(e);
      });
    }
  }


}
