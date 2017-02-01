package com.yamuna.validator;

import com.yamuna.exception.InvalidFoodException;
import com.yamuna.model.FoodMenu;

public class ItemValidator{
	public void validateSave(FoodMenu foodmenu) throws InvalidFoodException
	{
		if("".equals(foodmenu.getItems().trim()) || foodmenu.getItems()==null)
		{
			throw new InvalidFoodException("Food name should be filled");
		}
	}
}
	



