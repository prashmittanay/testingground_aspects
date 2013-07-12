package testing.ground.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	
	@GET
	@Path("/jqusers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response jqUsers(@Context UriInfo uriInfo){
		MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
		return Response.status(200).entity(processRequest(queryParameters)).build();
	}
	
	
	private Map<String, Object> processRequest(MultivaluedMap<String, String> queryParameters){
		int page = Integer.parseInt(queryParameters.getFirst("page"));
		int limit = Integer.parseInt(queryParameters.getFirst("rows"));
		String id = queryParameters.getFirst("sidx");
		String sort = queryParameters.getFirst("sord");
		
		int total = jqDao.getJqUsersCount();
		int pages = (int) Math.ceil(total/limit);
		int start = page * limit - limit;
		
		List<Map<String, Object>> jqUsers = jqDao.getJqUsers(id, sort, start, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
//		map.put("total", pages);
		map.put("total", 2);
		map.put("records", total);
		map.put("rows", jqUsers);
		return map;
	}
}
