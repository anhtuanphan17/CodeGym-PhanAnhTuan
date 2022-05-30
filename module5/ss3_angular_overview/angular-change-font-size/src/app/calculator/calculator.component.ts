import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: string;

  plus(firstNum: string, secondNum: string) {
    // tslint:disable-next-line:radix
    this.result = String(parseInt(firstNum) + parseInt(secondNum));
  }

  subject(firstNum: string, secondNum: string) {
    // tslint:disable-next-line:radix
    // @ts-ignore
    this.result = String(firstNum - secondNum);
  }

  multiple(firstNum: string, secondNum: string) {
    // @ts-ignore
    this.result = firstNum * secondNum;
  }

  divide(firstNum: string, secondNum: string) {
    // tslint:disable-next-line:radix
    if (parseInt(secondNum) === 0) {
      this.result = 'Can not divide for 0';
    } else {
      // @ts-ignore
      this.result = firstNum / secondNum;
    }
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
