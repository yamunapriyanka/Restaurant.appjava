package com.yamuna.service;

import com.yamuna.exception.FoodServiceException;
import com.yamuna.model.FoodMenu;

public class TestFoodService {
public static void main(String[] args) {
	FoodMenuService foodservice=new FoodMenuService();
	FoodMenu foodmenu =new FoodMenu();
	foodmenu.setID(24);
	foodmenu.setItems("");
	try{
		foodservice.saveService(foodmenu);
		
	}catch (FoodServiceException e){
		e.printStackTrace();
	}
}
}
