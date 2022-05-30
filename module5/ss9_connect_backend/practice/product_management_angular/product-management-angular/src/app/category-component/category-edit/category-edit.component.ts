import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CategoryService} from '../../serivce/category.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  editCategoryForm: FormGroup;
  id: number;

  constructor(private categoryService: CategoryService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      this.getCategory(this.id);
    });
  }

  ngOnInit(): void {
  }

  private getCategory(id: number) {
    return this.categoryService.findById(id).subscribe(category => {
      this.editCategoryForm = new FormGroup({
        categoryName: new FormControl(category.categoryName, [Validators.required]),
      });
    });
  }

  updateCategory(id: number) {
    const category = this.editCategoryForm.value;
    this.categoryService.updateCategory(id, category).subscribe(() => {
      alert('Cập nhật thành công');
      this.router.navigateByUrl('');
    }, e => {
      console.log(e);
    });
  }
}
