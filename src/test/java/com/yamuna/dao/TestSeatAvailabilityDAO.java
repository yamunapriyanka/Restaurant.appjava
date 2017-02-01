package com.yamuna.dao;

import com.yamuna.model.SeatAvailability;

public class TestSeatAvailabilityDAO {
	public static void main(String[] args) {

		SeatAvailabilityDAO seatavailabilityDAO = new SeatAvailabilityDAO();

		 SeatAvailability SeatAvailability = new SeatAvailability();

		 SeatAvailability.setId(11);
		 SeatAvailability.setSeatNo(11);
		 SeatAvailability.setStatusCheck("AVAILABLE");
		 SeatAvailability.setCheckSeat(0);

		 seatavailabilityDAO.save(SeatAvailability);
			// seatsDAO.update(seats);
			// seatsDAO.delete(1);

}}
