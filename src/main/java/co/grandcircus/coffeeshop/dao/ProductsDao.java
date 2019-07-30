package co.grandcircus.coffeeshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entity.Product;
import co.grandcircus.coffeeshop.entity.User;

@Repository
public class ProductsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> findAll() {
		return jdbcTemplate.query("SELECT * FROM products", new BeanPropertyRowMapper<>(Product.class));
	}
	
	public User findById(Long id) {
		User match = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
		return match;
	}
	
	public void update(Product product) {
		String sql = "UPDATE products SET name = ?, description = ?, price = ?";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice());
	}
	
	public void create(Product product) {
		String sql = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice());
	}
	
	public void delete(Long id) {
		String sql = "DROP TABLE products WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
}
