package com.yamuna.model;



import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodSchedule {
	private int id;
	private String scheduleName;
	private LocalTime fromTime;
	private LocalTime toTime;
	private String quantity;

}
