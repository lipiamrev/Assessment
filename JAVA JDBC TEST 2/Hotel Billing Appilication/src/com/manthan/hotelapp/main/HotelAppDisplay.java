package com.manthan.hotelapp.main;

import java.util.Scanner;

import com.manthan.hotelapp.jdbc.HotelAppJDBC;
import com.manthan.hotelapp.jdbc.HotelAppJDBCImplementation;

public class HotelAppDisplay {

	public static void main(String[] args) {

		HotelAppJDBC hotel_app_jdbc = new HotelAppJDBCImplementation();

		int item_Code;
		String food_Name;
		double price;

		int options;
		boolean flag = true;
		String update;

		System.out.println("WELCOME TO THE HOTEL");

		do
		{
			System.out.println("Please select one of the following options:");
			System.out.println("1. Press 1 to show all food items."
					+ "2. Press 2 to give order."
					+ "3. Press 3 to operate on food items."
					+ "4. Press 4 to know Total Bill.");

			Scanner sc = new Scanner(System.in);

			options = sc.nextInt();

			switch (options) {
			case 1:

				hotel_app_jdbc.allFood();
				break;

			case 2:

//				System.out.println("Select  order:");
//				
//				Scanner sc1 = new Scanner(System.in);
//				int take = sc1.nextInt();
				
				hotel_app_jdbc.takeOrder();
				break;

			case 3:
				
				System.out.println("Select any one operation on food items:");
				System.out.println("1. Press A to add food item."
						+ "2. Press B to remove food item."
						+ "3. Press C to modify food item.");
				
				Scanner sc2 = new Scanner(System.in);
				update = sc2.next();
				
				if(update.compareTo("A")==0) {
					System.out.println("Enter Item Code, Food Name, Price");
					
					hotel_app_jdbc.addFood();
					
				}
				
				if(update.compareTo("B")==0) {
//					System.out.println("Enter Item Code:");
//					
//					Scanner sc3 = new Scanner(System.in);
//					int update_del = sc3.nextInt();
					
					hotel_app_jdbc.deleteFood();
				}
				
				if(update.compareTo("C")==0) {
					System.out.println("Enter the modificatons on food");
					
					System.out.println("Enter Item code:");
					Scanner sc4 = new Scanner(System.in);
					item_Code = sc4.nextInt();
					
					System.out.println("Enter Food Name:");
					Scanner sc5 = new Scanner(System.in);
					food_Name = sc5.nextLine();
					
					System.out.println("Enter Price:");
					Scanner sc6 = new Scanner(System.in);
					price = sc6.nextDouble();
					
					hotel_app_jdbc.modifyFood(item_Code, food_Name, price);
				}
				break;

			case 4:

				hotel_app_jdbc.totalHotelBill();
				break;

			default:
				System.out.println("Invalid Option Selected");
				break;
			}
		}

		while(flag);
		System.out.println("Thank You for Visiting!");


	}
}
