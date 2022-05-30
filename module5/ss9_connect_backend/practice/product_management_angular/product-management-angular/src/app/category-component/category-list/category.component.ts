import {Component, OnInit} from '@angular/core';
import {Category} from '../../model/category';
import {CategoryService} from '../../serivce/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Array<Category> = [];

  constructor(private categoryService: CategoryService ) {
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  getAllCategory(){
    this.categoryService.getAll().subscribe((categories) => {
      this.categories = categories;
      console.log(this.categories);
    });
  }

  onDelete(id: number) {
    console.log(id);
    if (confirm("Do you want to delete this record")){
      this.categoryService.deleteCategory(id);
      this.getAllCategory();
    }
  }
}
