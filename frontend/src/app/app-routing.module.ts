import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaFornecedorComponent } from './lista-fornecedor/lista-fornecedor.component';

const routes: Routes = [
  {
    path: 'fornecedor',
    component: ListaFornecedorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
