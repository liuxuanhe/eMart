import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';
import { CardComponent } from './pages/card/card.component';
import { UserLoginComponent } from './pages/user-login/user-login.component';
import { UserRregisterComponent } from './pages/user-register/user-register.component';
import { CartComponent } from './pages/cart/cart.component';
import { OrderDetailComponent } from './pages/order-detail/order-detail.component';
import { AuthGuard } from './_guards/auth.guard';
import { OrderComponent } from './pages/order/order.component';
import { Role } from './enum/Role';
import { UserDetailComponent } from './pages/user-edit/user-detail.component';
import { ProductEditComponent } from './pages/product-edit/product-edit.component';


const routes: Routes = [
  { path: '', redirectTo: '/product', pathMatch: 'full' },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'category/:id', component: CardComponent },
  { path: 'product', component: CardComponent },
  { path: 'category', component: CardComponent },
  { path: 'user-login', component: UserLoginComponent },
  { path: 'user-logout', component: UserLoginComponent },
  { path: 'user-register', component: UserRregisterComponent },
  { path: 'cart', component: CartComponent },
  { path: 'success', component: UserRregisterComponent },
  { path: 'order/:id', component: OrderDetailComponent, canActivate: [AuthGuard] },
  { path: 'order', component: OrderComponent, canActivate: [AuthGuard] },
  { path: 'seller', redirectTo: 'seller/product', pathMatch: 'full' },
  {
    path: 'seller/product',
    component: ProductListComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.Manager, Role.Employee] }
  },
  {
    path: 'profile',
    component: UserDetailComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'seller/product/:id/edit',
    component: ProductEditComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.Manager, Role.Employee] }
  },
  {
    path: 'seller/product/:id/new',
    component: ProductEditComponent,
    canActivate: [AuthGuard],
    data: { roles: [Role.Employee] }
  },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)//{onSameUrlNavigation: 'reload'}
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
