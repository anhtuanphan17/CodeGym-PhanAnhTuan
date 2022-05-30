import {Component, OnInit} from '@angular/core';
import {IContract} from '../../model/IContract';
import {ContractService} from '../../service/contract.service';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: IContract[] = [];
  p: number = 1;

  constructor(private contractService: ContractService) {
    this.contractService.getAllContract().subscribe(data => {
      this.contracts = data;
      console.log(data);
    }, err => {
      console.log(err);
    });
  }

  ngOnInit(): void {
  }


}
