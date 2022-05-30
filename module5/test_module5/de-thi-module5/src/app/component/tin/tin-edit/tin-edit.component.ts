import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DanhMuc} from '../../../model/danh-muc';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {TinService} from '../../../service/tin.service';
import {DanhMucService} from '../../../service/danh-muc.service';

@Component({
  selector: 'app-tin-edit',
  templateUrl: './tin-edit.component.html',
  styleUrls: ['./tin-edit.component.css']
})
export class TinEditComponent implements OnInit {
  tinForm: FormGroup;
  danhMucList: DanhMuc[] = [];
  id: number;

  constructor(private tinService: TinService,
              private danhMucService: DanhMucService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.getAllDanhMuc();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = Number(paramMap.get('id'));
      this.getTinById();
    });
  }

  getTinById() {
    this.tinService.findTinById(this.id).subscribe(tin => {
      this.tinForm = new FormGroup({
        id: new FormControl(tin.id),
        vungMien: new FormControl(tin.vungMien),
        daiDien: new FormControl(tin.daiDien, [Validators.required]),
        loaiBaiViet: new FormControl(tin.loaiBaiViet, [Validators.required]),
        tinhTrang: new FormControl(tin.tinhTrang),
        diaChi: new FormControl(tin.diaChi, [Validators.required]),
        dienTich: new FormControl(tin.dienTich, [Validators.required]),
        huong: new FormControl(tin.huong, [Validators.required]),
        tuaDe: new FormControl(tin.tuaDe, [Validators.required]),
        noiDung: new FormControl(tin.noiDung, [Validators.required]),
        gia: new FormControl(tin.gia, [Validators.required]),
        ngayDang: new FormControl(tin.ngayDang),
        trangThai: new FormControl(tin.trangThai),
        danhMuc: new FormControl(tin.danhMuc),

      });
    });
  }

  ngOnInit(): void {
  }

  getAllDanhMuc() {
    this.danhMucService.getAllDanhMuc().subscribe(data => {
      this.danhMucList = data;
    });
  }

  compare(a: DanhMuc, b: DanhMuc): boolean {
    return a && b ? a.id === b.id : a === b;
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
      this.tinService.UpdateTin(tin).subscribe(next => {
        alert('updated successfully');
        this.router.navigateByUrl('/tin/list');
      }, e => {
        console.log(e);
      });
    }
  }
}
