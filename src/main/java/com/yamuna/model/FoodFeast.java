package com.yamuna.model;


	import lombok.Data;

	@Data
	public class FoodFeast {

		private int ID;
		private FoodSchedule scheduleId;
		private FoodMenu fooditems;
		private int quantity;
		
	

}
