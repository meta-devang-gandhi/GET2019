import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

import {product} from '../models/product-model';
import { CartDetails } from '../models/cart-detail-model';
import { shopperOrderId } from '../models/shopper-order-id';
import { ShopperOrder } from '../models/shopper-order';
import { OrderDetails } from '../models/order-detail';

@Injectable({
  providedIn: 'root'
})
export class ApiServicsService {
  constructor(private http: HttpClient) { }
  userId=1;

  public getAllProduct() : Observable<product[]>{
    return this.http.get<product[]>('http://localhost:3000/api/products');
  }

  public getCartDetails() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<CartDetails>('http://localhost:3000/api/showCart', {params});
  }


  public getOrderDetails(orderId) {
    const params = new HttpParams().set('params', String(orderId));
    return this.http.get<OrderDetails>('http://localhost:3000/api/orderDetails', {params});
  }

  public shopperOrder() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<ShopperOrder>('http://localhost:3000/api/shopperOrder', {params});
  }

  public shopperOrderId() {
    const params = new HttpParams().set('params', String(this.userId));
    return this.http.get<shopperOrderId>('http://localhost:3000/api/shopperOrderId', {params});
  }

  public insertCart(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:3000/api/addCart', cart,  { responseType: 'text' });
  }

  public updateCart(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:3000/api/updateCart', cart,  { responseType: 'text' });
  }

  public insertShopperOrder(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:3000/api/insertShopperOrder', cart,  { responseType: 'text' });
  }

  public insertOrderDetails(cart){
    console.log("cart",cart);
    return this.http.post('http://localhost:3000/api/insertOrderDetails', cart,  { responseType: 'text' });
  }
}
