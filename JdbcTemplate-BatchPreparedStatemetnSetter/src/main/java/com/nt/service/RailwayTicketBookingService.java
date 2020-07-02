package com.nt.service;

import java.util.List;

import com.nt.dto.PassengerDetailsDTO;

public interface RailwayTicketBookingService {

	public String  groupTicketReservation(List<PassengerDetailsDTO> passengerDetailsDTO);
}
