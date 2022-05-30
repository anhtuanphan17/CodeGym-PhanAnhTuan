import {ICustomer} from './ICustomer';
import {IFacility} from './IFacility';
import {IEmployee} from './IEmployee';


export interface IContract {
  id: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;
  employee: IEmployee;
  customer: ICustomer;
  services: IFacility;
}
