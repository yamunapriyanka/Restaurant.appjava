package com.yamuna.dao;


	
	import java.time.LocalTime;

	import com.yamuna.model.FoodSchedule;



	public class TestFoodScheduleDAO {


		public static void main(String[] args) {
			
		

			FoodScheduleDAO foodscheduleDAO = new FoodScheduleDAO();
			
		 
			FoodSchedule foodschedule = new FoodSchedule();

			foodschedule.setId(6);
			foodschedule.setScheduleName("Lunch");
			foodschedule.setFromTime(LocalTime.parse("23:15:00"));
			foodschedule.setToTime(LocalTime.parse("01:15:00"));


			foodscheduleDAO.save(foodschedule);
		// foodtypeDAO.delete(5);
			
		}
}


