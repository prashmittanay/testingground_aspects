package testing.ground.rest;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.sun.research.ws.wadl.Response;

@Component
@Path("/jasper")
public class JasperRest {
	@Autowired DataSource dataSource;
	@Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@GET
	@Path("/compilefirstreport")
	@Produces(MediaType.APPLICATION_JSON)
	public Response compileFirstReport(){
		
		return null;
	}
}
