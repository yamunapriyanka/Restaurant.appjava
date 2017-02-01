package com.yamuna.dao;



	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.JdbcTemplate;

	import com.yamuna.model.FoodSchedule;
	import com.yamuna.util.ConnectionUtil;

	public class FoodScheduleDAO {
		private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

		/**
		 * TO INSERT A RECORD INTO THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void save(final FoodSchedule category) {
			final String sql = "insert into food_schedule (id,schedule_name,from_time,to_time) values (?,?,?,?) ";
			final Object[] params = { category.getId(), category.getScheduleName(), category.getFromTime(),
					category.getToTime() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO DELETE A RECORD FROM THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void delete(final int id) {
			final String sql = "delete from food_schedule where id=?";
			final Object[] params = { id };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO UPDATE A RECORD IN THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public void update(final FoodSchedule category) {
			final String sql = "update food_schedule set =schedule_name? where id=?";
			final Object[] params = { category.getScheduleName(), category.getId() };
			final int rows = jdbcTemplate.update(sql, params);
			System.out.println(rows);
		}

		/**
		 * TO LIST ALL THE RECORDS IN THE CATEGORY RELATION
		 * 
		 * @param category
		 */
		public List<FoodSchedule> list() {
			final String sql = "select ID,schedule_name,start_time,to_time from food_schedule";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				FoodSchedule FoodSchedule  = convert(rs);
				return FoodSchedule;
			});

		}
	 /**
	  * Converts Object to ResultSet
	  * @param rs
	  * @return
	  * @throws SQLException
	  */
		static FoodSchedule convert(final ResultSet rs) throws SQLException {
			final FoodSchedule category = new FoodSchedule();
			category.setId(rs.getInt("ID"));
			category.setScheduleName(rs.getString("schedule_name"));
			category.setFromTime(rs.getTime("from_time").toLocalTime());
			category.setToTime(rs.getTime("to_time").toLocalTime());
			return category;
		}
	}


