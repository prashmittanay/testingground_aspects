package testing.ground.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MiscDao {
	@Autowired NamedParameterJdbcTemplate template;
	
	public List<String> getAutoUsers(String terms){
		String query = "select email from users where email like :email limit 10";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", "%"+terms+"%");
		return template.queryForList(query, paramMap, String.class);
	}
}
