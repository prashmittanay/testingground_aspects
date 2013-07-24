package testing.ground.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import testing.ground.dao.MiscDao;

@Component
@Path("/misc")
public class MiscRest {
	@Autowired MiscDao miscDao;
	
	
	@GET
	@Path("/autocompleteusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutoUsers(@QueryParam("term") String user){
		List<String> autoUsers = miscDao.getAutoUsers(user);
		return Response.status(200).entity(autoUsers).build();
	}
}
