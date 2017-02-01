package com.yamuna.dao;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yamuna.model.FoodMenu;
import com.yamuna.util.ConnectionUtil;

public class FoodMenuDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(FoodMenu foodmenu) {

		String sql = "insert into food_menu(id,items) values(?,?)";
		Object[] params = { foodmenu.getID(), foodmenu.getItems() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(FoodMenu foodmenu) {

		String sql = "update food_menu set items=? where id=?";
		Object[] params = { foodmenu.getItems(), foodmenu.getID() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from foodmenu where id=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

}


