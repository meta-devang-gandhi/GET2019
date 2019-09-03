package com.Shopping.model;

/**
 * This class represents a Shopping Cart
 */
public class ShoppingCart extends BaseEntity {
	private int productId;
	private int productQuantity;
	private int userId;
	
	/**
	 * Initialize the cart product information.
	 * @param cartId
	 * @param userId
	 * @param productId
	 * @param productQuantity
	 */
	public ShoppingCart(int cartId, int userId, int productId, int productQuantity)
	{
		super(cartId);
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.userId = userId;
	}
	
	//Default constructor. 
	public ShoppingCart() {
		super();
	}
	
	//Return the product id.
	public int getProductId() {
		return productId;
	}
	
	//Return the product quantity. 
	public int getProductQuantity() {
		return productQuantity;
	}
	
	//Return the userId.
	public int getUserId() {
		return userId;
	}
}
