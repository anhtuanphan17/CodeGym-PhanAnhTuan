import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Router} from "@angular/router";
import {finalize} from "rxjs/operators";
import {formatDate} from "@angular/common";
import {AngularFireStorage} from "@angular/fire/storage";


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  selectedImage: any = null;
  flag: boolean = false;
  img2 = "";

  constructor(private productService: ProductService,
              private router: Router,
              // private alertService: AlertService,
              @Inject(AngularFireStorage) private storage: AngularFireStorage) {
    this.productForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      image: new FormControl(),
      screenSize: new FormControl(),
      camera: new FormControl(),
      selfie: new FormControl(),
      cpu: new FormControl(),
      memory: new FormControl(),
      otherDescription: new FormControl(),
    });

  }


  ngOnInit(): void {
  }

  submit() {
  }

  showPreview(event: any) {
    this.selectedImage = event.target.files[0];
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {

        fileRef.getDownloadURL().subscribe((url) => {
          this.img2=url;
          console.log(this.img2);
          // this.productForm.patchValue({image: url});
          // console.log(this.productForm.controls.image);
          // Call API to create vaccine

        });
      })
    ).subscribe();
  }

  save() {
    // upload image to firebase
    // const nameImg = this.getCurrentDateTime();
    const nameImg = this.getCurrentDateTime() + this.selectedImage.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {

        fileRef.getDownloadURL().subscribe((url) => {
          this.img2=url;
          this.productForm.patchValue({image: url});
          console.log(this.productForm.controls.image);
          // Call API to create vaccine
          this.productService.createProduct(this.productForm.value).subscribe(() => {
            this.productForm.reset();

            // this.router.navigateByUrl('vaccine-list').then(r => this.alertService.showMessage("Thêm mới thành công!"));
            console.log("success");
          })
        });
      })
    ).subscribe();
  }

  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }

}
