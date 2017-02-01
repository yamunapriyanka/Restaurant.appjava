package com.yamuna.model;
import lombok.Data;

@Data

public class SeatAvailability {
  private int id;
  private int seatNo;
  private String statusCheck;
  private int checkSeat;
}
