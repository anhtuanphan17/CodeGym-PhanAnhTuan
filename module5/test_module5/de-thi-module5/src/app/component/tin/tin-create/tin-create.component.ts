import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TinService} from '../../../service/tin.service';
import {HttpErrorResponse} from '@angular/common/http';
import {DanhMuc} from '../../../model/danh-muc';
import {DanhMucService} from '../../../service/danh-muc.service';

@Component({
  selector: 'app-tin-create',
  templateUrl: './tin-create.component.html',
  styleUrls: ['./tin-create.component.css']
})
export class TinCreateComponent implements OnInit {
  tinForm: FormGroup;
  danhMucList: DanhMuc[] = [];
  check = false;

  constructor(private tinService: TinService, private danhMucService: DanhMucService) {
    // const now = new Date();

    console.log(this.danhMucList);
    this.tinForm = new FormGroup({
      id: new FormControl(),
      vungMien: new FormControl(),
      daiDien: new FormControl('', [Validators.required]),
      loaiBaiViet: new FormControl('', [Validators.required]),
      tinhTrang: new FormControl(''),
      diaChi: new FormControl('', [Validators.required]),
      dienTich: new FormControl('', [Validators.required]),
      huong: new FormControl('', [Validators.required]),
      tuaDe: new FormControl('', [Validators.required]),
      noiDung: new FormControl('', [Validators.required]),
      gia: new FormControl('', [Validators.required]),
      ngayDang: new FormControl(),
      trangThai: new FormControl(''),
      danhMuc: new FormControl(this.danhMucList[0]),

    });

  }


  getAllDanhMuc() {
    this.danhMucService.getAllDanhMuc().subscribe(data => {
      this.danhMucList = data;
    });
  }

  ngOnInit(): void {
    this.getAllDanhMuc();
    console.log(this.danhMucList);
  }

  submit() {
    console.log(this.tinForm);
    if (this.tinForm.invalid) {
      if (this.tinForm.controls.danhMuc.value == '') {
        this.tinForm.controls.danhMuc.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.daiDien.value == '') {
        this.tinForm.controls.daiDien.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.loaiBaiViet.value == '') {
        this.tinForm.controls.loaiBaiViet.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.tinhTrang.value == '') {
        this.tinForm.controls.tinhTrang.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.diaChi.value == '') {
        this.tinForm.controls.diaChi.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.dienTich.value == '') {
        this.tinForm.controls.dienTich.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.huong.value == '') {
        this.tinForm.controls.huong.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.tuaDe.value == '') {
        this.tinForm.controls.tuaDe.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.noiDung.value == '') {
        this.tinForm.controls.noiDung.setErrors({empty: 'Empty! Please input!'});
      }
      if (this.tinForm.controls.gia.value == '') {
        this.tinForm.controls.gia.setErrors({empty: 'Empty! Please input!'});
      }
    } else {
      const tin = this.tinForm.value;
      this.tinService.createTin(tin).subscribe(next => {
        this.tinForm.reset();
        // alert('added successfully');
      }, e => {
        console.log(e);
      });
    }
  }

  onCreateTin(): void {
    if (this.tinForm.valid) {
      console.log('haha');
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
  }

  create(event: HTMLButtonElement) {
    this.tinService.createTin(this.tinForm.value).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, (error: HttpErrorResponse) => {
      alert('error');
    });
  }


}
