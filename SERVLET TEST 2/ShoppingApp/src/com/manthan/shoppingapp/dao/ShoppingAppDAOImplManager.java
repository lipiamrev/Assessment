package com.manthan.shoppingapp.dao;


public class ShoppingAppDAOImplManager {

	public ShoppingAppDAOImplManager() {

	}

	public static ShoppingAppDAOImplementation getDAOInstance() {

		return new ShoppingAppDAOImplementation();

	}
}
