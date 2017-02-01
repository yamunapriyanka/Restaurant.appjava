package com.yamuna.dao;

import com.yamuna.model.FoodMenu;

public class TestFoodMenuDAO {
	public static void main(String[] args) {

		FoodMenuDAO foodmenuDAO = new 	FoodMenuDAO();

		FoodMenu foodmenu = new FoodMenu();

		foodmenu.setID(20);
		foodmenu.setItems("milk");
		

		foodmenuDAO.save(foodmenu);
		// foodDAO.update(food);
		//foodDAO.delete(1);

	}
	
}