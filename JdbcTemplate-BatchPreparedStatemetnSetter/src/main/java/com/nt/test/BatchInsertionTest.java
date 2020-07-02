package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.PassengerDetailsDTO;
import com.nt.service.RailwayTicketBookingService;
import com.nt.service.RailwayTicketBookingServiceImpl;

public class BatchInsertionTest {

	public static void main(String[] args) {
		ApplicationContext context = null;
		RailwayTicketBookingService service = null;
		String result = null;
		Scanner sc = null;
		String passengerName = null;
		int age = 0;
		String gender = null;
		String source = null;
		String destination = null;
		double price = 0.0f;
		int groupSize = 0;
		List<PassengerDetailsDTO> listdto = new ArrayList();
		PassengerDetailsDTO dto = null;
		sc = new Scanner(System.in);
		try {
			System.out.println("Please Enter group size number ::");
			groupSize = sc.nextInt();
			if (groupSize > 0) {
				System.out.println("Enter Source place :: ");
				source = sc.next();
				System.out.println("Enter destination page :: ");
				destination = sc.next();
				System.out.println("Enter price details ::");
				price = sc.nextDouble();
				for (int i = 0; i < groupSize; i++) {
					System.out.println("Enter the name ::");
					passengerName = sc.next();
					System.out.println("Enter the age ::");
					age = sc.nextInt();
					System.out.println("Enter the gender");
					gender = sc.next();
					dto = new PassengerDetailsDTO();
					dto.setPassengerName(passengerName);
					dto.setAge(age);
					dto.setGender(gender);
					dto.setSourcePlace(source);
					dto.setDestinationPlace(destination);
					dto.setPrice(price);
					listdto.add(dto);
				}
			} else {
				System.out.println("Invalid Group size :: ");
			}
		} catch (Exception e) {

		}
		try {
			context = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			service = context.getBean("service", RailwayTicketBookingServiceImpl.class);
			result = service.groupTicketReservation(listdto);
			System.out.println("result ::" + result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext)context).close();
	}
}
