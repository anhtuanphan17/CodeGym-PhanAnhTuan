import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryService} from "../../serivce/category.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  createCategoryForm : FormGroup;
  constructor(private categoryService: CategoryService,private router: Router) {
    this.createCategoryForm = new FormGroup({
      id: new FormControl(''),
      categoryName: new FormControl(""),
    })
  }

  ngOnInit(): void {
  }

  submit() {
    const category = this.createCategoryForm.value;
    this.categoryService.saveCategory(category).subscribe(() =>{
      this.createCategoryForm.reset();
      // alert("created successfully");
      this.router.navigateByUrl('');
    }),e =>{
      console.log(e);
    }
  }
}
