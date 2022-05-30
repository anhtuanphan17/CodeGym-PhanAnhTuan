import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Category} from "../../model/category";
import {CategoryService} from "../../serivce/category.service";
import {ProductService} from "../../serivce/product.service";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    date: new FormControl(),
    category: new FormControl()
  });
  categories: Category[] = [];

  constructor(private categoryService: CategoryService, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }

  submit() {
    const product = this.productForm.value;
    product.category = {
      id: product.category.id,
      categoryName: product.category.categoryName
    };
    this.productService.saveProduct(product).subscribe(() => {
      alert('Tạo thành công');
      this.productForm.reset();
    }, e => console.log(e));
  }
}
