import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color: string;
  colorRange: number;

  colorEditor() {
    switch (this.colorRange) {
      case 1:
        this.color = 'red';
        break;
      case 2:
        this.color = 'blue';
        break;
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
