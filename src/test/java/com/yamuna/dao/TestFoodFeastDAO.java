package com.yamuna.dao;

import java.util.Iterator;
import java.util.List;

import com.yamuna.model.FoodFeast;

public class TestFoodFeastDAO {
	public static void main(String[] args) {
		FoodFeastDAO foodfeastDAO = new FoodFeastDAO();

		// FoodFeast foodfeast = new FoodFeast();
		// foodfeast.setID(17);
		// foodfeast.setScheduleId(4);
		// foodfeast.setFooditems(11);
		// foodfeast.setQuantity(300);

		// foodfeastDAO.save(foodfeast);
		foodfeastDAO.delete(4);

		List<FoodFeast> list = foodfeastDAO.list();
		Iterator<FoodFeast> i = list.iterator();
		while (i.hasNext()) {
			FoodFeast foodfeast1 = (FoodFeast) i.next();
			System.out.println(foodfeast1.getID() + "\t" + foodfeast1.getScheduleId().getId() + "\t"
					+ foodfeast1.getFooditems().getID() + "\t" + foodfeast1.getQuantity());
		}
	}

}
