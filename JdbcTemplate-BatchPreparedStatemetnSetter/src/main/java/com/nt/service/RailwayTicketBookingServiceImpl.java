package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.PassengerDetailsBO;
import com.nt.dao.RailwayTicketReservationDAO;
import com.nt.dto.PassengerDetailsDTO;
@Service("service")
public class RailwayTicketBookingServiceImpl implements RailwayTicketBookingService{

	int result[]=null;
	@Autowired
	private RailwayTicketReservationDAO railwayTicketBookingServiceImpl;
	List<PassengerDetailsBO> listpassengerDeatilsBo;
	@Override
	public String groupTicketReservation(List<PassengerDetailsDTO> passengerDetailsDTO) {
		System.out.println("RailwayTicketBookingServiceImpl.groupTicketReservation()");
		listpassengerDeatilsBo = new ArrayList();
		passengerDetailsDTO.forEach(dto ->{
			PassengerDetailsBO bo=new PassengerDetailsBO();
			BeanUtils.copyProperties(dto, bo);
			listpassengerDeatilsBo.add(bo);
		});
		result = railwayTicketBookingServiceImpl.batchInsert(listpassengerDeatilsBo);
		if(result!=null) {
			System.out.println("result value is ::"+result);
			return "Group Registration succedde";
		}else {
		return "Group Registration Failed";
	}
		}

}
