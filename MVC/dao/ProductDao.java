package com.Shopping.dao;

import java.sql.SQLException;
import java.util.List;

import com.Shopping.enums.DBType;
import com.Shopping.enums.Status;
import com.Shopping.model.Product;
import com.Shopping.model.ShoppingCart;

public class ProductDao implements BaseDao<Product> {
	
	BaseDao<Product> baseDao;
	
	public ProductDao(DBType dbType) throws ClassNotFoundException, SQLException
	{
		if(dbType == DBType.IN_MEMORY)
		{
			baseDao = new InMemoryDao();
		}
		else
		{
			baseDao = new SQLDao();
		}
	}

	@Override
	public List<Product> getAllProduct(String query) {
		return baseDao.getAllProduct(query);
	}

	@Override
	public Status addProductToCart(String query) {
		return baseDao.addProductToCart(query);
	}

	@Override
	public List<ShoppingCart> getCart(String query) {
		return baseDao.getCart(query);
	}

	@Override
	public Status updateProductsInCart(String query) {
		return baseDao.updateProductsInCart(query);
	}

	@Override
	public int findProductIdByName(String query) {
		return baseDao.findProductIdByName(query);
	}

	@Override
	public String getProductNameById(String query) {
		return baseDao.getProductNameById(query);
	}

	@Override
	public Status deleteProductFromCart(String query) {
		return baseDao.deleteProductFromCart(query);
	}

	@Override
	public int findUserIdByEmailId(String query) {
		return baseDao.findUserIdByEmailId(query);
	}

	@Override
	public boolean authenticateUser(String query) {
		return baseDao.authenticateUser(query);
	}

}
