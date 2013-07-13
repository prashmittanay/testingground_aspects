package testing.ground.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import testing.ground.model.JqGridBean;

@Repository
public class JqDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Map<String, Object>> getUsers() {
		String query = "select email, name, role from users";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.queryForList(query, paramMap);
	}

	public List<Map<String, Object>> getJqUsers(String id, String sort, int start, int limit) {
		String query = "select email, name, role from users";
		String ordering = " order by "+id+" "+sort;
		String limiting = " limit "+start+","+limit;
		String finalQuery = query+ordering+limiting;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.queryForList(finalQuery, paramMap);
	}

	public int getJqUsersCount() {
		String query = "select count(*) from users";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.queryForInt(query, paramMap);
	}
	
	public List<Map<String, Object>> getCustomUserData(JqGridBean bean){
		String baseQuery = "select email, name, role from users";
		String ordering = " order by "+bean.getSid()+" "+bean.getSort();
		String limit = " limit "+bean.getStart()+","+bean.getRows();
		String condition = null;
		if(bean.getToolbarSearchQuery()!=null && bean.getToolbarSearchQuery().length()> 0){
			condition = " where "+bean.getToolbarSearchQuery();
		}
		
		String finalQuery = baseQuery +( condition  == null? "":condition )+ordering+limit;
		Map<String, String> paramMap = new HashMap<String, String>();
		return namedParameterJdbcTemplate.queryForList(finalQuery, paramMap);
	}
}
