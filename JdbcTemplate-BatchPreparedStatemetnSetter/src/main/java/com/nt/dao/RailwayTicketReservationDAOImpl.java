package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PassengerDetailsBO;
@Repository("railwayDao")
public class RailwayTicketReservationDAOImpl implements RailwayTicketReservationDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int[] result;
	private static final String RAIWAY_TICKET_RESERVATION = "INSERT INTO RAILWAY_RESERVATION VALUES(NULL,?,?,?,?,?,?)";
	

	@Override
	public int[] batchInsert(List<PassengerDetailsBO> passengerDetails) {
		result = jdbcTemplate.batchUpdate(RAIWAY_TICKET_RESERVATION, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				System.out.println(
						"RailwayTicketReservationDAOImpl.batchInsert(...).new BatchPreparedStatementSetter() {...}.setValues()");
				ps.setString(1, passengerDetails.get(i).getPassengerName());
				ps.setInt(2, passengerDetails.get(i).getAge());
				ps.setString(3, passengerDetails.get(i).getGender());
				ps.setString(4, passengerDetails.get(i).getSourcePlace());
				ps.setString(5, passengerDetails.get(i).getDestinationPlace());
				ps.setDouble(6, passengerDetails.get(i).getPrice());
			}

			@Override
			public int getBatchSize() {
				System.out.println(
						"RailwayTicketReservationDAOImpl...getBatchSize()"+passengerDetails.size());
				return passengerDetails.size();
			}
		});
		return result;
	}

}
