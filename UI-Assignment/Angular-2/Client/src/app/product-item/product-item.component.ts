import { Component, OnInit, Input } from '@angular/core';
import {ApiServicsService} from '../Servics/api-servics.service';
import {CategoryListComponent} from '../category-list/category-list.component';
import { product } from '../models/product-model';
@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  productList :product[];
  itemList: any = [];
  ispaused = true;
  cat : CategoryListComponent;
  @Input() Category : string;
  
  constructor(private apiService: ApiServicsService ) {}

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.apiService.getAllProduct().subscribe(data =>{
      this.productList = data;
     });
     this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });
  }

  /**
   * Method to add item on cart.
   * @param productId 
   */
  addToCart(productId) {
    let result = this.getItemList(productId);

    alert(result)
    if (result == 0) {
      if (this.iterateList(productId) == 1) {
        this.insertInCart(productId);
      }
    }
    window.location.reload();
  }

  /**
   * Method to check item on cart that is exist or not.
   * @param productId 
   */
  iterateList(productId) {
    for (var i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i].id == productId) {
        alert("item already added.");
        return 0;
      }
    }
    return 1;
  }

  /**
   * Method to add item on data base. 
   * @param productId 
   */
  insertInCart(productId) {
  
    let cart = '{"userId":1, "productId":' + productId + ', "quantity":1}';
    let c = JSON.parse(cart);
    var msg: any;
    this.apiService.insertCart(c).subscribe(data => {
      msg = data;
    })
    this.apiService.getCartDetails().subscribe(data => {
      this.itemList = data
    });
  }

  /**
   * Method to get item list of cart. 
   * @param productId 
   */
  getItemList(productId) {
    if (this.itemList.length == 0) {
      console.log('itemList empty');
      this.insertInCart(productId);
      this.apiService.getCartDetails().subscribe(data => {
        this.itemList = data
      });
      return 1;
    }
    return 0;
  
  }
}
