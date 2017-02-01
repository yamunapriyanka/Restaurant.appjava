package com.yamuna.service;

import com.yamuna.dao.FoodMenuDAO;
import com.yamuna.exception.FoodServiceException;
import com.yamuna.exception.InvalidFoodException;
import com.yamuna.model.FoodMenu;
import com.yamuna.validator.ItemValidator;

public class FoodMenuService {
 public void saveService(FoodMenu foodmenu) throws FoodServiceException
 {
	 ItemValidator foodvalidator = new ItemValidator();
	 FoodMenuDAO fooddao =new FoodMenuDAO();
	 try{
		 foodvalidator.validateSave(foodmenu);
		 fooddao.save(foodmenu);
	 } catch(InvalidFoodException e){
	 throw new FoodServiceException("Food value is mandatory");
 }
 }
}
