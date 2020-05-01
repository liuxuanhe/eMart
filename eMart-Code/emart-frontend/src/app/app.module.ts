import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { NavigationComponent } from './parts/navigation/navigation.component';
import { PaginationComponent } from './parts/pagination/pagination.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CookieService } from "ngx-cookie-service";
import { JwtInterceptor } from './_interceptors/jwt-interceptor.service';
import { ErrorInterceptor } from './_interceptors/error-interceptor.service';
import { CardComponent } from './pages/card/card.component';
import { UserLoginComponent } from './pages/user-login/user-login.component';
import { UserRregisterComponent } from './pages/user-register/user-register.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { CartComponent } from './pages/cart/cart.component';
import { OrderComponent } from './pages/order/order.component';
import { OrderDetailComponent } from './pages/order-detail/order-detail.component';
import { UserDetailComponent } from './pages/user-edit/user-detail.component';
import { ProductEditComponent } from './pages/product-edit/product-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    PaginationComponent,
    ProductListComponent,
    CardComponent,
    UserLoginComponent,
    UserRregisterComponent,
    ProductDetailComponent,
    CartComponent,
    OrderComponent,
    OrderDetailComponent,
    UserDetailComponent,
    ProductEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [CookieService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
