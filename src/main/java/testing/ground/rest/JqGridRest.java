package testing.ground.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testing.ground.dao.JqDao;

@Path("/jqgrid")
@Component
public class JqGridRest {
	@Autowired private JqDao jqDao;
	
	@GET
	@Path("/getallusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		return Response.status(200).entity(jqDao.getUsers()).build();
	}
}
