import { Component, OnInit } from '@angular/core';
import { ApiServicsService } from '../Servics/api-servics.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  orderDetailList:any=[];
  constructor( private apiService:ApiServicsService, private router: Router, private activatedRoute :ActivatedRoute ) { }

  ngOnInit() {
    this.apiService.getOrderDetails(this.activatedRoute.snapshot.paramMap.get("orderId")).subscribe(data => {
      this.orderDetailList = data;
    });
  }

}
