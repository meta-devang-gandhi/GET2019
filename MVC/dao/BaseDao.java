package com.Shopping.dao;

import java.util.List;
import com.Shopping.enums.Status;
import com.Shopping.model.*;

/**
 * This is the base dao.
 */
public interface BaseDao<T extends BaseEntity> {
   
     //Method to return the list of Product and  available stock
    public List<Product> getAllProduct(String query);
    
    // Method to add product into cart
    public Status addProductToCart(String query);
    
    //Method to get cart items with quantity
    public List<ShoppingCart> getCart(String query);
        
    // Method to update cart items
    public Status updateProductsInCart(String query);
    
    //Method to find product id by product name  
	public int findProductIdByName(String query);

    //Method to find product Name by product Id 
	public String getProductNameById(String query);

    // Method to delete product from cart
	public Status deleteProductFromCart(String query);
	
    // Method to find user Id by user email
	public int findUserIdByEmailId(String query);

	// Method to authenticate the user.
	public boolean authenticateUser(String query);  
}
