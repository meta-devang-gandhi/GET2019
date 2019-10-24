import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { HomeComponent } from './home/home.component';
import { ProductItemComponent } from './product-item/product-item.component';
import { CartComponent } from './cart/cart.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { OrderReceivedComponent } from './order-received/order-received.component';
import { OrdersComponent } from './orders/orders.component';

const appRoute : Routes = [
   { path: 'cart/:userId', component: CartComponent },
  { path: 'home', component: HomeComponent },
  { path: 'nav-bar', component: NavbarComponent },
  { path: 'order-confirmation', component: OrderConfirmationComponent },
  { path: 'order-received', component: OrderReceivedComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'order-detail/:orderId', component: OrderDetailComponent },
  { path: 'app-component', component: AppComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CategoryListComponent,
    HomeComponent,
    ProductItemComponent,
    CartComponent,
    OrderConfirmationComponent,
    OrderDetailComponent,
    OrderReceivedComponent,
    OrdersComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoute
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
