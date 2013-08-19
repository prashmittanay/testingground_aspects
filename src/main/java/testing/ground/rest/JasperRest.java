package testing.ground.rest;

import javax.sql.DataSource;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Path("/jasper")
public class JasperRest {
	@Autowired DataSource dataSource;
	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
}
