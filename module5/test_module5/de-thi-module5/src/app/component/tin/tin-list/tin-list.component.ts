import {Component, OnInit} from '@angular/core';
import {Tin} from '../../../model/tin';
import {TinService} from '../../../service/tin.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-tin-list',
  templateUrl: './tin-list.component.html',
  styleUrls: ['./tin-list.component.css']
})
export class TinListComponent implements OnInit {
  tins: Tin[] = [];
  dienTich: any = '';
  gia: any = '';
  huong = '';
  deletedTin: Tin;
  check = false;
  page = 0;
  totalPages = 0;
  message = '';
  sortSelect = '';

  constructor(private tinService: TinService) {
  }

  ngOnInit(): void {
    this.loadAll();
  }

  loadAll() {
    this.tinService.getAllTins('', '', '', this.page, this.sortSelect).subscribe(data => {
      this.tins = data.content;
      this.page = data.number;
      this.totalPages = data.totalPages;
    }, err => {
      console.log(err);
    });
  }

  onDeleteTin(tin: Tin) {
    console.log(tin);
    this.deletedTin = tin;
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

  delete(event) {
    this.tinService.deleteTin(this.deletedTin).subscribe(() => {
      event.click();
      this.ngOnInit();
    }, (error: HttpErrorResponse) => {
      alert('error');
    });
  }

  search(dienTich: string, gia: string, huong: string) {
    this.tinService.getAllTins(dienTich, gia, huong, this.page, this.sortSelect).subscribe(data => {
      this.tins = data.content;
      this.totalPages = data.totalPages;
      this.page = data.number;
      if (this.tins.length < 1) {
        this.message = 'KHÔNG TÌM THẤY !';
      }
    }, err => {
      console.log(err);
    });
  }

  next() {
    if (this.page < this.totalPages - 1) {
      this.tinService.getAllTins(this.dienTich, this.gia, this.huong, this.page + 1, this.sortSelect).subscribe(
        data => {
          this.tins = data.content;
          this.page = data.number;
        }, err => {
          console.log(err);
        }
      );
    }
  }

  previous() {
    if (this.page > 0) {
      this.tinService.getAllTins(this.dienTich, this.gia, this.huong, this.page - 1, this.sortSelect).subscribe(
        data => {
          this.tins = data.content;
          this.page = data.number;
        }, err => {
          console.log(err);
        }
      );
    }
  }
}
