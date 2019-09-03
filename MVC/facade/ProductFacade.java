package com.Shopping.facade;

import java.util.List;

import com.Shopping.dao.ProductDao;
import com.Shopping.enums.DBType;
import com.Shopping.enums.Status;
import com.Shopping.factory.Factory;
import com.Shopping.model.Product;
import com.Shopping.model.ShoppingCart;

/**
 * This class represents the facade layer of the system
 */
public class ProductFacade {

	ProductDao productDao = Factory.createProductDao(DBType.MYSQL);
	
	// This method generates a query to display all products
	public List<Product> getProducts()
	{
		String query = "SELECT * FROM Product;";
		return productDao.getAllProduct(query);
	}
	
	//This method generates a query to add product to the cart
	public Status addProductToTheCart(int userId, int productId, int productQuantity)
	{
		String query = "INSERT INTO ShoppingCart (user_id, product_id, product_quantity) VALUES (" + 
									userId + ", " + productId + ", " + productQuantity + ")";
		return productDao.addProductToCart(query);
	}
	
	// This method generates a query to display the cart
	public List<ShoppingCart> getProductsCart(int userId)
	{
		String query = "SELECT * FROM ShoppingCart WHERE user_id=" + userId + "";
		return productDao.getCart(query);
	}
	
	//This method generate a query to updates the cart
	public Status updateCartItems(int userId, int productId, int productQuantity)
	{
		String query = "UPDATE ShoppingCart SET product_quantity=" + productQuantity + " WHERE user_id =" + userId + " AND product_id=" + productId ;
		return productDao.updateProductsInCart(query);
	}

	// This method generate a query to find product Id by product name/
	public int findProductIdByName(String productName) {
		String query = "SELECT product_id FROM Product WHERE product_name = " + productName ;
		return productDao.findProductIdByName(query);
	}

	//This method generate a query to find product Name by product Id
	public String getProductNameById(int productId) {
		String query = "SELECT product_name FROM Product WHERE product_id = " + productId ;
		return productDao.getProductNameById(query);
	}

	// This method generate a query to delete product from cart
	public Status deleteProductFromCart(int userId, int productId) {
		String query = "DELETE FROM ShoppingCart WHERE user_id=" + userId + " AND product_id=" + productId ;
		return productDao.deleteProductFromCart(query);
	}

	// This method generate a query to find user Id by user email
	public int findUserIdByEmailId(String emailId) {
		String query = "SELECT user_id FROM Users WHERE user_email=" + emailId ;
		return productDao.findUserIdByEmailId(query);
	}

	// This method generate a query to authenticate the user
	public boolean authenticateUser(int userId, String password) {
		String query = "SELECT user_id FROM Users WHERE user_id=" + userId + " AND user_password=" + password ;
		return productDao.authenticateUser(query);
	}
}
