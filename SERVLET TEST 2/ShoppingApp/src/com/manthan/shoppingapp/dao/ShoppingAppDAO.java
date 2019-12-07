package com.manthan.shoppingapp.dao;

import com.manthan.shoppingapp.bean.ShoppingAppBean;

public interface ShoppingAppDAO {

	ShoppingAppBean authenticate(String email, String password);

	boolean register(Object setUser_id);

	ShoppingAppBean searchProduct(String product_name);

	ShoppingAppBean orderProduct(int product_id);
	
	double ordersum(double product_cost, int no_of_products);
}