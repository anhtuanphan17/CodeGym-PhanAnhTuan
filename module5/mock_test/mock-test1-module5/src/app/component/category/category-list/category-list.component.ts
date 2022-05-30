import {Component, OnInit} from '@angular/core';
import {Category} from "../../../model/category";
import {CategoryService} from "../../../service/category.service";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {
    this.categoryService.getAllCategory();
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



}
