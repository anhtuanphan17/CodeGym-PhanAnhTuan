import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TinListComponent} from './component/tin/tin-list/tin-list.component';
import {TinCreateComponent} from './component/tin/tin-create/tin-create.component';
import {TinEditComponent} from './component/tin/tin-edit/tin-edit.component';


const routes: Routes = [
  {path: 'tin/list', component: TinListComponent},
  {path: 'tin/create', component: TinCreateComponent},
  {path: 'tin/edit/:id', component: TinEditComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
