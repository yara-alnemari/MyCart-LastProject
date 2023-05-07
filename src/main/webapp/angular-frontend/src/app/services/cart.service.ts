import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/Order';
import { Product } from '../models/Product';
import { ProductItemComponent } from '../components/product-item/product-item.component';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  cartProducts: any[] = [];
  baseUrl = 'http://localhost:8080/orders/';

  constructor(private http: HttpClient) {}

  getCartProducts() {
    return this.cartProducts;
  }

  addToCart(product: any, selectedQuantity: any): void {
    // Check if the product is already in the cart
    const existingProductIndex = this.cartProducts.findIndex((p) => p.id === product.id);
    
    if (existingProductIndex >= 0) {
    // If the product is already in the cart, increase the quantity
    this.cartProducts[existingProductIndex].amount += parseInt(selectedQuantity);
     console.log(selectedQuantity);
    } 
     else {
    // If the product is not in the cart, add it with the selected quantity
    const productToAdd = { ...product, amount: selectedQuantity };
    this.cartProducts.push(productToAdd);
    console.log(selectedQuantity);
   }
    
    // Show a message to indicate that the item has been added to the cart
    alert('Added to cart! :)');
    }

  clearCart() {
    this.cartProducts = [];
    return this.cartProducts;
  }

  updateCart(cart: any) {
    this.cartProducts = cart;

    return this.cartProducts;
  }

 submitOrder(order: any): Observable<any> {
  //Submit the order information the API
  return this.http.post<Order>(this.baseUrl+'addOrder', order, {
    headers: { Authorization: 'Basic dWRhY2l0eTpwYXNzd29yZA==' },
  });
  }
}
