package com.yamuna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
  



import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.FoodFeast;
import com.yamuna.model.FoodMenu;
import com.yamuna.model.FoodSchedule;
import com.yamuna.util.ConnectionUtil;

public class FoodFeastDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public void save(final FoodFeast foodfeast) {
		final String sql = "insert into food_feast(id,schedule_id,food_items,quantity) values (?,?,?,?)";
		final Object[] params = { foodfeast.getID(), foodfeast.getScheduleId().getId(), foodfeast.getFooditems(), foodfeast.getQuantity() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO UPDATE A RECORD IN THE Foodfeast RELATION.
	 * 
	 * @param foodfeast
	 */
	public void update(final FoodFeast foodfeast) {
		final String sql = "update food_stocks set quantity=? where sno=? ";
		final Object[] params = { foodfeast.getQuantity(), foodfeast.getID() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public void delete(final int id) {
		final String sql = "delete from food_feast where id=?";

		final int rows = jdbcTemplate.update(sql, id);
		System.out.println(rows);

	}

	/**
	 * TO VIEW ALL THE ITEMS WITH THEIR FROM THE FoodStocks RELATION.
	 * 
	 * @param foodstocks
	 */
	public List<FoodFeast> list() {
		final String sql = "select id,schedule_id,food_items,quantity from food_feast";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final FoodFeast foodstocks = convert(rs);
			return foodstocks;

		});
	}

	    static FoodFeast convert(final ResultSet rs) throws SQLException {
		final FoodFeast foodfeast = new FoodFeast();
		foodfeast.setID(rs.getInt("id"));
		FoodSchedule foodschedule= new FoodSchedule();
	    foodschedule.setId(rs.getInt("id"));
		foodfeast.setScheduleId(foodschedule);           		

		FoodMenu foodmenu=new FoodMenu();
		foodmenu.setID(rs.getInt("id"));
		foodfeast.setFooditems(foodmenu);
	
		foodfeast.setQuantity(rs.getInt("quantity"));


		return foodfeast;
	}

}