package sample;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoffeeDao {

	private final NamedParameterJdbcTemplate jdbc;

	public CoffeeDao() {
		this.jdbc = new NamedParameterJdbcTemplate(DbUtilities
				.getDataSource("jdbc:mysql://127.0.0.1:3306/bak?serverTimezone=UTC", "username", "password"));
	}

	/**
	 * Returns a coffee with given name.
	 *
	 * @param name coffee name
	 * @return coffee object or null
	 */
	public Coffee get(String name) {
		String sql = "SELECT COF_NAME, COF_DESC FROM COFFEE_DESCRIPTIONS "
				+ "WHERE cof_name = :cof_name";
		MapSqlParameterSource params = new MapSqlParameterSource("cof_name", name);

		return jdbc.queryForObject(sql, params, (rs, rowNum) -> new Coffee(
				name,
				rs.getInt("SUP_ID"),
				rs.getBigDecimal("PRICE"),
				rs.getInt("SALES"),
				rs.getInt("TOTAL")));
	}

	/**
	 * Returns a list of all coffees.
	 *
	 * @return list of all coffees
	 */
	public List<Coffee> getAll() {
		String sql = "SELECT cof_name, sup_id, price, sales, total FROM coffees";
		try {
			return jdbc.query(
					sql,
					new BeanPropertyRowMapper<>(CoffeTO.class))
					.stream()
					.map(coffeTO -> new Coffee(coffeTO.getCof_name(),
							coffeTO.getSup_id(),
							coffeTO.getPrice(),
							coffeTO.getSales(),
							coffeTO.getTotal()))
					.collect(Collectors.toList());

		} catch (EmptyResultDataAccessException ex) {
			return new ArrayList<>();
		}
	}

	public void update(Coffee c) {
		String sql = "UPDATE coffees "
				  + "SET price = :price, sales = :sales, total = :total "
				  + "WHERE cof_name = :cof_name AND sup_id = :sup_id";

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}

	public void delete(String cof_name, int sup_id) {
		String sql = "DELETE FROM coffees WHERE cof_name = :cof_name AND sup_id = :sup_id";

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("cof_name", cof_name);
		parameters.put("sup_id", sup_id);
		jdbc.update(sql, parameters);
	}

	public void create(Coffee c) {
		String sql = "INSERT INTO coffees(cof_name, sup_id, price, sales, total) " +
				"VALUES(:cof_name, :sup_id, :price, :sales, :total)";

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("price", c.getPrice());
		parameters.put("sales", c.getSales());
		parameters.put("total", c.getTotal());
		parameters.put("cof_name", c.getName());
		parameters.put("sup_id", c.getSupplierId());
		jdbc.update(sql, parameters);
	}
}
