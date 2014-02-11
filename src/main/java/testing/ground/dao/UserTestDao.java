package testing.ground.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserTestDao {
	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Map<String, Object>> getAllUsers(){
		String query = "SELECT * FROM SCG_USERS ORDER BY USERNAME LIMIT 10";
		return template.queryForList(query, new HashMap<String, String>());
	}
}
