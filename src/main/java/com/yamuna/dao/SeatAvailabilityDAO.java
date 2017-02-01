package com.yamuna.dao;


	
	
	
	import java.sql.ResultSet;

	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

	import com.yamuna.model.SeatAvailability;
	import com.yamuna.util.ConnectionUtil;


public class SeatAvailabilityDAO {



		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		/**
		 * TO INSERT A RECORD INTO THE SEATS RELATION.
		 * 
		 * @param seats
		 */
		public void save(final SeatAvailability seatavailability) {
			final String sql = "insert into seat_availability(id,seat_no,status_check,check_seat) values (?,?,?,?)";
			final Object[] params = { seatavailability.getId(),  seatavailability.getSeatNo(),  seatavailability.getStatusCheck(), seatavailability.getCheckSeat() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO UPDATE A RECORD IN THE SEATS RELATION.
		 * 
		 * @param seats
		 */
		public void update(final SeatAvailability seatavailability ) {
			final String sql = "update seat_availability set check_seat=? where id= ?";
			final Object[] params = { seatavailability.getCheckSeat(), seatavailability.getId() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO DELETE A RECORD FROM THE SEATS RELATION.
		 * 
		 * @param seats
		 */
		public void delete(final int id) {
			final String sql = "delete from seats where id=?";
			final int rows = jdbcTemplate.update(sql, id);
			System.out.println(rows);
		}

		/**
		 * TO VIEW ALL THE SEATS FROM THE SEATS RELATION.
		 * 
		 * @param seats
		 */
		public List<SeatAvailability> list() {
			final String sql = "Select sno,id,seat_status,availability from seats";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				final SeatAvailability seatavailability = convert(rs);
				return seatavailability;
			});

		}

		public SeatAvailability convert(final ResultSet rs) throws SQLException {
			final SeatAvailability seatavailability = new SeatAvailability();
			seatavailability.setId(rs.getInt("id"));
			seatavailability.setSeatNo(rs.getInt("seatNo"));
			seatavailability.setStatusCheck(rs.getString("statusCheck"));
			seatavailability.setCheckSeat(rs.getInt("check_seat"));

			return seatavailability;
		}

	}





