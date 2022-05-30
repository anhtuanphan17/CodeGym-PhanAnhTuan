import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {DictionaryDetailsPageComponent} from './dictionary-details-page/dictionary-details-page.component';
import {DictionaryPageComponent} from './dictionary-page/dictionary-page.component';


const routes: Routes = [
  {path: 'home', component: DictionaryPageComponent},
  {path: 'dictionary-details/:id', component: DictionaryDetailsPageComponent }
  ];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
