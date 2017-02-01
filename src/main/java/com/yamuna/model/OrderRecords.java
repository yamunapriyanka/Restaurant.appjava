package com.yamuna.model;
import java.time.LocalDateTime;

import lombok.Data;

 @Data

public class OrderRecords {

	private int OrderId;
	private int seatNo;
	private String foodOrdered;
	private int quantity;
	private LocalDateTime orderDate;
	private String orderStatus;
	private String billStatus;
	
}
