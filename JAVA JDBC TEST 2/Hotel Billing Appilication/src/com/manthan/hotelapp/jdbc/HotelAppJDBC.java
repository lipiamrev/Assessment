package com.manthan.hotelapp.jdbc;

public interface HotelAppJDBC {
	
	public void allFood();
	
	public void takeOrder();
	
	public void deleteFood();
	
	public void modifyFood(int item_Code, String food_Name, double price);
	
	public void totalHotelBill();

	public void addFood();

}
