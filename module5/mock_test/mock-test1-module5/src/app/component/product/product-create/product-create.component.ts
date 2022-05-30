import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../../service/product.service";
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  categories: Category[] = [];

  constructor(private categoryService: CategoryService, private productService: ProductService) {
    this.productForm = new FormGroup({
      id: new FormControl(),
      productName: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      color: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(data => {
      this.categories = data;
    }, err => {
      console.log(err);
    });
  };

  submit() {
    console.log(this.productForm)
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
      this.productService.createProduct(product).subscribe(next => {
        this.productForm.reset();
        alert('added successfully');
      }, e => {
        console.log(e);
      });
    }
  }


}
