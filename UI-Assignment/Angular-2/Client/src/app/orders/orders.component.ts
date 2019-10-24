import { Component, OnInit } from '@angular/core';
import { ApiServicsService } from '../Servics/api-servics.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orderList:any=[];

  constructor(private apiService: ApiServicsService, private router: Router) { }

  ngOnInit() {
    this.apiService.shopperOrder().subscribe(data => {
      this.orderList = data;
    });
  }
}
