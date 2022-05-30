import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';
import {ProductService} from '../../serivce/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';
import {CategoryService} from '../../serivce/category.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  id: number;
  product: Product;
  categories: Category[] = [];
  productForm: FormGroup;

  constructor(private categoryService: CategoryService, private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      // @ts-ignore
      this.product = this.getProduct(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  private getProduct(id: number) {
    this.productService.findById(id).subscribe(product => {
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        date: new FormControl(product.date),
        category: new FormControl(product.category)
      });
    });
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }

  compare(a: Category, b: Category): boolean {
    return a && b ? a.id === b.id : a === b;
  }

  submit() {
    const product = this.productForm.value;
    this.productService.updateProduct(this.id, product).subscribe(() => {
      alert('updated successfully');
      this.router.navigateByUrl('/product-component/list');
    }, e => {
      console.log(e);
    });
  }
}
