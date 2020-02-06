package com.Shopping.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Shopping.controller.ProductController;
import com.Shopping.enums.Status;
import com.Shopping.model.Product;
import com.Shopping.model.ShoppingCart;

/**
 * This class represents the VIEW layer of the system
 */
public class Main {

	static Scanner inputScanner = new Scanner(System.in);
	static ProductController productController = new ProductController();
	
	public static void main(String[] args) {
		
		int userId = showAutenticationPage();
		if(userId > 0)
		{
			String choice;
			Status status = null;
			String productName, productQuantity;
			int productId;
			List<ShoppingCart> cartItems = new ArrayList<>();
			Loop : do
			{
				showMenu();
				choice = inputScanner.nextLine();
				switch(choice)
				{
					case "1" : 
						showProducts();
						System.out.print("\nEnter product name : ");
						productName = inputScanner.nextLine();
						System.out.print("Enter product quantity : ");
						productQuantity = inputScanner.nextLine();
						productId = productController.findProductIdByName(productName);
						try
						{
							status = productController.addProductToCart(userId, productId, Integer.parseInt(productQuantity));
						}
						catch (NumberFormatException e) {
							System.out.println("Enter the quantity in number .");
							continue Loop;
						}
						if(status == Status.ADDED)
						{
							System.out.println("Product added to the cart");
						}
						else
						{
							System.out.println("There was an error while adding the product to the cart");
						}
						break;
						
					case "2" : 
						cartItems = productController.getCartItems(userId);
						if(cartItems.size() > 0)
						{
							int i = 0;
							System.out.println("\nYou have following products in the cart : ");
							for(ShoppingCart item : cartItems)
							{
								System.out.println("Product " + (++i));
								String product = productController.getProductNameById(item.getProductId());
								System.out.println("\tProduct Name : " + product);
								System.out.println("\tProduct Quantity : " + item.getProductQuantity());
							}
						}
						else
						{
							System.out.println("Your cart is Empty");
						}
						break;
						
					case "3" :
						System.out.print("\nEnter product name whose quantity is to be updated : ");
						productName = inputScanner.nextLine();
						System.out.print("Enter the new quantity : ");
						productQuantity = inputScanner.nextLine();
						productId = productController.findProductIdByName(productName);
						if(Integer.parseInt(productQuantity) == 0)
						{
							status = productController.deleteProductFromCart(userId, productId);
						}
						else
						{
							status = productController.updateCartItems(userId, productId, Integer.parseInt(productQuantity));
						}
						if(status == Status.UPDATED)
						{
							System.out.println("Product Updated in the cart");
						}
						else
						{
							System.out.println("There was an error while updating the product to the cart");
						}
						break;
						
					case "4" :
						System.out.print("\nEnter product name which is to be deleted : ");
						productName = inputScanner.nextLine();
						productId = productController.findProductIdByName(productName);
						status = productController.deleteProductFromCart(userId, productId);
						if(status == Status.UPDATED)
						{
							System.out.println("Product Deleted from the cart");
						}
						else
						{
							System.out.println("There was an error while updating the product to the cart");
						}
						break;
						
						default : 
							System.out.println("Please Enter a valid choice");
				}
			}while("5".equals(choice) == false);
			
			System.out.println("\nThank You For Shopping");
		}
		else
		{
			System.out.println("Incorrect Email Id or Password. Please Enter Again");
			main(args);
		}
	}
	
	/**
	 * Method is used to authenticate the user
	 * @return user id of the authenticated user
	 */
	static int showAutenticationPage() {
		System.out.print("\nEnter Email Id : ");
		String emailId = inputScanner.nextLine();
		System.out.print("Enter Password : ");
		String password = inputScanner.nextLine();
		int userId = productController.findUserIdByEmailId(emailId);
		boolean isUserAuthenticated = productController.authenticateUser(userId, password);
		if(isUserAuthenticated)
		{
			return userId;
		}
		else
		{
			return -1;
		}
	}

	/**
	 * Method displays the products in the database
	 */
	static void showProducts() {
		List<Product> productList = new ArrayList<>();
		productList = productController.getProducts();
		int i = 0;
		System.out.println("\nYou can add following products in the cart : ");
		for(Product product : productList)
		{
			System.out.println("Product " + (++i));
			System.out.println("\tProduct Name : " + product.getProductName());
			System.out.println("\tProduct Type : " + product.getProductType());
			System.out.println("\tProduct Price : " + product.getProductPrice());
		}
	}

	/**
	 * This method displays the menu
	 */
	static void showMenu()
	{
		System.out.println("\n1. Add Product to the cart");
		System.out.println("2. Display the cart.");
		System.out.println("3. Update an Item's quantity in the cart");
		System.out.println("4. Delete Product from Cart");
		System.out.println("5. Logout");
		System.out.print("\nEnter your choice : ");
	}
}
