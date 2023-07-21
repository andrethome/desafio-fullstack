import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-fornecedor',
  templateUrl: './lista-fornecedor.component.html',
  styleUrls: ['./lista-fornecedor.component.css']
})
export class ListaFornecedorComponent implements OnInit{
  constructor(
    private http: HttpClient
  ){
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json')
      .append('Access-Control-Allow-Headers', 'Content-Type')
      .append('Access-Control-Allow-Methods', 'GET')
      .append('Access-Control-Allow-Origin', '*');

    this.http.get('http://localhost:8081/api/v1/fornecedor', {headers}).subscribe(listaf =>{
      console.log(listaf);
    })
  }
  ngOnInit(): void {
 
  }

}
