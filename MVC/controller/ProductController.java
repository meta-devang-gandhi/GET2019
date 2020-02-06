package com.Shopping.controller;

import java.util.List;

import com.Shopping.enums.Status;
import com.Shopping.facade.ProductFacade;
import com.Shopping.model.Product;
import com.Shopping.model.ShoppingCart;

  /**
   *This class represents a controller layer 
   */
  public class ProductController {
	
	ProductFacade facade = new ProductFacade();
	
    // Method to return the list of Product and  available stock
    public List<Product> getProducts(){
        return facade.getProducts();
    }
 
    // Method to add product to the cart
    public Status addProductToCart(int userID, int productID,int productQuantity){
        return facade.addProductToTheCart(userID, productID, productQuantity);
    }
   
    // Method to get cart items with quantity
    public List<ShoppingCart> getCartItems(int userId){
        return facade.getProductsCart(userId);
    }
     
    // Method to update cart items
    public Status updateCartItems(int userId, int productID,int productQuantity){
        return facade.updateCartItems(userId, productID, productQuantity);
    }
 
    //Method to find product Id by product name
    public int findProductIdByName(String productName)
    {
    	return facade.findProductIdByName(productName);
    }

    //Method to find product Name by product Id
	public String getProductNameById(int productId) {
		return facade.getProductNameById(productId);
	}

	// Method to delete product from cart
	public Status deleteProductFromCart(int userId, int productId) {
		return facade.deleteProductFromCart(userId, productId);
	}

	// Method to find user Id by user email
	public int findUserIdByEmailId(String emailId) {
		return facade.findUserIdByEmailId(emailId);
	}

	// Method to authenticate the user
	public boolean authenticateUser(int userId, String password) {
		return facade.authenticateUser(userId, password);
	}
}
