import { Component, OnInit } from '@angular/core';
import {ApiServicsService} from '../Servics/api-servics.service'
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userId = 1;
  itemList: any = [];
  constructor(private apiService: ApiServicsService) { }

  ngOnInit() {
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });

  }
}
