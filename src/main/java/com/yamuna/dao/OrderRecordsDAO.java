package com.yamuna.dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.FoodMenu;
import com.yamuna.model.OrderRecords;
import com.yamuna.model.SeatAvailability;
import com.yamuna.util.ConnectionUtil;

	public class OrderRecordsDAO {

		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		/**
		 * TO INSERT A RECORD INTO THE FoodTransaction RELATION.
		 * 
		 * @param foodtransaction
		 */
		public void save(final OrderRecords orderrecords) {
			final String sql = "insert into order_records(order_id,seat_no,food_ordered,quantity) values (?,?,?,?)";
			final Object[] params = {orderrecords.getOrderId(), orderrecords.getSeatNo(), orderrecords.getFoodOrdered(),orderrecords.getQuantity() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO UPDATE A RECORD IN THE FoodTransaction RELATION.
		 * 
		 * @param foodtransaction
		 */
		public void update(final OrderRecords orderrecords) {
			final String sql = "update order_records set quantity=? where order_id=? ";
			final Object[] params = { orderrecords.getQuantity(), orderrecords.getOrderId() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO DELETE A RECORD FROM THE FoodTransaction RELATION.
		 * 
		 * @param foodtransaction
		 */
		public void delete(final int id) {
			final String sql = "delete from order_records where order_id=?";

			final int rows = jdbcTemplate.update(sql, id);
			System.out.println(rows);

		}

		/**
		 * TO VIEW ALL THE ITEMS WITH THEIR FROM FROM THE FoodTransaction RELATION.
		 * 
		 * @param foodtransaction
		 */
		public List<OrderRecords> list() {
			final String sql = "select order_id,seat_no,food_ordered,quantity,order_date,order_status,bill_status from order_records";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				final OrderRecords orderrecords = convert(rs);
				return orderrecords;

			});
		}

		static OrderRecords convert(final ResultSet rs) throws SQLException {
			final OrderRecords orderrecords = new OrderRecords();
			orderrecords.setOrderId(rs.getInt("order_id"));
		    
			orderrecords.setSeatNo(rs.getInt("seat_no"));
		   orderrecords.setQuantity(rs.getInt("quantity"));
		   orderrecords.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
			orderrecords.setOrderStatus(rs.getString("order_status"));
			orderrecords.setBillStatus(rs.getString("bill_status"));



			return orderrecords;
		}

	}




