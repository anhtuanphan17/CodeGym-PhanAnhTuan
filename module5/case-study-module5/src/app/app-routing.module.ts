import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';


const routes: Routes = [
  {path: '', component: HomePageComponent}
  ,
  {
    path: 'customer',
    loadChildren: () => import('./customer-component/customer.module').then(module => module.CustomerModule)
  },
  {
    path: 'service',
    loadChildren: () => import('./service-component/service.module').then(module => module.ServiceModule)
  },
  {
    path: 'contract',
    loadChildren: () => import('./contract-component/contract.module').then(module => module.ContractModule)
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
