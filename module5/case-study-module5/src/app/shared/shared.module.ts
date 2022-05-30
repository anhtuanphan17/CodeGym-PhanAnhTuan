import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SharedRoutingModule} from './shared-routing.module';
import {NavigataionComponent} from '../navigataion/navigataion.component';
import {HeaderComponent} from '../header/header.component';
import {FooterComponent} from '../footer/footer.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    HeaderComponent,
    NavigataionComponent,
    FooterComponent,
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    NavigataionComponent
  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class SharedModule {
}
