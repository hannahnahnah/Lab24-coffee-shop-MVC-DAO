package co.grandcircus.coffeeshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entity.User;

@Repository
public class UsersDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
	}
	
	public User findById(Long id) {
		User match = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
		return match;
	}
	
	public void update(User user) {
		String sql = "UPDATE users SET name = ?, user_name = ?, password = ?";
		jdbcTemplate.update(sql, user.getName(), user.getUserName(), user.getPassword());
	}
	
	public void create(User user) {
		String sql = "INSERT INTO users (name, user_name, password) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getName(), user.getUserName(), user.getPassword());
	}
	
	public void delete(Long id) {
		String sql = "DROP TABLE users WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

}
